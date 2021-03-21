package leetcode.math;

import java.util.HashMap;

/* https://leetcode.com/problems/reordered-power-of-2/ */
/* Runtime: 1 ms, faster than 96.64% Memory Usage: 35.7 MB, less than 88.24% */
public class ReorderedPowerOf2 {

    static int[] powers = new int[31];
    static {
        int number = 1;
        for (int i = 0; i < 31; i++) {
            powers[i] = number;
            number <<= 1;
        }
    }

    public boolean reorderedPowerOf2(int N) {

        int log10Number = (int) Math.log10(N) + 1;
        HashMap<Integer, Integer> numberDigits = new HashMap<>();
        loadDigits(numberDigits, N);

        for (int power : powers) {
            int log10Power = ((int) Math.log10(power)) + 1;
            if (log10Power == log10Number) {
                HashMap<Integer, Integer> powerDigits = new HashMap<>();
                loadDigits(powerDigits, power);
                for (int digit : numberDigits.keySet()) {

                    Integer countNumber = numberDigits.get(digit);
                    Integer countPower = powerDigits.get(digit);
                    if (countPower != null && countPower == countNumber) {
                        powerDigits.remove(digit);
                        if (powerDigits.isEmpty()) {
                            return true;
                        }
                    } else {
                        break;
                    }

                }

            } else if (log10Power > log10Number) {
                break;
            }
        }

        return false;
    }

    private void loadDigits(HashMap<Integer, Integer> numberDigits, int number) {
        while (number > 0) {
            int digit = number % 10;
            Integer count = numberDigits.get(digit);
            if (count == null) {
                count = 0;
            }
            numberDigits.put(digit, ++count);
            number -= digit;
            number /= 10;
        }

    }

    public static void main(String[] args) {
        System.out.println(new ReorderedPowerOf2().reorderedPowerOf2(56635));
    }
}
