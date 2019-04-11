package Practice.Java;

/**
 * Created by gsrinivasagam on 1/7/2019.
 */
public class SecurityContextSubStr {
    public static void main(String[] args) {
        String secContext = "{\"scopes\":[\"*\"],\"subjects\":[{\"subject\":{\"auth_state\":\"LOGGEDIN\",\"tenant\":\"venmo\",\"account_number\":\"1299112091957950621\",\"auth_claims\":[\"USERNAME\",\"PASSWORD\"]}}],\"actor\":{\"id\":\"85390\",\"account_number\":\"1299112091957950621\",\"auth_claims\":[\"USERNAME\",\"PASSWORD\"]}}";
        String sec2  =  "scopes:tenant";
        System.out.println(secContext.contains("\"tenant\":\"venmo\""));
    }
}
