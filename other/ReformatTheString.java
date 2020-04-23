package leetcode.other;

import java.util.ArrayList;

public class ReformatTheString {

    ArrayList<Character> charList = new ArrayList<>();
    ArrayList<Character> numList = new ArrayList<>();

    public String reformat(String s) {
        String solution;

        for (int c : s.toCharArray()) {
            if (c > 96) {
                charList.add((char) c);
            } else {
                numList.add((char) c);
            }
        }

        if (Math.abs(numList.size() - charList.size()) > 1) {
            solution = "";

        } else {
            StringBuilder builder = new StringBuilder();
            if (numList.size() > charList.size()) {

                for (int i = 0; i < numList.size(); i++) {
                    builder.append(numList.get(i));
                    if (charList.size() > i) {
                        builder.append(charList.get(i));
                    }

                }
            } else {
                for (int i = 0; i < charList.size(); i++) {
                    builder.append(charList.get(i));
                    if (numList.size() > i) {
                        builder.append(numList.get(i));
                    }

                }
            }
            solution = builder.toString();
        }

        return solution;

    }

    public static void main(String[] args) {

        String s = "covid2019";

        System.out.println(new ReformatTheString().reformat(s));

    }
}