package amazon;

import java.util.*;

public class trackServerRequestCapacity {

    public static List<Integer> trackServerRequestCapacity(
            List<Integer> server,
            List<Integer> replaceId,
            List<Integer> newId
    ) {
        Map<Integer, Long> countMap = new HashMap<>();
        long sum = 0;
        for (int id : server) {
            sum += id;
            countMap.put(id, countMap.getOrDefault(id, 0L) + 1);
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < replaceId.size(); i++) {
            int oldId = replaceId.get(i);
            int newIdVal = newId.get(i);
            long cnt = countMap.getOrDefault(oldId, 0L);
            if (cnt > 0 && oldId != newIdVal) {
                sum += cnt * (newIdVal - oldId);
                countMap.remove(oldId);
                countMap.put(newIdVal, countMap.getOrDefault(newIdVal, 0L) + cnt);
            }
            result.add((int) sum);
        }
        return result;
    }
    public static void main(String[] args) {

        int n = 2;
        List<Integer> server = Arrays.asList(20,10);
        List<Integer> replaceId = Arrays.asList(10,20);
        List<Integer> newId = Arrays.asList(20,1);

        List<Integer> ans = trackServerRequestCapacity(server, replaceId, newId);
        System.out.println(ans);
    }

}
