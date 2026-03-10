// 알파벳
import java.io.*;
import java.util.*;

public class Main {
	static int R, C;
	static char[][] board;
	static boolean[] checked = new boolean[26];
	static int result;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		board = new char[R][C];
		
		for (int i = 0; i < R; i++) {
			board[i] = br.readLine().toCharArray();
		}
		
		checked[board[0][0] - 'A'] = true;
		
		dfs(0, 0, 1);
		
		System.out.println(result);
	}
	
	static void dfs(int x, int y, int dist) {
		Deque<int[]> stack = new ArrayDeque<>();
		stack.add(new int[] {x, y});
		
		while (!stack.isEmpty()) {
			int[] curr = stack.pop();
			for (int i = 0; i < 4; i++) {
				int nx = curr[0] + dx[i];
				int ny = curr[1] + dy[i];
				
				if (nx >= 0 && ny >= 0 && nx < R && ny < C) {
		            int nextAlpha = board[nx][ny] - 'A';
		            
		            if (!checked[nextAlpha]) {
		                checked[nextAlpha] = true;
		                dfs(nx, ny, dist + 1);
		                checked[nextAlpha] = false;
		            }
		        }
			}
		}
		
		result = Math.max(result, dist);
	}
}
