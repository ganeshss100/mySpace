package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by gsrinivasagam on 3/15/2019.
 */
class Result {

    /*
     * Complete the 'getShrunkArray' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts following parameters:
     *  1. STRING_ARRAY inputArray
     *  2. INTEGER burstLength
     */

    public static void main(String[] args) {
        String[] inputArray = {"a'","a","a","a","b","b","c"};
        List<String>  list = Arrays.asList(inputArray);
        getShrunkArray(list, 3);
    }

    public static List<String> getShrunkArray(List<String> inputArray, int burstLength) {
        boolean flagBursted = false;
        List<String> newList = new ArrayList<String>();
        for(int i=0;i<inputArray.size();i++)
        {
            int currburstcount = findburstcount(inputArray,i);
            System.out.println(currburstcount);
            if(currburstcount>=burstLength)
            {
                i = i+currburstcount;
                flagBursted=true;
            }
            else
            {
                newList.add(inputArray.get(i));
            }
        }
        if(flagBursted == true){
            return getShrunkArray( newList,burstLength);
        }
        else{
            return inputArray;
        }
    }

    public static int findburstcount(List<String> inputArray, int i)
    {
        int count = 1;
        while(i<inputArray.size() && i+1 < inputArray.size() && inputArray.get(i).equalsIgnoreCase(inputArray.get(i+1)))
        {
            count++;
            i++;
        }
        return count;
    }

}
