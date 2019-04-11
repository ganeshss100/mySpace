package rough;

import java.util.*;

/**
 * Created by gsrinivasagam on 6/26/2018.
 */
public class LargestOfThreeNumbers {
    public static void main(String[] args) {
        int a = 5;
        int b = 3;
        int c = 2;
        Map map = new HashMap();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of characters to be used as input: ");
        int numberOfLoops =  sc.nextInt();

        for (int i = 0; i < numberOfLoops; i++) {
            System.out.println("Enter a character  ");
            char chr = sc.next().charAt(0);
            System.out.println("Enter an integer:   ");
            int charInt = sc.nextInt();
            map.put(chr,charInt);
        }


        int n = (a > b && a > c ? a : b > a && b > c ? b : c > a && c > b ? c : 0);
        List list = new ArrayList();

        for (int i = 0; i < n; i++) {
            Set set = new HashSet<String>();
            if (a != 0) {
                set.add("a");
                a--;
            }
            if (b != 0) {
                set.add("b");
                b--;
            }
            if (c != 0) {
                set.add("c");
                c--;
            }
            list.add(set);
        }

        System.out.println(list);
    }
}
