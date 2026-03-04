import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int[][] map;
	static int count = 0;
	static int sharkSize = 2;
	static int eatenCount = 0;
	static int sharkX, sharkY;
	static int[] fishCount = new int[7];
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static class Node {
	    int x, y, dist;
	    Node(int x, int y, int dist) {
	        this.x = x;
	        this.y = y;
	        this.dist = dist;
	    }
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
				if (1 <= map[i][j] && map[i][j] <= 6) {
					fishCount[map[i][j]]++;
				} else if (map[i][j] == 9) {
					sharkX = i;
					sharkY = j;
					map[i][j] = 0;
				}
			}
		}		
		
		while (true) {
			Node target = bfs();
			
			if (target == null) break;
			
			count += target.dist;
			eatenCount++;
			
			if (eatenCount == sharkSize) {
				sharkSize++;
				eatenCount = 0;
			}
			
			sharkX = target.x;
			sharkY = target.y;
			map[sharkX][sharkY] = 0;
		}
		
		System.out.println(count);
	}
	
	public static Node bfs() {
		PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> {
			if (o1.dist != o2.dist) return o1.dist - o2.dist;
			if (o1.x != o2.x) return o1.x - o2.x;
			return o1.y - o2.y;
		});
		
		boolean[][] visited = new boolean[N][N];
		pq.add(new Node(sharkX, sharkY, 0));
		visited[sharkX][sharkY] = true;
		
		while (!pq.isEmpty()) {
			Node curr = pq.poll();
			
			if (map[curr.x][curr.y] > 0 && map[curr.x][curr.y] < sharkSize) {
				return curr;
			}
			
			for (int i = 0; i < 4; i++) {
				int nx = curr.x + dx[i];
				int ny = curr.y + dy[i];

	            if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
	            
	            if (!visited[nx][ny] && map[nx][ny] <= sharkSize) {
	            	visited[nx][ny] = true;
	            	pq.add(new Node(nx, ny, curr.dist + 1));
	            }
			}
		}
		
		return null;
	}
}
