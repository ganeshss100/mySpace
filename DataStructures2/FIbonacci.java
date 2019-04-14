package Practice;

/**
 * Created by gsrinivasagam on 6/28/2018.
 */
public class FIbonacci {
    public static void main(String[] args) {
    //0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987
        int n =10;
        int sum =0;
        int n1 = 0;
        int n2 =1;
        int n3 ;
        System.out.println(n1);
        System.out.println(n2);
        for(int i=0;i<n;i++){
            n3 = n1+n2;
            System.out.println(n3);
            n1=n2;
            n2=n3;
        }

    }
}
