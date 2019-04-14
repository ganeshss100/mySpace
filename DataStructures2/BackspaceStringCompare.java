package main;

import java.util.Stack;

/**
 * Created by gsrinivasagam on 2/25/2019.
 */
public class BackspaceStringCompare {
    public static void main(String[] args) {
        System.out.println( backspaceCompare("ab#c","ad#c"));
            String s = "sfvf";

    }

    public static boolean backspaceCompare(String S, String T) {
        return build(S).equals(build(T));
    }

    public static String build(String S) {
        Stack s = new Stack();
        for(Character c: S.toCharArray()){
            if(c!='#'){
                s.push(c);
            }else if(!s.empty()){
                s.pop();
            }
        }
        return String.valueOf(s);
    }
}
