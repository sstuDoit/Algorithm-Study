package algoStudy;

import java.io.*;
import java.util.*;
public class BJ_16637_괄호추가하기 {
	static int N;
	static ArrayList<Integer>  num = new ArrayList<>();
	static ArrayList<Character> op = new ArrayList<>();
	static int ans = Integer.MIN_VALUE;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		char [] oper = br.readLine().toCharArray();
		for(int i = 0; i<N; i++) {
			if(i%2 == 0) { 
				num.add(Character.getNumericValue(oper[i]));
			}else
				op.add(oper[i]);
		}
		findMax(0, num.get(0));
		
		System.out.print(ans);
		
	}
	static void findMax(int idx, int sum) {
		if(idx == op.size()) {
			ans = Math.max(ans, sum);
			return;
		}
		findMax(idx+1, cal(sum, num.get(idx+1), op.get(idx))); // 괄호없는식
		if(idx+2 <= op.size()) {
			findMax(idx+2, cal(sum, cal(num.get(idx+1), num.get(idx+2), op.get(idx+1)), op.get(idx)));
		}
		
	}
	static int cal(int x, int y, char p) {
		if(p == '+') return x+y;
		else if(p == '-') return x-y;
		else return x*y;
		
	}

}
