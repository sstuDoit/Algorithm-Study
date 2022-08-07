package week1;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_11399_ATM {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] line = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < n; i++) {
			line[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(line);
		
		// 1 2 3 3 4
		// 1 3 6 9 13
		
		long sum = line[0];
		for (int i = 1; i < n; i++) {
			line[i] += line[i-1];
			sum += line[i];
		}
		
		System.out.println(sum);
	}
}
