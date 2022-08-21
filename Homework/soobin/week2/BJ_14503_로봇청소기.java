package week2;

import java.util.*;
import java.io.*;

public class BJ_14503_로봇청소기 {
	
	static int n, m, r, c, d;
	static int[][] map;
	// 북, 동, 남, 서 (상, 우, 하, 좌)
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	
	static int moveRobot() {
		int count = 0;
		
		loop: while (true) {
			// 현재 위치를 청소한다.
			if (map[r][c] != -1) count++;
			map[r][c] = -1;
			
			for (int k = 0; k < 4; k++) {
				// 왼쪽 영역을 탐색한다.
				
				d = (d + 3) % 4;
				
				// 왼쪽이 0이라면 회전하고 한 칸 전진한다.
				int nx = r+dx[d];
				int ny = c+dy[d];
				
				if (map[nx][ny] == 0) {
					
					if (map[nx][ny] == 1) continue;
					r = nx; c = ny;
					continue loop;
				}
			}
			
			// 네 방향 모두 청소가 되어 있다면 뒤로 이동
			int back = (d + 2) % 4;
			
			int nx = r + dx[back];
			int ny = c + dy[back];
			
			// 뒤가 벽이라면 작동 종료
			if (map[nx][ny] == 1) break;
			
			r = nx;
			c = ny;
			
		}
		return count;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		
		st = new StringTokenizer(br.readLine());
		
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		System.out.println(moveRobot());
	}
}