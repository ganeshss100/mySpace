package Practice;

import java.util.Scanner;

/**
 * Created by gsrinivasagam on 6/30/2018.
 */
public class palindrome {
    public static void main(String[] args) {
        System.out.println("Enter a string");
        Scanner sc = new Scanner(System.in);
        String value = sc.next();
        boolean flag = true;
        int j = value.length()-1;
        for(int i=0;i<value.length()/2;i++){
            if(value.charAt(i)!=value.charAt(j)){
                flag = false;
                break;
            }
            j--;
        }
        if(flag){
            System.out.println("it is a palindrome");
        }

    }
}
