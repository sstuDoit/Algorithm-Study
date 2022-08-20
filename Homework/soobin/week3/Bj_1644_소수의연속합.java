package week3;

import java.util.*;
import java.io.*;

public class Bj_1644_소수의연속합 {

	static int n;
	static ArrayList<Integer> prime;
	
	// 에라토스테네스의 체
	static boolean primeNumberSieve() {
		boolean[] array = new boolean[n+1];
		Arrays.fill(array, true);
		
		array[0] = false; array[1] = false;
		
		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (!array[i]) continue;
			for (int j = i*i; j <= n; j+= i) {
				array[j] = false;
			}
		}
		
		// 체에 소수만 담음
		prime = new ArrayList<>();
		
		for (int i = 0; i <= n; i++) {
			if (array[i]) prime.add(i);
		}
		
		if (prime.size() == 0) return false;
		else return true;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		if (primeNumberSieve()) {		
			// 슬라이딩 윈도우
			int start = 0, end = 1;
			int answer = 0;
			int len = prime.size();
			
			int sum = prime.get(start);
			if (sum == n) answer++;
			
			while (start < len || end < len) {
				// end가 길이 이내면 
				if (end < len) {
					if (sum > n) sum -= prime.get(start++);
					else if (sum < n) sum += prime.get(end++);
					else {
						answer++;
						sum += prime.get(end++);
					}
				}
				// end가 길이 외면 start만 증가
				else {
					sum -= prime.get(start);
					start++;
					if (sum == n) answer++;
				}
			}
			System.out.println(answer);
		}
		else System.out.println(0);
	}
}