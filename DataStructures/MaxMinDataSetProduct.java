package Practice.Array;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by gsrinivasagam on 2/19/2019.
 */
class Object1{
int min;
int max;
}


public class MaxMinDataSetProduct {
    static int currentMin = Integer.MIN_VALUE;
    static int currentMax = Integer.MAX_VALUE;
    public static void main(String[] args) {
        List<String> operations = new ArrayList<>();
        List<Integer> elements = new ArrayList<>();
        operations.add("push");
        operations.add("push");
        operations.add("pop");
        operations.add("push");
        operations.add("pop");
        elements.add(1);
        elements.add(3);
        elements.add(2);
        elements.add(4);
        elements.add(6);
        elements.add(5);
        solution(operations,elements);

    }

    public static void solution(List<String> operations, List<Integer> elements)
    {
        Stack<Object1> st = new Stack();
        for(int i=0;i<operations.size();i++)
        {
            if(operations.get(i).equals("push"))
            {
                Object1 a = null;
                if(st.size()!=0)
                    a = st.lastElement();
                Object1 curr = new Object1();
                if(a==null)
                {
                    curr.min = elements.get(i);
                    curr.max = elements.get(i);

                }
                else
                {
                    int x = elements.get(i);
                    if(x<a.min)
                    {
                        curr.min = x;
                    }
                    else
                    {
                        curr.min = a.min;
                    }
                    if(x>a.max)
                    {
                        curr.max = x;

                    }
                    else
                    {
                        curr.max = a.max;
                    }
                }
                System.out.println(curr.min*curr.max);
                st.push(curr);
            }
            else
            {

                if(st.size()==0)
                {
                    System.out.println("No element in stack - pop");
                    continue;
                }
                else {
                    Object1 popele = st.pop();

                    Object1 curr = null;
                    if(st.size()!=0) {
                        curr = st.lastElement();
                    }
                    if (curr == null) {
                        System.out.println("No element in stack - peek");
                        continue;
                    }
                    System.out.println(curr.min * curr.max);
                }
            }
        }

    }

/*    public static Object1 changeMethod(String manipulation,int data) {
        Stack<Object1> stack = new Stack();
        if (manipulation.equalsIgnoreCase("POP")){
            Object1 object1 = stack.pop();
        }

        if (manipulation.equalsIgnoreCase("PUSH")){
        if (data < currentMin) {
            currentMin = data;
        }
        if (data > currentMax) {
            currentMax = data;
        }

        Object1 obj1 = new Object1();
        obj1.min = currentMin;
        obj1.max = currentMax;

        stack.push(obj1);
    }

    }*/

}
