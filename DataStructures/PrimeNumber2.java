package Practice.Java;

import java.io.*;
import java.util.Scanner;

/**
 * Created by gsrinivasagam on 9/19/2018.
 */
public class PrimeNumber {
    public static void main(String[] args) throws IOException {
        FileReader file = new FileReader(new File("C:\\fiel1.txt"));
        BufferedReader reader = new BufferedReader(file);
        String[] text = null;
        int i=0;
        int j=0;
        String words="";
        String s="";
        while((s =reader.readLine())!=null){
            //words = words +s.split(" ");
            words+= s+" ";
            i++;
        }
        //String[] words=null;
       /* for(int k=0;k<words.length;k++){
           // words=text[j].split(" ");
            System.out.println(words[k]);
        }*/
        System.out.println(words);

    }
}
