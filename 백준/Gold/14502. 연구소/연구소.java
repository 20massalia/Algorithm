import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
    static int[][] map;
    static int result = 0;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        buildWall(0);
        System.out.println(result);
    }

    static void buildWall(int count) {
        if (count == 3) {
            bfs();
            return;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = 1;
                    buildWall(count + 1);
                    map[i][j] = 0;
                }
            }
        }
    }

    static void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        int[][] copyMap = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                copyMap[i][j] = map[i][j];
                if (copyMap[i][j] == 2) {
                    queue.add(new int[]{i, j});
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = curr[0] + dx[i];
                int ny = curr[1] + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    if (copyMap[nx][ny] == 0) {
                        copyMap[nx][ny] = 2;
                        queue.add(new int[]{nx, ny});
                    }
                }
            }
        }

        countSafety(copyMap);
    }

    static void countSafety(int[][] copyMap) {
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (copyMap[i][j] == 0) count++;
            }
        }
        result = Math.max(result, count);
    }
}
