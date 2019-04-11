package Practice;

import java.util.Scanner;

/**
 * Created by gsrinivasagam on 7/2/2018.
 */
public class pyramid {
    public static void main(String[] args) {
        System.out.println("Enter the integer: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i=0;i<=n;i++){
            //System.out.print(" ");
            for(int j=0;j<i;j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
