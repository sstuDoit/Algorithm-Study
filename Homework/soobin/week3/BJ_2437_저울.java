package week3;

import java.util.*;
import java.io.*;

public class BJ_2437_저울 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] weight = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) weight[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(weight);
		
		// 시작부터 무게를 넘으면
		if (weight[0] > 1) System.out.println(1);
		else {
			int sum = weight[0];
			for (int i = 1; i < n ; i++) {
				if (sum + 1 < weight[i]) break;
				sum += weight[i];
			}
			System.out.println(sum + 1);
		}
	}
}
