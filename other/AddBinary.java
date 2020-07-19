package leetcode.other;

/* https://leetcode.com/problems/add-binary/ */
public class AddBinary {

    public String addBinary(String a, String b) {
        char[] solution = null;
        String calculation;
        if (a.length() < b.length()) {
            solution = b.toCharArray();
            calculation = calculate(solution, a);
        } else {
            solution = a.toCharArray();
            calculation = calculate(solution, b);
        }

        return calculation;
    }

    public String calculate(char[] solution, String a) {
        int carry = 0;
        int i = a.length() - 1;
        int diff = solution.length - a.length();
        for (i = a.length() - 1; i >= 0; i--) {
            if (solution[i + diff] == '1' && a.charAt(i) == '1') {
                if (carry == 1) {
                    solution[i + diff] = '1';
                } else {
                    solution[i + diff] = '0';
                }
                carry = 1;
            } else if ((solution[i + diff] == '1' && a.charAt(i) == '0')
                    || (solution[i + diff] == '0' && a.charAt(i) == '1')) {
                if (carry == 1) {
                    solution[i + diff] = '0';
                    carry = 1;
                } else {
                    solution[i + diff] = '1';
                    carry = 0;
                }
            } else {
                if (carry == 1) {
                    solution[i + diff] = '1';
                } else {
                    solution[i + diff] = '0';
                }
                carry = 0;
            }
        }
        String calculation = "";
        if (carry == 1) {

            for (int b = solution.length - 1 - a.length(); b >= 0; b--) {
                if (solution[b] == '0') {
                    solution[b] = '1';
                    carry = 0;
                    break;
                } else {
                    solution[b] = '0';
                    carry = 1;
                }
            }
            if (carry == 1) {
                char[] s = new char[solution.length + 1];
                s[0] = '1';
                System.arraycopy(solution, 0, s, 1, solution.length);
                calculation = String.valueOf(s);
            } else {
                calculation = String.valueOf(solution);
            }

        } else {
            calculation = String.valueOf(solution);
        }

        return calculation;

    }

    public static void main(String[] args) {
        System.out.println(new AddBinary().addBinary("101111", "10"));
    }

}