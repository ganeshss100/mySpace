package Practice.Array;
import java.util.Arrays;
/**
 * Created by gsrinivasagam on 2/18/2019.
 */
public class RotateArray {

    // Rotate array by using reversing operation on the array
    // O(n) time, O(1) space
    public static void rotateArrayUsingReverse(int[] array, int k) {

        if(k < 0) {
            throw new IllegalArgumentException("k cannot be negative!");
        }

        if(array == null || array.length < 2) {
            return;
        }

        int n = array.length;
        if(k > n)
            k = k%n;

        reverseArray(array, 0, k-1);
        reverseArray(array, k, n-1);
        reverseArray(array, 0, n-1);
    }

    // Reverse an array between start (s) and end (e)
    private static void reverseArray(int[] array, int s, int e) {
        while(s < e) {
            int tmp = array[s];
            array[s] = array[e];
            array[e] = tmp;
            s++;
            e--;
        }
    }

    // Solution using temporary array
    // O(n) time, O(k) space
    public static void rotateArrayUsingTmp(int[] array, int k) {
        if(k < 0) {
            throw new IllegalArgumentException("k cannot be negative!");
        }

        if(array == null || array.length < 2) {
            return;
        }

        int n = array.length;
        if(k > n)
            k = k%n;

        int[] tmp = new int[k];
        for(int i = 0; i < k; i++) {
            tmp[i] = array[i];
        }
        for(int i = k; i < n; i++) {
            array[i-k] = array[i];
        }
        for(int i = n - k, j = 0; i < n; i++, j++) {
            array[i] = tmp[j];
        }
    }

    // Naive Solution - O(n*k)
    // Rotate array by using the method rotateArrayOnce k times
    public static void rotateArrayNaive(int[] array, int k) {

        if(k < 0) {
            throw new IllegalArgumentException("k cannot be negative!");
        }

        if(array == null || array.length < 2) {
            return;
        }

        int n = array.length;
        if(k > n)
            k = k%n;

        for(int i = 0; i < k; i++) {
            rotateArrayOnce(array);
        }
    }

    // Rotate array 1 element at a time
    public static void rotateArrayOnce(int[] array) {
        int first = array[0];
        for(int i = 0; i < array.length-1; i++) {
            array[i] = array[i+1];
        }
        array[array.length-1] = first;
    }

    public static void main(String[] args) {
        testArrayRotationNaive();
        testArrayRotationTmp();
        testArrayRotationReverse();
    }

    private static void testArrayRotationNaive() {
        int[] array = {1,2,3,4,5};
        int k = 8;
        System.out.println("Original Array: ");
        System.out.println(Arrays.toString(array));
        rotateArrayNaive(array, k);
        System.out.println("After Rotation " + k + " times using naive algorithm: ");
        System.out.println(Arrays.toString(array));
    }

    private static void testArrayRotationTmp() {
        int[] array = {1,2,3,4,5};
        int k = 8;
        System.out.println("Original Array: ");
        System.out.println(Arrays.toString(array));
        rotateArrayUsingTmp(array, k);
        System.out.println("After Rotation " + k + " times using temporary array: ");
        System.out.println(Arrays.toString(array));
    }

    private static void testArrayRotationReverse() {
        int[] array = {1,2,3,4,5};
        int k = 8;
        System.out.println("Original Array: ");
        System.out.println(Arrays.toString(array));
        rotateArrayUsingReverse(array, k);
        System.out.println("After Rotation " + k + " times using reversal: ");
        System.out.println(Arrays.toString(array));
    }
}
