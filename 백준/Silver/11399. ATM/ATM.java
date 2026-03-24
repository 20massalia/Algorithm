import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] line = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			line[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(line);
		
		int result = 0;
		for (int i = N; i > 0; i--) {
			result += line[N-i] * i;
		}
		
		System.out.println(result);
	}
}
