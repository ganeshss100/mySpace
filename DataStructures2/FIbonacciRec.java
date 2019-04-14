package Practice.Array;

/**
 * Created by gsrinivasagam on 2/19/2019.
 */
public class FIbonacciRec {
    public static void main(String[] args) {

        int n = 12;
        System.out.println(fibonacciRecur(n));
    }
    public static int fibonacciRecur(int n){
        if(n==0||n==1)
            return n;

        return fibonacciRecur(n-1) + fibonacciRecur(n-2);
    }

}

