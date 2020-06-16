package leetcode.other;

/* https://leetcode.com/problems/validate-ip-address */
public class ValidateIPAddress {
    static final String IPV6 = "IPv6";
    static final String IPV4 = "IPv4";
    static final String NA = "Neither";

    public String validIPAddress(String IP) {

        IP = IP.toLowerCase();

        String[] ipv4 = IP.split("\\.");

        String[] ipv6 = IP.split(":");

        if (ipv4.length > 1 && ipv6.length > 1) {
            return NA;
        }

        if (ipv4.length == 4) {
            int dotCount = 0;
            for (char c : IP.toCharArray()) {
                if (c == '.') {
                    dotCount++;
                }
            }
            if (dotCount > 3) {
                return NA;
            }
            for (String block : ipv4) {
                if (block.length() > 1 && block.startsWith("0")) {
                    return NA;
                }
                if (block.startsWith("-")) {
                    return NA;
                }
                int num = 0;
                try {
                    num = Integer.valueOf(block);

                } catch (Exception e) {
                    return NA;
                }
                if (num < 0 || num > 255) {
                    return NA;
                }
            }
            return IPV4;
        } else if (ipv4.length > 1) {
            return NA;
        }

        if (ipv6.length == 8) {

            int colonCount = 0;
            for (char c : IP.toCharArray()) {
                if (c == ':') {
                    colonCount++;
                }
            }
            if (colonCount > 7) {
                return NA;
            }

            for (String block : ipv6) {
                if (block.isEmpty() || block.length() > 4) {
                    return NA;
                }

                for (char c : block.toCharArray()) {
                    if (c != 'a' && c != 'b' && c != 'c' && c != 'd' && c != 'e' && c != 'f' && c != '0' && c != '1'
                            && c != '2' && c != '3' && c != '4' && c != '5' && c != '6' && c != '7' && c != '8'
                            && c != '9') {
                        return NA;
                    }
                }

            }
            return IPV6;
        } else {
            return NA;
        }

    }

    public static void main(String[] args) {
        String ip = "0.0.0.-0";
        // String ip = "192.0.0.1";
        // String ip = "2001:0db8:85a3:0:0:8A2E:0370:7334:";
        // String ip = "2001:0db8:85a3:0:0:8A2E:0370:7334";
        // String ip = "256.256.256.256";
        // String ip = "172.16.254.1";
        // String ip = "2001:0db8:85a3:0000:0000:8a2e:0370:7334";
        System.out.println(new ValidateIPAddress().validIPAddress(ip));
    }

}