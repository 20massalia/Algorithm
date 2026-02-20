import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] arr;
	static int[] selected;
	static boolean[] visited;
	static int result = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		selected = new int[N/2];
		visited = new boolean[N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(0, 0);
		
		System.out.println(result);
	}

	static void dfs(int depth, int start) {
		if (depth == N/2) {
			calculate();
			return;
		}
		
		for (int i = start; i < N; i++) {
			if (!visited[i]) {
				visited[i] = true;
				dfs(depth + 1, i + 1);
				visited[i] = false;
			}
		}
	}
	
	static void calculate() {
		int startTeamScore = 0;
		int linkTeamScore = 0;
		
		for (int i = 0; i < N - 1; i++) {
			for (int j = i + 1; j < N; j++) {
				if (visited[i] && visited[j]) {
					startTeamScore += arr[i][j] + arr[j][i];
				}
				else if (!visited[i] && !visited[j]) {
					linkTeamScore += arr[i][j] + arr[j][i];
				}
			}
		}
		
		result = Math.min(result, Math.abs(startTeamScore - linkTeamScore));
		
		if (result == 0) {
			System.out.println(0);
			System.exit(0);
		}
	}
}
