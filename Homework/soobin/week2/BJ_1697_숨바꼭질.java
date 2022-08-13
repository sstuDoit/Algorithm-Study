package week2;

import java.io.*;
import java.util.*;

public class BJ_1697_숨바꼭질 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[] dp = new int[100002];
		
		dp[n] = 0;
		dp[n+1] = 1;
		
		// 뒤로 가는 경우 기록
		for (int i = n; i > 1; i--) dp[i-1] = dp[i] + 1;
		
		for (int i = n+1; i <= 100000; i++) {
			// X2 이동 경우의 수. i / 2가 짝수라면 이전 값에서 하나 더해오는 것과 순간이동하는 것 중 더 적은 경우의 수
			if (i % 2 == 0) dp[i] = Math.min(dp[i-1] + 1, dp[i/2] + 1);
			else dp[i] = dp[i-1] + 1;
			
			// 뒤로 가는 경우 탐색. temp 위치의 값 + 1이 temp-1의 값보다 작으면 갱신
			int temp = i;
			while (temp > 0 && dp[temp-1] >= dp[temp] + 1) {
				dp[temp-1] = dp[temp] + 1;
				temp--;
			}
		}
		System.out.println(dp[k]);
	}
}
