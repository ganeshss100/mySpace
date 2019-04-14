import org.apache.commons.lang3.text.WordUtils;

import java.util.Scanner;


/**
 * Created by gsrinivasagam on 12/7/2017.
 */
public class ArrayDS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        for (int i = n-1; i >= 0; i--) {
            System.out.print(arr[i]+" ");
        }
        //WordUtils.wrap()

    }
}
