package leetcode.arrays;

/* https://leetcode.com/problems/pairs-of-songs-with-total-durations-divisible-by-60/ */
/* Runtime: 3 ms, faster than 84.92% */
public class PairsOfSongsWithTotalDurationsDivisibleBy60 {

    int baseMinutes = 60;

    public int numPairsDivisibleBy60(int[] time) {

        int[] mods = new int[baseMinutes];

        for (int i = 0; i < time.length; i++) {
            mods[time[i] % baseMinutes]++;
        }

        int counter = 0;

        for (int i = 0; i < time.length; i++) {
            int mod = time[i] % baseMinutes;
            int modLeft = baseMinutes - mod;
            if (mod == 0 || mod == modLeft) {
                if (mods[mod] > 1) {
                    counter += mods[mod] - 1;
                }
            } else if (mods[modLeft] > 0) {
                counter += mods[modLeft];
            }

        }

        return counter / 2;
    }

    public static void main(String[] args) {

    }
}
