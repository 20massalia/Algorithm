import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int result = 0;
		int start = Math.max(1, N - (String.valueOf(N).length() * 9));
		
		for (int i = start; i < N; i++) {
			if (getSum(i) == N) {
				result = i;
				break;
			}
		}
		
		System.out.println(result);
	}
	
	static int getSum(int num) {
		int sum = num;
		while (num > 0) {
			sum += num % 10;
			num /= 10;
		}
		
		return sum;
	}
}
