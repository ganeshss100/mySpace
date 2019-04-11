/**
 * Created by gsrinivasagam on 3/7/2018.
 */

class Box{ int n = 0;}

public class newClass {
    public static void main(String[] args) {
        Box b1 = new Box();
        Box b2 = new Box();
        b1.n=1;
        b2 = b1;
        String s = "fgsdgggggggj";
        System.out.println(s.replace('g','w'));
    }
}
