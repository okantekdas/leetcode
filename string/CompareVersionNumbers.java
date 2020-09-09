package leetcode.string;

public class CompareVersionNumbers {
    public int compareVersion(String version1, String version2) {

        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");

        int minIndex = Math.min(v1.length, v2.length);

        int i = 0;
        for (; i < minIndex; i++) {
            int ver1 = Integer.valueOf(v1[i]);
            int ver2 = Integer.valueOf(v2[i]);

            if (ver1 < ver2) {
                return -1;
            }
            if (ver1 > ver2) {
                return 1;
            }
        }

        String[] longVer;
        boolean isV1Longer = false;
        if (v1.length < v2.length) {
            longVer = v2;
        } else {
            longVer = v1;
            isV1Longer = true;

        }

        for (int j = i; j < longVer.length; j++) {
            if (Integer.valueOf(longVer[j]) > 0) {
                if (isV1Longer) {
                    return 1;
                }
                return -1;
            }
        }

        return 0;
    }

    public static void main(String[] args) {

        String version1 = "1.0.1";
        String version2 = "1";
        System.out.println(new CompareVersionNumbers().compareVersion(version1, version2));
    }
}
