import java.io.*;
import java.util.*;

public class Main {
	
	static int N;
	static boolean[][] board;
	static boolean[] visited;
	
	static void BFS(int node) {
		ArrayDeque<Integer> q = new ArrayDeque<>();
		
		q.offer(node);
		visited[node] = true;
		int cur;
		while(!q.isEmpty()) {
			cur = q.poll();
			for(int i=1;i<=N;i++) {
				if(board[cur][i] && !visited[i]) {
					visited[i] = true;
					q.offer(i);
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		board = new boolean[N+1][N+1];
		visited  = new boolean[N+1];
		
		int u, v;
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			u = Integer.parseInt(st.nextToken());
			v = Integer.parseInt(st.nextToken());
			board[u][v] = true;
			board[v][u] = true;
		}
		
		int result = 0;
		for(int i=1;i<=N;i++) {
			if(!visited[i]) {
				result++;
				BFS(i);
			}
		}
		System.out.println(result);
		
		br.close();
	}
}
