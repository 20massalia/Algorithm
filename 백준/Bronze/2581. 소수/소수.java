import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());

        boolean[] isNotPrime = new boolean[N + 1];
        isNotPrime[0] = isNotPrime[1] = true;

        for (int i = 2; i * i <= N; i++) {
            if (!isNotPrime[i]) {
                for (int j = i * i; j <= N; j += i) isNotPrime[j] = true;
            }
        }

        int sum = 0, min = -1;
        for (int i = M; i <= N; i++) {
            if (!isNotPrime[i]) {
                if (min == -1) min = i;
                sum += i;
            }
        }

        if (min == -1) System.out.println(-1);
        else System.out.print(sum + "\n" + min);
    }
}