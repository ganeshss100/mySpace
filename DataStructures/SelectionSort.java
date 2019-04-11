package Algo;

/**
 * Created by gsrinivasagam on 2/15/2018.
 */
public class SelectionSort {
    public static void main(String[] args) {

        int temp;
        int a[] = {12, 35, 87, 26, 9, 28, 7};
        for (int i = 0; i < a.length;i++ ) {
            for (int j=i+1;j<=a.length;j++) {
                if(a[j]<a[i]){
                 temp = a[i];
                 a[i] = a[j];
                 a[j] = temp;
                }
            }
        }
    }
}
