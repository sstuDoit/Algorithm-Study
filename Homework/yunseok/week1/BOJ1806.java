import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0;i<N;i++)
			arr[i] = Integer.parseInt(st.nextToken());
		
		int start = 0, end = -1;
		int result = Integer.MAX_VALUE;
		int sum = arr[0];
		while(end < N) {
			if(sum >= S) {
				result = Math.min(result, start - end);
				sum -= arr[++end];
			}
			else if (start < N - 1) {
				sum += arr[++start];
			}
			else
				break;
		}
		if(result == Integer.MAX_VALUE)	
			System.out.println(0);
		else
			System.out.println(result);
		br.close();
	}
	
}
