import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int numerator = 1;
		int denominator = 1;

		for (int i = 0; i < K; i++) {
		    numerator *= (N - i);
		}

		for (int i = 1; i <= K; i++) {
		    denominator *= i;
		}

		System.out.println(numerator / denominator);
	}
}
