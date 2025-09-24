package Meta;
import java.util.*;
import java.util.Map.Entry;
public class CloudStorageImpl {

    // -------- Shared filesystem --------
    private final Map<String, Integer> files = new HashMap<>();     // path -> size
    private final Map<String, String>  owner = new HashMap<>();     // path -> userId

    // -------- Users (capacity & usage) --------
    private final Map<String, Integer> capacity = new HashMap<>();  // userId -> cap
    private final Map<String, Integer> used     = new HashMap<>();  // userId -> used

    // -------- Level 4: backups --------
    // userId -> snapshot of files (name -> size)
    private final Map<String, Map<String, Integer>> backups = new HashMap<>();

    private static final String ADMIN = "admin";

    // ========== Level 1 ==========

   // @Override
    public boolean addFile(String name, int size) {
        Objects.requireNonNull(name, "name");
        if (files.containsKey(name)) return false;
        files.put(name, size);
        owner.put(name, ADMIN);
        used.put(ADMIN, used.getOrDefault(ADMIN, 0) + size); // admin unlimited
        return true;
    }

   // @Override
    public Optional<Integer> getFileSize(String name) {
        Objects.requireNonNull(name, "name");
        return Optional.ofNullable(files.get(name));
    }

   // @Override
    public Optional<Integer> deleteFile(String name) {
        Objects.requireNonNull(name, "name");
        Integer sz = files.remove(name);
        if (sz == null) return Optional.empty();
        String who = owner.remove(name);
        if (who != null) used.put(who, used.getOrDefault(who, 0) - sz);
        return Optional.of(sz);
    }

    // ========== Level 2 ==========

    //@Override
    public List<String> getNLargest(String prefix, int n) {
        Objects.requireNonNull(prefix, "prefix");
        if (n <= 0) return Collections.emptyList();

        List<Entry<String,Integer>> matches = new ArrayList<>();
        for (Entry<String,Integer> e : files.entrySet()) {
            if (e.getKey().startsWith(prefix)) matches.add(e);
        }
        if (matches.isEmpty()) return Collections.emptyList();

        matches.sort(
                Comparator.<Entry<String,Integer>, Integer>comparing(Entry::getValue, Comparator.reverseOrder())
                        .thenComparing(Entry::getKey)
        );

        int limit = Math.min(n, matches.size());
        List<String> out = new ArrayList<>(limit);
        for (int i = 0; i < limit; i++) {
            Entry<String,Integer> e = matches.get(i);
            out.add(e.getKey() + "(" + e.getValue() + ")");
        }
        return out;
    }

    // ========== Level 3 ==========

   // @Override
    public boolean addUser(String userId, int capacityBytes) {
        Objects.requireNonNull(userId, "userId");
        if (ADMIN.equals(userId) || capacity.containsKey(userId)) return false;
        capacity.put(userId, capacityBytes);
        used.put(userId, 0);
        return true;
    }

   // @Override
    public Optional<Integer> addFileBy(String userId, String name, int size) {
        Objects.requireNonNull(userId, "userId");
        Objects.requireNonNull(name, "name");
        Integer cap = capacity.get(userId);
        if (cap == null || files.containsKey(name)) return Optional.empty();
        int cur = used.getOrDefault(userId, 0);
        if (size > cap - cur) return Optional.empty();

        files.put(name, size);
        owner.put(name, userId);
        used.put(userId, cur + size);
        return Optional.of(cap - (cur + size));
    }

    //@Override
    public Optional<Integer> mergeUser(String userId1, String userId2) {
        Objects.requireNonNull(userId1, "userId1");
        Objects.requireNonNull(userId2, "userId2");
        if (userId1.equals(userId2)) return Optional.empty();
        if (!capacity.containsKey(userId1) || !capacity.containsKey(userId2)) return Optional.empty();

        // Transfer ownership of user2's files to user1
        for (Map.Entry<String,String> e : owner.entrySet()) {
            if (userId2.equals(e.getValue())) e.setValue(userId1);
        }

        int cap1  = capacity.get(userId1);
        int cap2  = capacity.get(userId2);
        int used1 = used.getOrDefault(userId1, 0);
        int used2 = used.getOrDefault(userId2, 0);

        capacity.put(userId1, cap1 + cap2);
        used.put(userId1, used1 + used2);

        // delete user2 and its backup
        capacity.remove(userId2);
        used.remove(userId2);
        backups.remove(userId2);

        return Optional.of((cap1 + cap2) - (used1 + used2)); // remaining1 + remaining2
    }

