import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		System.out.println(fibo(N));
	}
	
	static int fibo(int i) {
		if (i == 0) return 0;
		if (i == 1) return 1;
		
		return fibo(i - 1) + fibo(i - 2);
	}
}
