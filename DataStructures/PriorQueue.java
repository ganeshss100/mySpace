package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by gsrinivasagam on 2/26/2019.
 */
public class PriorQueue {
    public static void main(String[] args) {
        char[] tasks = {'A','A','A','B','B','B'};
        int n=2;
        leastInterval(tasks,n);
    }

        public static int leastInterval(char[] tasks, int n) {
            int[] map = new int[26];
            for (char c: tasks)
                map[c - 'A']++;
            PriorityQueue< Integer > queue = new PriorityQueue < > (26, Collections.reverseOrder());
            for (int f: map) {
                if (f > 0)
                    queue.add(f);
            }
            int time = 0;
            while (!queue.isEmpty()) {
                int i = 0;
                List< Integer > temp = new ArrayList< >();
                while (i <= n) {
                    if (!queue.isEmpty()) {
                        if (queue.peek() > 1)
                            temp.add(queue.poll() - 1);
                        else
                            queue.poll();
                    }
                    time++;
                    if (queue.isEmpty() && temp.size() == 0)
                        break;
                    i++;
                }
                for (int l: temp)
                    queue.add(l);
            }
            return time;
        }
    }

