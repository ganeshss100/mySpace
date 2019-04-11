package Practice;

import java.util.Scanner;

/**
 * Created by gsrinivasagam on 6/30/2018.
 */
public class primeNumbers {
    public static void main(String[] args) {
        boolean notAPrime = false;
    Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int n= sc.nextInt();
        for (int i=2;i<n;i++){
            if(n%i==0){
                notAPrime = true;
            }
        }
        if(!notAPrime)
        System.out.println("prime");
        else
         System.out.println("Not a prime");

    }
}
