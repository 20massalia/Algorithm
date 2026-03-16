// 별 찍기 - 10
import java.io.*;
import java.util.Arrays;

public class Main {
	static char[][] result;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		result = new char[N][N];
		for (int i = 0; i < N; i++) {
			Arrays.fill(result[i], ' ');
		}
		
		star(0, 0, N);
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			sb.append(result[i]).append('\n');
		}
		System.out.print(sb);
	}
	
	static void star(int r, int c, int n) {
		if (n == 1) {
			result[r][c] = '*';
			return;
		}
		
		int nextSize = n / 3;
		int count = 0;
		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				count++;
				if (count == 5) continue;
				star(r + i * nextSize, c + j * nextSize, nextSize);
			}
		}
	}
}
