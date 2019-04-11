package main;

/**
 * Created by gsrinivasagam on 2/20/2019.
 */
public class TwoSum {
    public static void main(String[] args) {
        int[] integers =  {2, 7, 11, 15};
        int target = 17;
        sumEqualVal(integers,target);
    }

    public static void sumEqualVal(int[] integers, int target){
        for (int i=0;i<integers.length;i++){
            for(int j=i+1;j<integers.length;j++){
                if((integers[i] + integers[j])==target){
                    System.out.println(i+" "+j);
                }
            }
        }
    }

}
