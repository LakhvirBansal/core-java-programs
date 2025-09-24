package amazon;

public class findTime {
    public static int findTime(String genome, char mutation) {
        int last = -1;    // index of the last seen mutation
        int res  = 0;     // max gap between mutations or from start

        for (int i = 0, n = genome.length(); i < n; i++) {
            if (genome.charAt(i) == mutation) {
                if (last < 0) {
                    // first mutation eats everything before it
                    res = Math.max(res, i);
                } else {
                    // subsequent mutation eats the gap since previous
                    res = Math.max(res, i - last);
                }
                last = i;
            }
        }
        return res;
    }
}
