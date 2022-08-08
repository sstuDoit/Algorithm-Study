import java.io.*;
import java.util.*;


public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int[] result = new int[N];
		Stack<Integer> stk = new Stack<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=N-1;i>=0;i--) {
			while(!stk.empty() && stk.peek() <= arr[i]) 
				stk.pop();
			
			if(stk.empty())	result[i] = -1;
			else 	result[i] = stk.peek();
			
			stk.push(arr[i]);
		}
		
		for(int i=0;i<N;i++)
			sb.append(result[i]).append(' ');
		System.out.println(sb);
	}
}
