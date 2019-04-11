package rough;

/**
 * Created by gsrinivasagam on 4/18/2018.
 */
public class IpToLong {
    public static String IP_ADDRESS_SEPERATOR = "\\.";

    public static void main(String[] args) {
        String ipAddress  = "190.28.103.130";
        System.out.println("last index"+ipAddress.substring(0,ipAddress.lastIndexOf('.')));
        //System.out.println(ipToLong("190.28.103.130"));


    }

    public static long ipToLong(String ipAddress) {

        String[] addrArray = ipAddress.split(IP_ADDRESS_SEPERATOR);

        long num = 0;
        for (int i = 0; i < addrArray.length; i++) {
            int power = 3 - i;
            num += ((Integer.parseInt(addrArray[i]) % 256 * Math.pow(256, power)));
        }
        return num;

    }
}
