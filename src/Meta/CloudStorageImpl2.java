package Meta;

import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;
public class CloudStorageImpl2 {


    private static final String ADMIN = "admin";

    private static final class FileEntry {
        final int size;
        final String owner;
        FileEntry(int size, String owner) { this.size = size; this.owner = owner; }
    }
    private static final class User {
        int capacity;
        int used;
        User(int capacity) { this.capacity = capacity; this.used = 0; }
    }

    // Storage and users
    private final Map<String, FileEntry> files = new HashMap<>();
    private final Map<String, User> users = new HashMap<>();

    /* ===================== Level 1 ===================== */

   // @Override
    public boolean addFile(String name, int size) {
        if (name == null || name.isEmpty() || size < 0) return false;
        if (files.containsKey(name)) return false;
        // Files added via Level-1 API are owned by admin (unlimited capacity)
        files.put(name, new FileEntry(size, ADMIN));
        return true;
    }

   // @Override
    public boolean copyFile(String nameFrom, String nameTo) {
        if (nameFrom == null || nameTo == null ||
                nameFrom.isEmpty() || nameTo.isEmpty()) return false;

        FileEntry src = files.get(nameFrom);
        if (src == null) return false;                // source not found
        if (files.containsKey(nameTo)) return false;  // destination exists

        // Preserve ownership and enforce that owner's capacity (admin is unlimited)
        if (!ADMIN.equals(src.owner)) {
            User owner = users.get(src.owner);
            if (owner == null) return false;          // inconsistent, but be safe
            if (owner.used + src.size > owner.capacity) return false;
            owner.used += src.size;
        }
        files.put(nameTo, new FileEntry(src.size, src.owner));
        return true;
    }

    //@Override
    public Optional<Integer> getFileSize(String name) {
        FileEntry fe = files.get(name);
        return (fe == null) ? Optional.empty() : Optional.of(fe.size);
    }

    /* ===================== Level 2 ===================== */

   // @Override
    public List<String> findFile(String prefix, String suffix) {
        String p = (prefix == null) ? "" : prefix;
        String s = (suffix == null) ? "" : suffix;

        List<Entry<String, FileEntry>> matches = new ArrayList<>();
        for (Entry<String, FileEntry> e : files.entrySet()) {
            String n = e.getKey();
            if (n.startsWith(p) && n.endsWith(s)) matches.add(e);
        }

        matches.sort((a, b) -> {
            int bySize = Integer.compare(b.getValue().size, a.getValue().size);
            return (bySize != 0) ? bySize : a.getKey().compareTo(b.getKey());
        });

        List<String> out = new ArrayList<>(matches.size());
        for (Entry<String, FileEntry> e : matches) {
            out.add(e.getKey() + "(" + e.getValue().size + ")");
        }
        return out;
    }

    /* ===================== Level 3 ===================== */

   // @Override
    public boolean addUser(String userId, int capacity) {
        if (userId == null || userId.isEmpty()) return false;
        if (ADMIN.equals(userId)) return false; // keep admin unlimited & implicit
        if (users.containsKey(userId)) return false;
        users.put(userId, new User(capacity));
        return true;
    }

    //@Override
    public Optional<Integer> addFileBy(String userId, String name, int size) {
        if (name == null || name.isEmpty() || size < 0) return Optional.empty();
        User u = users.get(userId);
        if (u == null) return Optional.empty();
        if (files.containsKey(name)) return Optional.empty();
        if (u.used + size > u.capacity) return Optional.empty();

        files.put(name, new FileEntry(size, userId));
        u.used += size;
        return Optional.of(u.capacity - u.used);
    }

    //@Override
    public Optional<Integer> updateCapacity(String userId, int capacity) {
        User u = users.get(userId);
        if (u == null) return Optional.empty();

        // Collect this user's files
        List<Entry<String, FileEntry>> owned = files.entrySet().stream()
                .filter(e -> e.getValue().owner.equals(userId))
                .collect(Collectors.toList());

        // Sort by size desc, name lexicographically (ascending) on tie
        owned.sort((a, b) -> {
            int bySize = Integer.compare(b.getValue().size, a.getValue().size);
            return (bySize != 0) ? bySize : a.getKey().compareTo(b.getKey());
        });

        int removed = 0;
        int usedNow = u.used;

        for (Entry<String, FileEntry> e : owned) {
            if (usedNow <= capacity) break;
            files.remove(e.getKey());
            usedNow -= e.getValue().size;
            removed++;
        }

        u.used = usedNow;
        u.capacity = capacity;
        return Optional.of(removed);
    }

