package algoStudy;

import java.io.*;
import java.util.*;

public class BJ_7569_토마토 {
	static int [] dx = {-1, 0, 1, 0, 0,0};
	static int [] dy = {0, 1, 0, -1, 0, 0};
	static int [] dh = {0, 0, 0, 0, 1, -1};
	static int N, M, H, days = 0;
	static int [][][] map;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine(), " ");
		M = Integer.parseInt(st.nextToken()); // y
		N = Integer.parseInt(st.nextToken()); // x
		H = Integer.parseInt(st.nextToken()); // z
		
		map = new int [N][M][H];

		boolean AllTomato = true;
		int cnt = 0;
		for(int i = 0; i<H; i++) {
			for(int j = 0; j<N; j++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int k = 0; k<M; k++) {
					map[j][k][i] = Integer.parseInt(st.nextToken());
					if(map[j][k][i] == 0) AllTomato =false;
				}
			}
		}
		if(AllTomato) {
			System.out.print(0);
		}
		else {
			bfs();

		}
		
	}
	static void bfs() {
		Queue<int []> q = new ArrayDeque<int[]>();
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<M; j++) {
				for(int z = 0; z<H; z++) {
					if(map[i][j][z] == 1) {
						q.offer(new int[] {i, j, z}); // 익은 토마토 큐에 넣기
					}
				}
			}
		}
		while(!q.isEmpty()) {
			int [] tmp = q.poll();
			int x = tmp[0]; 
			int y = tmp[1]; 
			int z = tmp[2];
			for(int d = 0; d<6; d++) {
				int nz = z+dh[d];
				int nx = x+dx[d];
				int ny = y+dy[d];
				if(nz >=0 && nz<H && nx>=0 && nx<N && ny>=0 && ny<M  && map[nx][ny][nz] == 0) { // 6방탐색
					map[nx][ny][nz] = map[x][y][z]+1; // 토마토가 익으면 이전 값+1
					q.offer(new int[] {nx, ny, nz});
				}
			}
		}
		int max = 0;
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<M; j++) {
				for(int z = 0; z<H; z++) {
					if(map[i][j][z] == 0) {
						System.out.println(-1);
						return;
					}days = Math.max(days, map[i][j][z]);
				}
			}
		}
		System.out.println(days-1); // default가 익은 토마토 1값이었으니까 -1해줘야함
	}
}
