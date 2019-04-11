package main;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by gsrinivasagam on 2/25/2019.
 */
public class NextGreaterElement {
    public static void main(String[] args) {
        int[] findNums = {4,1,2};
        int[] nums = {1,3,4,2};
        nextGreaterElement(findNums,nums);
    }

    public static int[] nextGreaterElement(int[] findNums, int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();

        for (int num : nums) {
            while (!stack.isEmpty() && stack.peek() < num) {
                map.put(stack.pop(), num);
            }
            stack.push(num);
        }

        int[] res = new int[findNums.length];
        for (int i = 0; i < findNums.length; i++) {
            res[i] = map.getOrDefault(findNums[i], -1);
        }
        for(int re: res)
        System.out.println(re);
        return res;
    }
}
