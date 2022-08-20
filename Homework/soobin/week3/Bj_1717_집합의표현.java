package week3;

import java.util.*;
import java.io.*;

public class Bj_1717_집합의표현 {
	
	static int[] parent;
	
	static int findParent(int x) {
		// x가 음수면 루트이므로 리턴 
		if (parent[x] < 0) return x;
		else return findParent(parent[x]);
	}
	
	static void unionParent(int x, int y) {
		int px = findParent(x);
		int py = findParent(y);
		
		// 부모가 같다면
		if (px == py) return ;
		
		if (parent[px] > parent[py]) {
			parent[py] += parent[px];
			parent[px] = py;
		}
		else {
			parent[px] += parent[py];
			parent[py] = px;
		}
		
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		parent = new int[n+1];
		Arrays.fill(parent, -1);
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int op = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if (op == 0) unionParent(a, b);
			else {
				if (findParent(a) == findParent(b)) sb.append("YES").append("\n");
				else sb.append("NO").append("\n");
			}
		}
		
		System.out.println(sb);
	}
}
