package rough;

/**
 * Created by gsrinivasagam on 3/5/2019.
 */
public class StringToJson {
    public static void main(String[] args) {
        String s = "{\"version\":\"1.2\",\"actor\":{\"client_id\":\"AYxSef8wNXn6JNjjuiluQWN1F9qa2RHYnkx0aKqpPyZyFWTO6559hikB74xQCiswwU_UsYKEpjgr56qE\",\"id\":\"9003007\",\"auth_claims\":[\"CLIENT_ID_SECRET\"],\"auth_state\":\"LOGGEDIN\",\"account_number\":\"1324940166059637419\",\"encrypted_account_number\":\"KP9C3ZXWARJUU\",\"party_id\":\"1324940166059637419\",\"user_type\":\"API_CALLER\",\"tenant_context\":{\"tenant_name\":\"VENMO\",\"tenant_id\":\"37ceb41a-92fb-40cd-821f-67a362005d61\"}},\"auth_token\":\"A0055.fI3AWRU0fo9ExrHaBakPvSaCDzlhOWewhe1AzBxM4\",\"auth_token_type\":\"ACCESS_TOKEN\",\"global_session_id\":\"I575dda41-9e6a-4862-b285-7945c9a2efc4\",\"last_validated\":1544681526,\"scopes\":[\"https://uri.paypal.com/services/paypalattributes/business\",\"phone\",\"email\",\"address\",\"https://uri.paypal.com/services/payments/onetouchpayment\",\"openid\",\"https://uri.paypal.com/services/paypalattributes\",\"https://uri.paypal.com/services/customer/onboarding/user\",\"profile\"],\"client_id\":\"AafBGhBphJ66SHPtbCMTsH1q2HQC2lnf0ER0KWAVSsOqsAtVfnye5Vc8hAOC\",\"app_id\":\"APP-36654367K9772480E\",\"claims\":{\"actor_payer_id\":\"SZEKQNBKSSQ8L\",\"subject_payer_id\":\"AE8J4H9SJPRV4\",\"internal_application\":\"true\"},\"subjects\":[{\"subject\":{\"auth_claims\":[\"DEVICE_TOKEN\"],\"auth_state\":\"REMEMBERED\",\"account_number\":\"1928881390188234932 \",\"encrypted_account_number\":\"{{payer_id}}\",\"party_id\":\"1690349863649454202\",\"authenticating_user\":true,\"user_type\":\"CONSUMER\",\"tenant_context\":{\"tenant_name\":\"VENMO\",\"tenant_id\":\"37ceb41a-92fb-40cd-821f-67a362005d61\"},\"account_access_privilege\":{\"access_class\":\"GUEST\",\"account_owner\":false,\"type\":\"ANONYMOUS\"}},\"features\":[]},{\"subject\":{\"client_id\":\"ATbLXiNz9KcJTlKfiWO9zPIhGgSQ01DejrHD1Sm1HO4vU1KVsaihNA0tXx6yqHjePZhVxRofU6EUViW1\",\"id\":\"245285\",\"auth_claims\":[\"CLIENT_ID\"],\"auth_state\":\"IDENTIFIED\",\"account_number\":\"1324940166059637419\",\"encrypted_account_number\":\"SZEKQNBKSSQ8L\",\"party_id\":\"1324940166059637419\",\"user_type\":\"MERCHANT\"},\"features\":[]}],\"signature\":\"eyJhbGciOiJSUzI1NiIsImtpZCI6ImF1dGhfc2VjdXJpdHlfY29udGV4dF9zaWduX2tleSJ9.eyJpYXQiOiIxNTQ0NjgxNTI5IiwiZXhwIjoiMTU0NDcxMDMyOSIsInNoYTI1Nl9kaWdlc3QiOiJ5bGZJM3E2aFN1dC15UkF4NEhQb0V6enROQWdZdDFvcXRpYjhtSmF6VkFVIn0.MLU6z_HpG-sWew6Hl4Y2h9Y0TvbTeNmyItE3FqAFvdbZguWAKOlselSSnG3AsTOp6yevvP8_BzSIfcAMBzLcdMv3vKY1qolI3MkTpIYseBOIGtNQRVjU1nnXh5f4QDUTCFEQbhSe3SGk_i9osryrrCY6Q_3m58P8082VNvNX1QI\"}";
        /*Gson g = new Gson();
        Player p = g.fromJson(jsonString, Player.class)*/


        // Json json = new Json(s);
        // JSONParser parser = new JSONParser();
        //JSONObject json = (JSONObject) parser.parse(s);
    }
}
