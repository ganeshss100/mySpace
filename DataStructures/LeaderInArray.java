package main;

/**
 * Created by gsrinivasagam on 2/21/2019.
 */
public class LeaderInArray {
    public static void main(String[] args) {
        int[] arr = { 98, 23, 54, 12, 20, 7, 27 };
        int max = 0;
        for(int i = arr.length-1;i>=0;i--){
            if(arr[i]>max){
                System.out.println(arr[i]);
                max = arr[i];
            }
        }
    }

}
