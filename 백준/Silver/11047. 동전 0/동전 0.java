// 동전 0 
// https://www.acmicpc.net/problem/11047
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] coins = new int[N];
		
		for (int i = 0; i < N; i++) {
			coins[i] = Integer.parseInt(br.readLine());
		}
		
		int result = 0;
		
		for (int i = N - 1; i >= 0; i--) {
			result += K / coins[i];
			K %= coins[i];
		}
		
		System.out.println(result);
	}
}
