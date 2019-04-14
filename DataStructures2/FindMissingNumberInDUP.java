package main;

/**
 * Created by gsrinivasagam on 3/7/2019.
 */
public class FindMissingNumberInDUP {
    public static void main(String[] args) {
        int[] array1 = {9, 7, 8, 5, 4, 6, 2, 3, 1};
        int[] array2 = {2, 3, 4, 9, 1, 8, 5, 6};
        missingNumberInDuplicateArrayUsingSum(array1, array2);
    }

    public static void missingNumberInDuplicateArrayUsingSum(int[] array1, int[] array2) {
        int len = array1.length;
        int len2 = array2.length;
        if (len > len2) {
            findMissingNumberUsingSum(array1, array2);
        } else {
            findMissingNumberUsingSum(array2, array1);
        }
    }

    private static void findMissingNumberUsingSum(int[] array1, int[] array2) {
        int result = 0;
        for (int i = 0; i < array1.length; i++) {
            result += array1[i];
        }
        for (int j = 0; j < array2.length; j++) {
            result -= array2[j];
        }
        System.out.println(result);
    }

}
