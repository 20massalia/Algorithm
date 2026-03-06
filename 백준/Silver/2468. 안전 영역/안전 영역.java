import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int[][] map;
	static boolean[][] visited;
	static int maxRain = 0;
	static int result = 1;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				maxRain = Math.max(maxRain, map[i][j]);
			}
		}
		
		for (int rainHeight = 1; rainHeight < maxRain; rainHeight++) {
			visited = new boolean[N][N];
			int currentSafetyArea = 0;
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] > rainHeight && !visited[i][j]) {
						dfs(i, j, rainHeight);
						currentSafetyArea++;
					}
				}
			}
			
			result = Math.max(result, currentSafetyArea);
		}
		
		System.out.println(result);
	}
	
	static void dfs(int x, int y, int h) {
		Deque<int[]> stack = new ArrayDeque<>();
		stack.push(new int[] {x, y});
		visited[x][y] = true;
		
		while (!stack.isEmpty()) {
			int[] curr = stack.pop();
			
			for (int d = 0; d < 4; d++) {
				int nx = curr[0] + dx[d];
                int ny = curr[1] + dy[d];

                if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                    if (map[nx][ny] > h && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        stack.push(new int[]{nx, ny});
                    }
                }
			}
		}
	}
}
