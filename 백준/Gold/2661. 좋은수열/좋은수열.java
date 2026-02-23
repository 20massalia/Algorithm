import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
	static int N;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		backtracking("");
	}
	
	public static void backtracking(String result) {
		if (result.length() == N) {
			System.out.println(result);
			System.exit(0);
		}
		
		for (int i = 1; i <= 3; i++) {
			if (isGoodSequence(result + i)) {
				backtracking(result + i);
			}
		}
	}
	
	public static boolean isGoodSequence(String s) {
		int len = s.length();
		for (int L = 1; L <= len / 2; L++) {
			String front = s.substring(len - 2 * L, len - L);
			String back = s.substring(len - L, len);
			
			if (front.equals(back)) {
				return false;
			}
		}
		
		return true;
	}
}
