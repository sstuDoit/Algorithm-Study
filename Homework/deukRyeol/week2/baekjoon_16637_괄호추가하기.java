package algoTest;
import java.util.*;
import java.io.*;
public class baekjoon_16637 {
	static char[] input; //수식 저장 
	static int n, result;
	
	static void dfs(int index, int sum) {
		if(index >= n) {
			result = Math.max(result, sum);
			return;
		}
		dfs(index+2, cal(sum, input[index]-'0', input[index-1]));
		if(index + 2 < n) {
			int right = cal(input[index]-'0', input[index+2]-'0', input[index+1]);
			int left = cal(sum, right, input[index-1]);
			dfs(index+4, left);
		}
	
	}
	
	static int cal(int i, int j, char op) {
		if(op == '+') return i + j;
		else if(op == '-') return i - j;
		else return i*j;
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		input = new char[n];
		input = br.readLine().toCharArray();
		result = Integer.MIN_VALUE;
		
		dfs(2, input[0] - '0');
		System.out.print(result);
	}
}