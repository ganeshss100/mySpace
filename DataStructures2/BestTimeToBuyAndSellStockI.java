package main;

/**
 * Created by gsrinivasagam on 3/19/2019.
 */
public class BestTimeToBuyAndSellStockI {
    public static void main(String[] args) {
        int[] prices = {7, 5, 3, 6, 4, 1};
        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        if(prices==null||prices.length<=1)
            return 0;

        int min=prices[0]; // min so far
        int result=0;

        for(int i=1; i<prices.length; i++){
            result = Math.max(result, prices[i]-min);
            min = Math.min(min, prices[i]);
        }

        return result;
    }
}
