import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int count = 0;
		int result = 666;
		
		while (true) {
			if (String.valueOf(result).contains("666")) count += 1;
			if (count == N) break;
			result += 1;
		}
		
		System.out.println(result);
	}
}