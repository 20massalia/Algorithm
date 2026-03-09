import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static char[][] map;
	static boolean[][] visited;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		visited = new boolean[N][N];
		int notColorBlindCount = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j]) {
					dfs(i, j, map[i][j], false);
					notColorBlindCount++;
				}
			}
		}
		
		visited = new boolean[N][N]; 
		int colorBlindCount = 0;
		for (int i = 0; i < N; i++) {
		    for (int j = 0; j < N; j++) {
		        if (!visited[i][j]) {
		            dfs(i, j, map[i][j], true);
		            colorBlindCount++;
		        }
		    }
		}
		
		System.out.println(notColorBlindCount + " " + colorBlindCount);
	}
	
	static void dfs(int x, int y, char color, boolean isCB) {
	    Deque<int[]> stack = new ArrayDeque<>();
	    stack.push(new int[]{x, y});
	    visited[x][y] = true;
	    
	    while (!stack.isEmpty()) {
	    	int[] curr = stack.pop();
	    	
	    	for (int i = 0; i < 4; i++) {
	    		int nx = curr[0] + dx[i];
	            int ny = curr[1] + dy[i];

	            if (nx < 0 || ny < 0 || nx >= N || ny >= N || visited[nx][ny]) continue;
	            
	            boolean isSame = false;
	            
	            if (!isCB) {
	            	if (map[nx][ny] == color) isSame = true;
	            } else {
	            	if (color == 'R' || color == 'G') {
	            		if (map[nx][ny] == 'R' || map[nx][ny] == 'G') isSame = true;
	            	} else {
	            		if (map[nx][ny] == color) isSame = true;
	            	}
	            }
	            
	            if (isSame) {
		    		visited[nx][ny] = true;
		    		stack.push(new int[] {nx, ny});
		    	}
	    	}
	    }
	}
}
