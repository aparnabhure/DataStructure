/**
 * https://leetcode.com/problems/defanging-an-ip-address/
 *
 * Given a valid (IPv4) IP address, return a defanged version of that IP address.
 *
 * A defanged IP address replaces every period "." with "[.]".
 *
 *
 *
 * Example 1:
 *
 * Input: address = "1.1.1.1"
 * Output: "1[.]1[.]1[.]1"
 * Example 2:
 *
 * Input: address = "255.100.50.0"
 * Output: "255[.]100[.]50[.]0"
 *
 *
 * Constraints:
 *
 * The given address is a valid IPv4 address.
 */


public class DefangingIPAddress {
    public static void main(String[] args){
        System.out.println(defang("1.1.1.1"));
        System.out.println(defang(".1.1.1"));
        System.out.println(defang("1.1.1."));
        System.out.println(defang("1.-1.1.1"));
        System.out.println(defang("1.a.1.1"));
        System.out.println(defang("1.1.571.1"));
        System.out.println(defang("1.1.1"));
        System.out.println(defang("1..1.1"));
        System.out.println(defang("1.013.1.1"));

    }

    private static String defang(String address){
        if(isValidIP4Address(address)){
            address = address.replace(".", "[.]");
            return address;
        }
        return null;
    }

    private static boolean isValidIP4Address(String address){
        if(address == null || address.isEmpty() || address.startsWith(".") || address.endsWith(".")){
            return false;
        }

        String[] parts = address.split("\\.");
        if(parts.length != 4){
            return false;
        }

        try {
            for (String part : parts) {
                int ipPart = Integer.parseInt(part);
                if (ipPart < 0 || ipPart > 255) {
                    return false;
                }
            }
        }catch (NumberFormatException nfe){
            return false;
        }

        return true;
    }

}
