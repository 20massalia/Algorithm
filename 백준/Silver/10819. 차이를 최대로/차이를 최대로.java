import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main { 
	static int N;
	static int[] arr;
	static int[] selected;
	static boolean[] visited;
	static int maxResult = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		selected = new int[N];
		visited = new boolean[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		dfs(0);
		
		System.out.println(maxResult);
	}
	
	static void dfs(int depth) {
		if (depth == N) {
			calculateSum();
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if (!visited[i]) {
				visited[i] = true;
				selected[depth] = arr[i];
				dfs(depth + 1);
				visited[i] = false;
			}
		}
	}
	
	static void calculateSum() {
		int currentSum = 0;
		for (int i = 0; i < N - 1; i++) {
			currentSum += Math.abs(selected[i] - selected[i + 1]);
		}
		maxResult = Math.max(maxResult, currentSum);
	}
}
