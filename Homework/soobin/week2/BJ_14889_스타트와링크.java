package week2;

import java.io.*;
import java.util.*;

public class BJ_14889_스타트와링크 {
	
	static int[][] team;
	static int n;
	static boolean visited[];
	static int result = Integer.MAX_VALUE;
	
	static void dfs(int depth, int start) {
		
		if (depth == n / 2) {
			int[] teamScore = {0, 0};
			
			for (int i = 0; i < n; i++) {
				for (int j = i+1; j < n; j++) {
					if (visited[i] && visited[j]) teamScore[0] += team[i][j] + team[j][i];
					if (!visited[i] && !visited[j]) teamScore[1] += team[i][j] + team[j][i];
				}
			}
			
			int diff = Math.abs(teamScore[0] - teamScore[1]);
			result = Math.min(diff, result);
			return ;
		}
		
		for (int i = start; i < n; i++) {
			visited[i] = true;
			dfs(depth+1, i+1);
			visited[i] = false;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		team = new int[n][n];
		visited = new boolean[n];

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");		
			for (int j = 0; j < n; j++) {
				team[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(0, 0);
		
		System.out.println(result);
		
		br.close();
	}
}
