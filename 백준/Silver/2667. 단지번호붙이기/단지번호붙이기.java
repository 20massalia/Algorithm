import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;

public class Main {
	static int N;
	static int[][] board;
	static boolean[][] visited;
	static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		board = new int[N][N];
		visited = new boolean[N][N];
		
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < N; j++) {
				board[i][j] = line.charAt(j) - '0';
			}
		}
		
		List<Integer> result = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == 1 && !visited[i][j]) {
                    result.add(dfs(i, j));
                }
            }
        }
        
        Collections.sort(result);
        System.out.println(result.size());
        for (int count : result) System.out.println(count);
	}
	
	static int dfs(int startX, int startY) {
		Deque<int[]> stack = new ArrayDeque<>();
		stack.push(new int[] {startX, startY});
		visited[startX][startY] = true;
		int count = 0;
		
		while (!stack.isEmpty()) {
			int[] curr = stack.pop();
			count++;
			
			for (int d = 0; d < 4; d++) {
				int nx = curr[0] + dx[d];
                int ny = curr[1] + dy[d];

                if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                    if (board[nx][ny] == 1 && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        stack.push(new int[]{nx, ny});
                    }
                }
			}
		}
		
		return count;
	}
}
