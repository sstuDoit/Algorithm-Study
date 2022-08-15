package week1;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_1806_부분합 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int n = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[n];
		 
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int start = 0, end = 0;
		int sum = 0;
		int length = Integer.MAX_VALUE;

		// end가 마지막까지 가고, sum이 s보다 작아지면 종료
		while(true) {

			if (sum >= s) {
				sum -= arr[start++];
				length = Math.min(end-start+1, length);
			} else if (end == n) break;
			else sum += arr[end++];
		}
		
		if (length == Integer.MAX_VALUE) length = 0;
		System.out.println(length);
	}
}
