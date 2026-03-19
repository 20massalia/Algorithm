import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] nums = new int[6];
		for (int i = 0; i < 6; i++) {
		    nums[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int x = -999; x <= 999; x++) {
			for (int y = -999; y <= 999; y++) {
				if ((x * nums[0]) + (y * nums[1]) == nums[2] && (x * nums[3]) + (y * nums[4]) == nums[5]) {
					System.out.println(x + " " + y);
					break;
				}
			}
		}
	}
}
