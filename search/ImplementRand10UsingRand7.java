package leetcode.search;

/* https://leetcode.com/problems/implement-rand10-using-rand7/ */
public class ImplementRand10UsingRand7 {
    public int rand10() {
        int x = 0;
        int y = 0;
        int index = 0;
        do {
            y = rand7();
            x = rand7();
            index = x + (y - 1) * 7;
        } while (index > 40);
        return 1 + (index - 1) % 10;
    }

    public int rand7() {
        return 0;
    }
}