import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long N = Integer.parseInt(br.readLine());
		
		System.out.println(factorial(N));
	}
	
	static long factorial(long num) {
		if (num <= 1) return 1;
		return num * factorial(num - 1);
	}
}
