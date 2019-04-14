import org.apache.commons.lang3.StringUtils;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by gsrinivasagam on 11/23/2017.
 */
public class BitAnd {
    public static void main(String[] args) {
        Set<Long> blockedTransactionFlag = new HashSet<Long>() {{
            add(1L);
            add(64L);
        }};
        Long l1 = 262145l;
        Long l64 = 163904l;
        Long long1 = 1L;
        Long long2 = 64L;

       /* System.out.println("flag 1"+long1.equals(Long.valueOf(l1)));
        System.out.println("flag 64"+long2.equals(Long.valueOf(l64)));*/
        /*System.out.println("flag 1"+blockedTransactionFlag.contains(l1&long1));
        System.out.println("flag 64"+blockedTransactionFlag.contains(l64&long2));*/

        System.out.println((l1&long1) == 1);
        System.out.println((l64&long2) == 64);

       /* System.out.println(65533545L == 65533545);
        System.out.println(65535788L == 65535788);*/

        //String s1 = "System.out.println(\"flag 1\"+blockedTransactionFlag.contains(l1&long1))";

       // StringUtils.replace()
    }
}
