
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by gsrinivasagam on 2/1/2018.
 */
public class ParseActivityData {

    /* private static List<Long> bankActivities = new ArrayList<>();
     private static List<Long> ccActivities = new ArrayList<>();
     static{
         bankActivities.add(3142l);
         bankActivities.add(1736l);
         bankActivities.add(35l);
         bankActivities.add(36l);
         bankActivities.add(509l);
         bankActivities.add(1110l);
         bankActivities.add(71001l);
         bankActivities.add(106100l);

     }
     public String parseActivityData(String data, Long activityType){
         String parsedData = "";
         try{
             if(bankActivities.contains(activityType)){
                 parsedData = parseBankDetails(data, activityType);
             }
         }catch(Exception exception){

         }
         return parsedData;
     }*/
    public static void main(String[] args) {
        String originalString = /*//"some string with 'the data i want' inside";*/"Card added successfully. Card Number: xxxxxxxxxxxx2728, Brand: MasterCard, Type: Credit Card, Expiry: 3.3/2020";
                //"Card added successfully. Card Number: xxxxxxxxxxxx6714, Brand: Visa, Type: Debit Card, Expiry: 1/2018";
        parseBankDetails(originalString,1l);
    }


    private static void parseBankDetails(String data, Long activityType){
        String parsedData = "";
        //String mydata = "some string with 'the data i want' inside";
       // Pattern pattern = Pattern.compile("Expiry: ([-.]?\\d+(?:\\.\\d +)?)");
        //03-03-2018    0-9{2}-0-9{2}-0-9{4}
      /*---------*-------Pattern pattern = Pattern.compile("Card Number: xxxxxxxxxxxx"+"([0-9\\-\\.\\/]+)");
        Matcher matcher = pattern.matcher(data);
        //data.re
        if (matcher.find())
        {
            System.out.println(matcher.group(1));
        }

        String parsedData = "";----------*---------*----*/

/*       Pattern pattern = Pattern.compile("Card Number: xxxxxxxxxxxx(.*?),");   --------------------
        Matcher matcher = pattern.matcher(data);
        if (matcher.find())
        {
            parsedData = (matcher.group(1));
        }
        Pattern pattern2 = Pattern.compile("Expiry:(.*)");
        Matcher matcher2 = pattern2.matcher(data);
        if (matcher2.find())
        {
            parsedData+= (matcher2.group(1));
        }


        System.out.println(parsedData);
        */

        parsedData = initialValue("Card Number: xxxxxxxxxxxx",data)+" "+ initialValue("Expiry: ",data);
        System.out.println(parsedData);

    }

    public static String initialValue(String startString , String data) {
        String trimmedData = "";
        Pattern pattern = Pattern.compile( startString+"([0-9\\-\\.\\/]+)");//+endString);
        Matcher matcher = pattern.matcher(data);
        if (matcher.find()) {
            trimmedData = (matcher.group(1));
        }
        return trimmedData;
    }
}
