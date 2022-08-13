package week2;

import java.util.*;
import java.io.*;

public class BJ_11724_연결요소의개수 {
	
	static int[] parent;
	
	static int findParent(int x) {
		if (parent[x] == -1) return x;
		else return findParent(parent[x]);
	}
	
	static void unionParent(int x, int y) {
		
		int px = findParent(x);
		int py = findParent(y);
		
		if (px == py) return ;
		
		if (px > py) parent[px] = py;
		else parent[py] = px;
		
		return ;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		parent = new int[n+1];
		Arrays.fill(parent, -1);
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			unionParent(x, y);
		}
		
		int answer = 0;
		for (int i = 1; i <= n; i++) {
			if (parent[i] == -1) answer++;
		}

		System.out.println(answer);
	}
}
