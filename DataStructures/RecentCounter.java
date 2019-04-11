package main;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by gsrinivasagam on 2/26/2019.
 */
public class RecentCounter {
    static Queue<Integer> q;


    public static void main(String[] args) {
        q = new LinkedList();
        System.out.println(ping(3001));
        System.out.println(ping(5));
        System.out.println(ping(2000));
        ping(990);

    }

    public static int ping(int t) {
        q.add(t);
        while (q.peek() < t - 3000)
            q.poll();
        return q.size();
    }
}
