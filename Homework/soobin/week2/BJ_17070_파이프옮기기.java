package week2;

import java.util.*;
import java.io.*;

public class BJ_17070_파이프옮기기 {
	
	// 가로 세로 대각선 이동
	static int[] dx = {0, 1, 1};
	static int[] dy = {1, 0, 1};
	
	// 가로 세로 대각선
	static int[][] board;
	static int n, dir = 0;
	static int answer = 0;
	
	static void dfs(int x, int y, int dir) {
		
		if (x == n-1 && y == n-1) {
			answer++;
			return ;
		}
		
		for (int k = 0; k < 3; k++) {
			
			if (dir == 0 && k == 1) continue;
			if (dir == 1 && k == 0) continue;
			
			// 다음 칸 확인
			int nx = x + dx[k];
			int ny = y + dy[k];
			
			// 영역을 벗어나면 continue
			if (nx < 0 || nx >= n || ny < 0 || ny >= n || board[nx][ny] == 1) continue;
			
			// 대각선이면 위 아래 벽이 있는지 확인
			if (k == 2 && (board[nx-1][ny] == 1 || board[nx][ny-1] == 1)) continue; 
			
			dfs(nx, ny, k);
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		board = new int[n][n];
		
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j ++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(0, 1, 0);
		System.out.println(answer);
	}
}
