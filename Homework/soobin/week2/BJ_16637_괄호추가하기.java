package week2;

import java.io.*;
import java.util.*;

public class BJ_16637_괄호추가하기 {
	
	static int n, answer = Integer.MIN_VALUE;
	static String s;
	
	static ArrayList<Character> oper;
	static ArrayList<Integer> num;
	static boolean[] selected;

	
	static int calculation(char oper, int num1, int num2) {
		int value = 0;
		
		if (oper == '+') value = num1 + num2;
		else if (oper == '-') value = num1 - num2;
		else if (oper == '*') value = num1 * num2;
		
		return value;
	}
	
	static void selection(int result, int index) {
		
		if (index >= oper.size()) {
			answer = Math.max(answer, result);
			return ;
		}
		
		if (index + 1 < oper.size()) {
			// 선택함 A + (B+C)
			int temp = calculation(oper.get(index+1), num.get(index+1), num.get(index+2));
			selection(calculation(oper.get(index), result, temp), index + 2);
		}
		
		// 선택 안함
		selection(calculation(oper.get(index), result, num.get(index + 1)), index + 1);
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		s = br.readLine();
		
		// 연산자와 숫자 배열 따로 생성
		oper = new ArrayList<>();
		num = new ArrayList<>();
		
		for (int i = 0; i < n; i++) {
			if (i % 2 == 0) num.add(s.charAt(i) - '0');
			else oper.add(s.charAt(i));
		}
		
		selected = new boolean[oper.size()];
		selection(num.get(0), 0);
		
		System.out.println(answer);
	}
}
