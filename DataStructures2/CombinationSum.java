package main;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gsrinivasagam on 2/27/2019.
 */
public class CombinationSum {
    public static void main(String[] args) {
        int[] candidates = {2,3,6,7};
        int target =7;
        int sum =0;
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        helper(candidates, 0, target, 0, temp, result);
       // combinationSu(candidates,target,sum);
    }

    private static void helper(int[] candidates, int start, int target, int sum,
                        List<Integer> list, List<List<Integer>> result){
        if(sum>target){
            return;
        }

        if(sum==target){
            result.add(new ArrayList<>(list));
            return;
        }

        for(int i=start; i<candidates.length; i++){
            list.add(candidates[i]);
            helper(candidates, i, target, sum+candidates[i], list, result);
            list.remove(list.size()-1);
        }
    }

  /*  public static int[] combinationSu(int[] candidates, int target, int sum){

        if(sum>target)
            //return;

        if(sum==target){

        }
    }*/

}
