import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int[][] map;
	static int[][] dist;
	static int[][] islandId;
	static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int result = Integer.MAX_VALUE;
    static class Node {
        int x, y;
        Node(int x, int y) { this.x = x; this.y = y; }
    }
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		islandId = new int[N][N];
		dist = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				dist[i][j] = -1;
			}
		}
		
		int id = 1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1 && islandId[i][j] == 0) {
					labelIsland(i, j, id++);
				}
			}
		}
		
		findShortestBridge();
		System.out.println(result);
	}
	
	static void labelIsland(int x, int y, int id) {
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(x, y));
		islandId[x][y] = id;
		dist[x][y] = 0;
		
		while (!q.isEmpty()) {
			Node curr = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = curr.x + dx[i];
                int ny = curr.y + dy[i];
                
                if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                
                if (map[nx][ny] == 1 && islandId[nx][ny] == 0) {
                    islandId[nx][ny] = id;
                    dist[nx][ny] = 0;
                    q.add(new Node(nx, ny));
                }
			}
		}
	}
	
	static void findShortestBridge() {
		Queue<Node> q = new LinkedList<>();
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (islandId[i][j] != 0) {
					q.add(new Node(i, j));
				}
			}
		}
		
		while (!q.isEmpty()) {
			Node curr = q.poll();
			
			for (int i = 0; i < 4; i++) {
				int nx = curr.x + dx[i];
				int ny = curr.y + dy[i];
				
				if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
				
				if (islandId[nx][ny] == 0) {
					islandId[nx][ny] = islandId[curr.x][curr.y];
					dist[nx][ny] = dist[curr.x][curr.y] + 1;
					q.add(new Node(nx, ny));
				} else if (islandId[nx][ny] != islandId[curr.x][curr.y]) {
					result = Math.min(result, dist[nx][ny] + dist[curr.x][curr.y]);
				}
			}
		}
	}
}
