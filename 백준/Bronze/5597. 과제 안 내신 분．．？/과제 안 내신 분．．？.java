import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
public class Main {
public static void main(String[] args) throws IOException {
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
boolean[] submitted = new boolean[31];
for (int i = 0; i < 28; i++) {
int studentNum = Integer.parseInt(br.readLine());
submitted[studentNum] = true;
}
StringBuilder sb = new StringBuilder();
for (int i = 1; i <= 30; i++) {
if (!submitted[i]) {
sb.append(i).append("\n");
}
}
System.out.print(sb);
}
}
