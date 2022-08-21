package algoStudy;
import java.io.*;
import java.util.*;

public class BJ_17070_파이프옮기기1 {
	static int [] dx = {0, 1, 1};
	static int [] dy = {1, 1, 0};
	static int N;
	static int [][] map;
	static int cnt = 0;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		map = new int[N+1][N+1];
		
		for(int i = 1; i<=N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 1; j<=N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dfs(1, 2, 0);
		System.out.println(cnt);
		
	}
	static void dfs(int x, int y, int dir) {
		if(x == N && y == N) {
			cnt++;
			return;
		}
		for(int d = 0; d<3; d++) {
			if(dir == 0 && d == 2) continue; // 옆으로 움직이면 세로방향 x
			if(dir == 2 && d == 0) continue; // 아래로 움직이면 가로방향 x
			int nx = x+dx[d];
			int ny = y+dy[d];
			
			if(nx>N ||ny>N) continue;
			if(map[nx][ny] == 1) continue;
			if(d == 1 && 
					!(map[nx][ny] == 0 && map[nx-1][ny] == 0 && map[nx][ny-1] == 0))
					continue;
			dfs(nx, ny, d);
			
		}
	}
}
