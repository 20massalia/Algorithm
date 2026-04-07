import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        double sum = 0;
        int max = 0;
        
        for (int i = 0; i < N; i++) {
            int score = Integer.parseInt(st.nextToken());
            sum += score;
            if (score > max) max = score;
        }
        
        System.out.println((sum / max * 100) / N);
    }
}