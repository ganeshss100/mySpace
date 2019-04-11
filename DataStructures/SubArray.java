package rough;

/**
 * Created by gsrinivasagam on 6/11/2018.
 */
public class SubArray {
    public static void main(String[] args) {
        int arr[] =  {1,8,4,2,3};//{5,6,1,4,3,2,1,4}; {3,2,1,9,5,6,8}

        int min =0;
        int max=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>arr[arr.length-1]){
                min=i;
                max=arr.length-1;
                break;
            }
        }

        for(int i=min;i<max;i++){
            System.out.print(arr[i]+", ");
        }
    }

}
