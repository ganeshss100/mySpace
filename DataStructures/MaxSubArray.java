package main;

/**
 * Created by gsrinivasagam on 3/15/2019.
 */
public class MaxSubArray {
    public static void main(String[] args) {
        int[] a = {2,1,3,4,1,2,1,5,4};
        //[-2,1,-3,4,-1,2,1,-5,4],
        int maxSum   = Integer.MIN_VALUE;

        for (int i = 0; i < a.length; i++) {
            int sum = 0;
            for (int j = i; j< a.length ; j++) {
                sum += a[j];
                maxSum = Math.max(sum, maxSum);
            }
        }
    }
}