    // ========== Level 4 ==========

  //  @Override
    public Optional<Integer> backupUser(String userId) {
        Objects.requireNonNull(userId, "userId");
        if (!userExists(userId)) return Optional.empty();     // <— was capacity.containsKey

        Map<String,Integer> snap = new HashMap<>();
        for (Map.Entry<String,String> e : owner.entrySet()) {
            if (userId.equals(e.getValue())) {
                Integer size = files.get(e.getKey());
                if (size != null) snap.put(e.getKey(), size);
            }
        }
        backups.put(userId, snap); // overwrite previous backup
        return Optional.of(snap.size());
    }

    //@Override
    public Optional<Integer> restoreUser(String userId) {
        Objects.requireNonNull(userId, "userId");
        if (!userExists(userId)) return Optional.empty();     // <— was capacity.containsKey

        // delete all current files of this user
        List<String> current = new ArrayList<>();
        for (Map.Entry<String,String> e : owner.entrySet()) {
            if (userId.equals(e.getValue())) current.add(e.getKey());
        }
        for (String path : current) deleteFile(path);

        Map<String,Integer> snap = backups.get(userId);
        if (snap == null) return Optional.of(0);              // <— returns 0, not empty

        int restored = 0;
        for (Map.Entry<String,Integer> e : snap.entrySet()) {
            String path = e.getKey();
            int size = e.getValue();
            if (files.containsKey(path)) continue;            // name taken by someone else
            files.put(path, size);
            owner.put(path, userId);
            used.put(userId, used.getOrDefault(userId, 0) + size);
            restored++;
        }
        return Optional.of(restored);
    }

    // Add inside CloudStorageImpl
    private boolean userExists(String userId) {
        return ADMIN.equals(userId) || capacity.containsKey(userId);
    }

}


/*
level 1


public final class CloudStorageImpl implements CloudStorage {

    // Maps full file path -> size in bytes
    private final Map<String, Integer> files = new HashMap<>();

    @Override
    public boolean addFile(String name, int size) {
        Objects.requireNonNull(name, "name");
        if (files.containsKey(name)) {
            return false;                // file already exists
        }
        files.put(name, size);
        return true;
    }

    @Override
    public Optional<Integer> getFileSize(String name) {
        Objects.requireNonNull(name, "name");
        return Optional.ofNullable(files.get(name));
    }

    @Override
    public Optional<Integer> deleteFile(String name) {
        Objects.requireNonNull(name, "name");
        Integer removed = files.remove(name);
        return Optional.ofNullable(removed);
    }
}
 */


/*


Level 2


public final class CloudStorageImpl implements CloudStorage {

    private final Map<String, Integer> files = new HashMap<>();

    @Override
    public boolean addFile(String name, int size) {
        Objects.requireNonNull(name, "name");
        if (files.containsKey(name)) return false;
        files.put(name, size);
        return true;
    }

    @Override
    public Optional<Integer> getFileSize(String name) {
        Objects.requireNonNull(name, "name");
        return Optional.ofNullable(files.get(name));
    }

    @Override
    public Optional<Integer> deleteFile(String name) {
        Objects.requireNonNull(name, "name");
        Integer removed = files.remove(name);
        return Optional.ofNullable(removed);
    }

    @Override
    public List<String> getNLargest(String prefix, int n) {
        Objects.requireNonNull(prefix, "prefix");
        if (n <= 0) return Collections.emptyList();

        // Collect matches
        List<Entry<String, Integer>> matches = new ArrayList<>();
        for (Entry<String, Integer> e : files.entrySet()) {
            if (e.getKey().startsWith(prefix)) {
                matches.add(e);
            }
        }
        if (matches.isEmpty()) return Collections.emptyList();

        // Sort: size DESC, then name ASC (lexicographical)
        matches.sort(
            Comparator.<Entry<String, Integer>, Integer>comparing(Entry::getValue, Comparator.reverseOrder())
                      .thenComparing(Entry::getKey)
        );

        // Truncate to n and format "name(size)"
        int limit = Math.min(n, matches.size());
        List<String> out = new ArrayList<>(limit);
        for (int i = 0; i < limit; i++) {
            Entry<String, Integer> e = matches.get(i);
            out.add(e.getKey() + "(" + e.getValue() + ")");
        }
        return out;
    }
}
 */

