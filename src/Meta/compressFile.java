package Meta;

import java.util.*;
public class compressFile {


    /**
     *
     * part 4 of the problem
     */
    private static final String COMPRESSED_SUFFIX = ".COMPRESSED";
   // @Override
//    public Optional<Integer> compressFile(String userId, String name) {
//        // must exist and belong to userId; name is guaranteed not to end with .COMPRESSED
//        FileEntry fe = files.get(name);
//        if (fe == null || !fe.owner.equals(userId)) return Optional.empty();
//
//        String compressed = name + COMPRESSED_SUFFIX;
//        if (files.containsKey(compressed)) return Optional.empty(); // avoid collision
//
//        int newSize = fe.size / 2; // sizes are even per spec
//
//        // update owner's usage (admin has unlimited; we don't track admin in users)
//        if (!ADMIN.equals(userId)) {
//            User u = users.get(userId);
//            if (u == null) return Optional.empty();
//            u.used = u.used - fe.size + newSize;              // always decreases or equal
//        }
//
//        files.remove(name);
//        files.put(compressed, new FileEntry(newSize, userId));
//
//        if (ADMIN.equals(userId)) return Optional.of(Integer.MAX_VALUE); // unused in tests
//        User u = users.get(userId);
//        return Optional.of(u.capacity - u.used);
//    }
//
//    //@Override
//    public Optional<Integer> decompressFile(String userId, String name) {
//        // name is guaranteed to end with .COMPRESSED
//        FileEntry fe = files.get(name);
//        if (fe == null || !fe.owner.equals(userId)) return Optional.empty();
//
//        String original = name.endsWith(COMPRESSED_SUFFIX)
//                ? name.substring(0, name.length() - COMPRESSED_SUFFIX.length())
//                : null;
//        if (original == null || files.containsKey(original)) return Optional.empty();
//
//        int newSize = fe.size * 2;
//
//        if (!ADMIN.equals(userId)) {
//            User u = users.get(userId);
//            if (u == null) return Optional.empty();
//            // check capacity before mutating anything
//            if (u.used - fe.size + newSize > u.capacity) return Optional.empty();
//
//            u.used = u.used - fe.size + newSize;
//        }
//
//        files.remove(name);
//        files.put(original, new FileEntry(newSize, userId));
//
//        if (ADMIN.equals(userId)) return Optional.of(Integer.MAX_VALUE); // unlimited
//        User u = users.get(userId);
//        return Optional.of(u.capacity - u.used);
//    }
}
