package Practice.Graph;

/**
 * Created by gsrinivasagam on 12/29/2018.
 */
public class FriendCirclesGraph {

    public static void main(String[] args) {

        char[][] friends = {"YYNN".toCharArray(), "YYYN".toCharArray(), "NYYN".toCharArray(), "NNNY".toCharArray()};
        System.out.println(getFriendCircles(friends));
    }

    public static int getFriendCircles(char[][] friends) {

        if (friends == null || friends.length < 1)
            return 0;

        int noOfCircles = 0;

        boolean visited[] = new boolean[friends.length];

        for (int i = 0; i < visited.length; i++)
            visited[i] = false;

        for (int i = 0; i < friends.length; i++) {
            if (!visited[i]) {
                noOfCircles++;
                visited[i] = true;
                findFriends(friends, visited, i);
            }
        }

        return noOfCircles;

    }

    public static void findFriends(char[][] friends, boolean[] visited, int id) {

        for (int i = 0; i < friends.length; i++) {
            if (!visited[i] && i != id && 'Y' == friends[id][i]) {
                visited[i] = true;
                findFriends(friends, visited, i);
            }
        }

    }
}
