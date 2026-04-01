import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long[] path = new long[N - 1];
        long[] price = new long[N];
		
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N - 1; i++) {
            path[i] = Long.parseLong(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            price[i] = Long.parseLong(st.nextToken());
        }
		
        long result = 0;
        long minPrice = price[0];
        
        for (int i = 0; i < N - 1; i++) {
            if (price[i] < minPrice) minPrice = price[i];
            result += (minPrice * path[i]);
        }
		
		System.out.println(result);
	}
}