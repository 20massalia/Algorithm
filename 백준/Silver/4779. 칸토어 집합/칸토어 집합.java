import java.io.*;
import java.util.*;

public class Main {
	static char[] result;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line;
		
		while ((line = br.readLine()) != null) {
			int num = Integer.parseInt(line);
			int totalLength = (int) Math.pow(3, num);
			
			result = new char[totalLength];
			Arrays.fill(result, '-');
			
			cantor(0, totalLength);
			
			System.out.println(new String(result));
		}
	}
	
	static void cantor(int start, int length) {
		if (length == 1) return;
		
		int nextLength = length / 3;
		
		for (int i = start + nextLength; i < start + 2 * nextLength; i++) {
			result[i] = ' ';
		}
		
		cantor(start, nextLength);
		
		cantor(start + 2 * nextLength, nextLength);
	}
}
