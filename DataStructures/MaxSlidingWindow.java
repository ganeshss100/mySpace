package main;

import java.util.LinkedList;

/**
 * Created by gsrinivasagam on 3/15/2019.
 */
public class MaxSlidingWindow {
    public static void main(String[] args) {
        int[] arr = {1,3,-1,-3,5,3,6,7};
                int k = 3;
        maxSlidingWindow(arr,k);
    }

    public static int[] maxSlidingWindow(int[] arr, int k) {
        if(arr==null||arr.length==0)
            return new int[0];

        int[] result = new int[arr.length-k+1];

        LinkedList<Integer> queue = new LinkedList<Integer>();
        for(int i=0; i<arr.length; i++){
            if(!queue.isEmpty()&&queue.peekFirst()==i-k)
                queue.poll();

            while(!queue.isEmpty()&&arr[queue.peekLast()]<arr[i]){
                queue.removeLast();
            }

            queue.offer(i);

            if(i+1>=k)
                result[i+1-k]=arr[queue.peek()];
        }

        return result;
    }
}
