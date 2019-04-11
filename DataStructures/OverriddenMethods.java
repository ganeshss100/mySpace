package Practice.Java;

/**
 * Created by gsrinivasagam on 9/19/2018.
 */
import java.io.*;
class Parent{
    void msg()throws RuntimeException, IOException {System.out.println("parent");}
}

class OverriddenMethods extends Parent{
    void msg()throws IOException{
        System.out.println("   overriding success");
    }
    public static void main(String args[]) throws IOException {
        Parent p=new OverriddenMethods();
        p.msg();
    }
}
