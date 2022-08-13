package week2;

import java.util.*;
import java.io.*;

class Node {
	int z;
	int x;
	int y;
	
	Node(int z, int x, int y) {
		this.z = z;
		this.x = x;
		this.y = y;
	}
}

public class BJ_7569_토마토 {
	
	static int m, n, h;
	static int day = 0, notRipe = 0;
	static int[][][] tomato;
	
	// 상, 하, 좌, 우, 앞, 뒤
	static int[] dx = {-1, 1, 0, 0, 0, 0};
	static int[] dy = {0, 0, -1, 1, 0, 0};
	static int[] dz = {0, 0, 0, 0, -1, 1};
	
	static void bfs(Queue<Node> queue) {
		
		while (!queue.isEmpty()) {
			int size = queue.size();
			
			// 큐의 크기만큼 확인
			for (int i = 0; i < size; i++) {
				Node node = queue.poll();
				
				for (int k = 0; k < 6; k++) {
					int nz = node.z + dz[k];
					int nx = node.x + dx[k];
					int ny = node.y + dy[k];
					
					if (nz < 0 || nz >= h || nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
					if (tomato[nz][nx][ny] == -1 || tomato[nz][nx][ny] == 1) continue;

					tomato[nz][nx][ny] = 1;
					notRipe--;
					
					queue.offer(new Node(nz, nx, ny));
				}
			}
			day++;
			if (notRipe == 0) break;
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		
		tomato = new int[h][n][m];

		Queue<Node> queue = new LinkedList<>();
		for (int k = 0; k < h; k++) {
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < m; j++) {
					tomato[k][i][j] = Integer.parseInt(st.nextToken());
					if (tomato[k][i][j] == 0) notRipe++;
					if (tomato[k][i][j] == 1) queue.offer(new Node(k, i, j));
				}
			}
		}
		
		// 모든 토마토가 익은 상태
		if (notRipe == 0) System.out.println(0);
		else {
			bfs(queue);
			// 마지막까지 다 안 익은 상태
			if (notRipe != 0) System.out.println(-1);
			else System.out.println(day);
		}
	}
}
