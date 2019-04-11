package main;

import java.util.PriorityQueue;

/**
 * Created by gsrinivasagam on 3/2/2019.
 */
public class kthLargest {
    public static void main(String[] args) {
        int[] a =  {7, 10, 4,17, 3, 20, 15,6};
        int k =2;
        System.out.println(kthLarg(a,k));
    }

    public static int kthLarg(int[] nums,int k){
        int currentSum=0;
       /* int currentSum=0;
            for(int i = 0;i<a.length;i++){
                if(a[i]>currentSum){
                    currentSum  = a[i];
                }
            }
            return currentSum;*/
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int i=0;i<nums.length;i++){
            //if(nums[i]>currentSum){
                //currentSum = nums[i];
                queue.add(nums[i]);
            //}
            if(queue.size()>k){
                queue.poll();
            }
        }
        System.out.println(queue);
        return queue.peek();
    }

}
