package leetcode.greedy;

/* https://leetcode.com/problems/can-place-flowers/ */
/* Runtime: 1 ms, faster than 91.24% Memory Usage: 40.3 MB, less than 69.82% */
public class CanPlaceFlowers {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {

        int lenght = flowerbed.length;

        if (lenght > 1 && n > lenght / 2 + 1) {
            return false;
        }

        for (int i = 0; i < lenght; i++) {
            if (flowerbed[i] == 0) {
                if (n == 0) {
                    return true;
                }
                if ((i > 0 && flowerbed[i - 1] == 0) || i == 0) {
                    if ((i + 1 < lenght && flowerbed[i + 1] == 0) || i + 1 == lenght) {
                        flowerbed[i] = 1;
                        n--;
                    }
                }
            }
        }

        return n == 0 ? true : false;
    }

    public static void main(String[] args) {

        int[] flowerbed = { 1, 0, 0, 0, 1, 0, 0 };
        int n = 2;
        System.out.println(new CanPlaceFlowers().canPlaceFlowers(flowerbed, n));
    }
}
