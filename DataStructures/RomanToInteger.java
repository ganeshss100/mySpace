package main;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by gsrinivasagam on 3/2/2019.
 */
public class RomanToInteger {
    public static void main(String[] args) {
        HashMap<Character,Integer> map = new HashMap();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('M',1000);
        String roman = "MCCLV";
        System.out.println(rToI(roman,map));
    }

    public static int rToI(String roman,Map<Character,Integer> map){
        char[] c = roman.toCharArray();
        Stack stack = new Stack();
        int sum=0;
        for(int i=c.length-1;i>=0;i--){
            if(i==0){
                sum+= map.get(c[i]);
                return sum;
            }
           if(!(map.get(c[i-1])<map.get(c[i]))){
            sum += map.get(c[i]);
           }else {
               sum+=map.get(c[i]);
               int temp = i-1;
               while (i>=0 && map.get(c[temp])<map.get(c[i])){
               sum-=map.get(c[i-1]);
                    i--;
               }
           }
        }
        return sum;
    }

}
