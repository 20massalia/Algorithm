import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		List<Integer> list = new ArrayList<>();
		Set<Integer> set = new HashSet<>();
		
		for (int i = 0; i < 3; i++) {
			int num = Integer.parseInt(st.nextToken());
			list.add(num);
			set.add(num);
		}
		
		int size = set.size();
		
		if (size == 1) {
			int eye = list.get(0);
			System.out.println(10000 + eye * 1000);
		} else if (size == 2) {
			int sameEye = 0;
			for (int eye : list) {
				if (list.indexOf(eye) != list.lastIndexOf(eye)) {
					sameEye = eye;
					break;
				}
			}
			System.out.println(1000 + sameEye * 100);
		} else {
			int maxEye = Collections.max(list);
			System.out.println(maxEye * 100);
		}
	}
}
