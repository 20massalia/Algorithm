// 양구출작전
import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static long[] counts;
	static List<Integer>[] adj;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		counts = new long[N + 1];
		adj = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) adj[i] = new ArrayList<>();
		
		for (int i = 2; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			char type = st.nextToken().charAt(0);
			long count = Long.parseLong(st.nextToken());
			int parent = Integer.parseInt(st.nextToken());
			
			counts[i] = (type == 'S') ? count : -count;
			adj[parent].add(i);
		}
		
		System.out.println(dfs(1));
	}
	
	static long dfs(int current) {
		long result = 0;
		
		for (int i = 0; i < adj[current].size(); i++) {
			int next = adj[current].get(i);
			result += dfs(next);
		}
		
		result += counts[current];
		
		if (result < 0) return 0;
		
		return result;
	}
}
