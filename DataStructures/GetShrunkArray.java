package main;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gsrinivasagam on 3/15/2019.
 */
public class GetShrunkArray {
    public static void main(String[] args) {
        //getShrunkArray();
    }


    public static List<String> getShrunkArray(List<String> inputArray, int burstLength) {
        List<String> list = new ArrayList<>();
        int j=0;
        boolean flag = false;
        for(int i=0;i<inputArray.size();i++){

            while(j<burstLength){
                if(inputArray.get(i+j) == inputArray.get(i)){
                    flag = false;
                    break;
                }else{
                    flag = true;
                }
            }

            if(flag==true){
                System.out.println(inputArray.get(i));
                list.add(i,inputArray.get(i));
            }
        }
        return list;

    }
}
