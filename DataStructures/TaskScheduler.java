package main;

/**
 * Created by gsrinivasagam on 2/25/2019.
 */
public class TaskScheduler {
    public static void main(String[] args) {
        char[] tasks = {'A','A','A','B','B','B'};
        int n =2;
        leastInterval(tasks,2);
    }

    public static int leastInterval(char[] tasks, int k) {
        if (tasks == null || tasks.length == 0) return 0;
        int res = 0;
        int n = tasks.length;
        int[] count = new int[26];
        int[] validIndex  = new int[26];
        for (char c : tasks) {
            count[c - 'A']++;
        }
        int i = 0;
        while (n > 0) {
            int index = find(count, validIndex, i);
            if (index != -1) {
                validIndex[index] = i + k + 1;
                count[index]--;
                n--; // only when found qualified char, decrease the total number
            }
            i++;
            res++;
        }
        return res;
    }
    private static int find(int[] count, int[] validIndex, int curr) {
        int res = -1;
        int max = 0;
        for (int i = 0; i < 26; i++) {
            if (count[i] > max && validIndex[i] <= curr) {
                max = count[i];
                res = i;
            }
        }
        return res;
    }
}
