import java.util.*;
import java.io.*;

public class Main {
    static int n, k;
    static String[] cards;
    static boolean[] visited;
    static HashSet<String> resultSet = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());
        
        cards = new String[n];
        visited = new boolean[n];
        
        for (int i = 0; i < n; i++) {
            cards[i] = br.readLine();
        }

        dfs(0, "");

        System.out.println(resultSet.size());
    }

    private static void dfs(int depth, String currentPath) {
        if (depth == k) {
            resultSet.add(currentPath);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(depth + 1, currentPath + cards[i]); 
                visited[i] = false;
            }
        }
    }
}