/*

level 3


public final class CloudStorageImpl implements CloudStorage {

    // Global filesystem: file path -> size
    private final Map<String, Integer> files = new HashMap<>();

    // File ownership: file path -> userId
    private final Map<String, String> owner = new HashMap<>();

    // Users: userId -> capacity and used bytes
    private final Map<String, Integer> capacity = new HashMap<>();
    private final Map<String, Integer> used = new HashMap<>();

    private static final String ADMIN = "admin";

    // ---------- Level 1 ----------

    @Override
    public boolean addFile(String name, int size) {
        Objects.requireNonNull(name, "name");
        if (files.containsKey(name)) return false;
        files.put(name, size);
        owner.put(name, ADMIN);
        // Admin has unlimited capacity, but track usage for completeness
        used.put(ADMIN, used.getOrDefault(ADMIN, 0) + size);
        return true;
    }

    @Override
    public Optional<Integer> getFileSize(String name) {
        Objects.requireNonNull(name, "name");
        return Optional.ofNullable(files.get(name));
    }

    @Override
    public Optional<Integer> deleteFile(String name) {
        Objects.requireNonNull(name, "name");
        Integer sz = files.remove(name);
        if (sz == null) return Optional.empty();
        String who = owner.remove(name);
        if (who != null) {
            used.put(who, used.getOrDefault(who, 0) - sz);
        }
        return Optional.of(sz);
    }

    // ---------- Level 2 ----------

    @Override
    public List<String> getNLargest(String prefix, int n) {
        Objects.requireNonNull(prefix, "prefix");
        if (n <= 0) return Collections.emptyList();

        List<Entry<String, Integer>> matches = new ArrayList<>();
        for (Entry<String, Integer> e : files.entrySet()) {
            if (e.getKey().startsWith(prefix)) matches.add(e);
        }
        if (matches.isEmpty()) return Collections.emptyList();

        // size DESC, then name ASC
        matches.sort(
            Comparator.<Entry<String, Integer>, Integer>comparing(Entry::getValue, Comparator.reverseOrder())
                      .thenComparing(Entry::getKey)
        );

        int limit = Math.min(n, matches.size());
        List<String> out = new ArrayList<>(limit);
        for (int i = 0; i < limit; i++) {
            Entry<String, Integer> e = matches.get(i);
            out.add(e.getKey() + "(" + e.getValue() + ")");
        }
        return out;
    }

    // ---------- Level 3 ----------

    @Override
    public boolean addUser(String userId, int cap) {
        Objects.requireNonNull(userId, "userId");
        if (capacity.containsKey(userId) || ADMIN.equals(userId)) return false;
        capacity.put(userId, cap);
        used.put(userId, 0);
        return true;
    }

    @Override
    public Optional<Integer> addFileBy(String userId, String name, int size) {
        Objects.requireNonNull(userId, "userId");
        Objects.requireNonNull(name, "name");

        Integer cap = capacity.get(userId);
        Integer curUsed = used.get(userId);
        if (cap == null || curUsed == null) return Optional.empty();       // user missing
        if (files.containsKey(name)) return Optional.empty();               // file already exists

        int remaining = cap - curUsed;
        if (size > remaining) return Optional.empty();                      // would exceed capacity

        files.put(name, size);
        owner.put(name, userId);
        used.put(userId, curUsed + size);
        return Optional.of(remaining - size);                               // remaining after add
    }

@Override
public Optional<Integer> mergeUser(String userId1, String userId2) {
    Objects.requireNonNull(userId1, "userId1");
    Objects.requireNonNull(userId2, "userId2");
    if (userId1.equals(userId2)) return Optional.empty();
    if (!capacity.containsKey(userId1) || !capacity.containsKey(userId2)) return Optional.empty();

    // Transfer ownership of user2's files to user1
    for (Map.Entry<String, String> e : owner.entrySet()) {
        if (userId2.equals(e.getValue())) {
            e.setValue(userId1);
        }
    }

    int cap1  = capacity.get(userId1);
    int cap2  = capacity.get(userId2);
    int used1 = used.getOrDefault(userId1, 0);
    int used2 = used.getOrDefault(userId2, 0);

    // After merge: user1's capacity increases by cap2; used increases by used2
    int newCap  = cap1 + cap2;
    int newUsed = used1 + used2;

    capacity.put(userId1, newCap);
    used.put(userId1, newUsed);

    // remove user2
    capacity.remove(userId2);
    used.remove(userId2);

    // Remaining = (cap1 + cap2) - (used1 + used2)
    return Optional.of(newCap - newUsed);
}
}
 */