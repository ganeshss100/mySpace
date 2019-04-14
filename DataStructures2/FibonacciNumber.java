package Practice.Array;

/**
 * Created by gsrinivasagam on 2/19/2019.
 */
public class FibonacciNumber {

    public static void main(String[] args) {
        int a = 0, b = 1;
        int c = 0;
        int n = 12;
        System.out.println(b);
        for (int i = 0; i < n; i++) {
            c = a + b;
            System.out.println(c);
            a = b;
            b = c;
        }

    }
}