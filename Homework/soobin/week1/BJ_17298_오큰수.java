package week1;

import java.io.*;
import java.util.*;

public class BJ_17298_오큰수 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		Stack<Integer> stack = new Stack<>();
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		int[] result = new int[n];
		Arrays.fill(result, -1);
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i < n; i++) {
			if (stack.isEmpty()) {
				stack.add(i);
				continue;
			} 
			
			while (!stack.isEmpty() &&arr[stack.peek()] < arr[i]) {
				result[stack.pop()] = arr[i];
			}
			
			stack.add(i);
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			sb.append(result[i]).append(' ');
		}
		
		System.out.println(sb);
	}
}