    private static final String COMPRESSED_SUFFIX = ".COMPRESSED";
    //@Override
    public Optional<Integer> compressFile(String userId, String name) {
        // must exist and belong to userId; name is guaranteed not to end with .COMPRESSED
        FileEntry fe = files.get(name);
        if (fe == null || !fe.owner.equals(userId)) return Optional.empty();

        String compressed = name + COMPRESSED_SUFFIX;
        if (files.containsKey(compressed)) return Optional.empty(); // avoid collision

        int newSize = fe.size / 2; // sizes are even per spec

        // update owner's usage (admin has unlimited; we don't track admin in users)
        if (!ADMIN.equals(userId)) {
            User u = users.get(userId);
            if (u == null) return Optional.empty();
            u.used = u.used - fe.size + newSize;              // always decreases or equal
        }

        files.remove(name);
        files.put(compressed, new FileEntry(newSize, userId));

        if (ADMIN.equals(userId)) return Optional.of(Integer.MAX_VALUE); // unused in tests
        User u = users.get(userId);
        return Optional.of(u.capacity - u.used);
    }

   // @Override
    public Optional<Integer> decompressFile(String userId, String name) {
        // name is guaranteed to end with .COMPRESSED
        FileEntry fe = files.get(name);
        if (fe == null || !fe.owner.equals(userId)) return Optional.empty();

        String original = name.endsWith(COMPRESSED_SUFFIX)
                ? name.substring(0, name.length() - COMPRESSED_SUFFIX.length())
                : null;
        if (original == null || files.containsKey(original)) return Optional.empty();

        int newSize = fe.size * 2;

        if (!ADMIN.equals(userId)) {
            User u = users.get(userId);
            if (u == null) return Optional.empty();
            // check capacity before mutating anything
            if (u.used - fe.size + newSize > u.capacity) return Optional.empty();

            u.used = u.used - fe.size + newSize;
        }

        files.remove(name);
        files.put(original, new FileEntry(newSize, userId));

        if (ADMIN.equals(userId)) return Optional.of(Integer.MAX_VALUE); // unlimited
        User u = users.get(userId);
        return Optional.of(u.capacity - u.used);
    }

}

/*

level 1



public class CloudStorageImpl implements CloudStorage {

    // in-memory store: absolute file name/path -> size in bytes
    private final Map<String, Integer> files = new HashMap<>();

    @Override
    public boolean addFile(String name, int size) {
        if (name == null || name.isEmpty() || size < 0) return false;
        if (files.containsKey(name)) return false;     // file already exists
        files.put(name, size);
        return true;
    }

    @Override
    public boolean copyFile(String nameFrom, String nameTo) {
        if (nameFrom == null || nameTo == null ||
            nameFrom.isEmpty() || nameTo.isEmpty()) return false;

        Integer srcSize = files.get(nameFrom);
        if (srcSize == null) return false;            // source doesn't exist (or is a dir not tracked)
        if (files.containsKey(nameTo)) return false;  // destination already exists

        files.put(nameTo, srcSize);                   // copy size metadata
        return true;
    }

    @Override
    public Optional<Integer> getFileSize(String name) {
        Integer size = files.get(name);
        return (size == null) ? Optional.empty() : Optional.of(size);
    }
}
 */


/*

level 2

public class CloudStorageImpl implements CloudStorage {

    // in-memory store: absolute path -> size in bytes
    private final Map<String, Integer> files = new HashMap<>();

    @Override
    public boolean addFile(String name, int size) {
        if (name == null || name.isEmpty() || size < 0) return false;
        if (files.containsKey(name)) return false;
        files.put(name, size);
        return true;
    }

    @Override
    public boolean copyFile(String nameFrom, String nameTo) {
        if (nameFrom == null || nameTo == null ||
            nameFrom.isEmpty() || nameTo.isEmpty()) return false;

        Integer src = files.get(nameFrom);
        if (src == null) return false;              // source doesn't exist
        if (files.containsKey(nameTo)) return false; // destination exists

        files.put(nameTo, src);                      // copy metadata
        return true;
    }

    @Override
    public Optional<Integer> getFileSize(String name) {
        Integer sz = files.get(name);
        return (sz == null) ? Optional.empty() : Optional.of(sz);
    }

    @Override
    public List<String> findFile(String prefix, String suffix) {
        String p = (prefix == null) ? "" : prefix;
        String s = (suffix == null) ? "" : suffix;

        List<Entry<String,Integer>> matches = new ArrayList<>();
        for (Entry<String,Integer> e : files.entrySet()) {
            String n = e.getKey();
            if (n.startsWith(p) && n.endsWith(s)) matches.add(e);
        }

        // sort by size desc, then name lexicographically asc
        matches.sort((a, b) -> {
            int bySize = Integer.compare(b.getValue(), a.getValue());
            return (bySize != 0) ? bySize : a.getKey().compareTo(b.getKey());
        });

        List<String> out = new ArrayList<>(matches.size());
        for (Entry<String,Integer> e : matches) {
            out.add(e.getKey() + "(" + e.getValue() + ")");
        }
        return out;
    }
}

 */
