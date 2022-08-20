package week3;

import java.util.*;
import java.io.*;

public class BJ_2981_검문 {
	
	static int gcd(int a, int b) {
		if (b == 0) return a;
		else return gcd(b, a % b);
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		int[] number = new int[n];
		
		
		for (int i = 0; i < n; i++) {
			number[i] = Integer.parseInt(br.readLine());
		}
		
		// 전체의 최대 공약수 찾기
		int m = Math.abs(number[1] - number[0]);
		for (int i = 2; i < n; i++) {
			m = gcd(m, Math.abs(number[i] - number[i-1]));
		}
		
		// 공약수 계산
		for (int i = 2; i <= m / 2; i++) {
			if (m % i == 0) sb.append(i).append(" ");
		}
		
		sb.append(m);
		System.out.println(sb);
	}
}
