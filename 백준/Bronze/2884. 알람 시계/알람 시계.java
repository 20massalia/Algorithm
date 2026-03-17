import java.io.*;
import java.util.*;

public class Main {
	static int H, M;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		H = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		int totalMinutes = H * 60 + M - 45;

		if (totalMinutes < 0) {
		    totalMinutes += 24 * 60;
		}

		H = totalMinutes / 60;
		M = totalMinutes % 60;
		
		System.out.println(H + " " + M);
	}
}
