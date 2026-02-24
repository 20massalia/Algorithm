import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[] A;
	static int[] op;
	static int[] selected;
	static boolean[] visited;
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		A = new int[N];
		op = new int[N - 1];
		selected = new int[N - 1];
		visited = new boolean[N - 1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		int idx = 0;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			int count = Integer.parseInt(st.nextToken());
			
			for (int j = 0; j < count; j++) {
				op[idx++] = i;
			}
		}
		
		dfs(0);
		
		System.out.println(max);
		System.out.println(min);
	}
	
	static void dfs(int depth) {
		if (depth == N - 1) {
			calculate();
			return;
		}
		
		for (int i = 0; i < N - 1; i++) {
			if (!visited[i]) {
				visited[i] = true;
				selected[depth] = op[i];
				dfs(depth + 1);
				visited[i] = false;
			}
		}
	}
	
	static void calculate() {
		int res = A[0];
		
		for (int i = 0; i < N - 1; i++) {
			int operator = selected[i];
			int nextNum = A[i + 1];
			
			if (operator == 0) res += nextNum;
			else if (operator == 1) res -= nextNum;
	        else if (operator == 2) res *= nextNum;
	        else if (operator == 3) res /= nextNum;
		}
		
		max = Math.max(max, res);
		min = Math.min(min, res);
	}
}
