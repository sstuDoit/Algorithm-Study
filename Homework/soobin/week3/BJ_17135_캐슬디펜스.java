package week3;

import java.util.*;
import java.io.*;

public class BJ_17135_캐슬디펜스 {
	
	static int n, m, d, count = 0, answer = 0, pos;
	static int[][] board, tmpBoard;
	static ArrayList<Integer> archor;
	static ArrayList<int[]> enemy;
	
	// 좌상, 상, 우상
	static int[] dx = {-1, -1, -1};
	static int[] dy = {-1, 0, 1};
	
	static void copyArray() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				tmpBoard[i][j] = board[i][j];
			}
		}
	}
	
	static int canAttack(int ax, int ay, int bx, int by) {
		return Math.abs(bx - ax) + Math.abs(by - ay);
	}

	static void attackEnemy(int x, int y) {		
		int minDist = 100;
		int minX = -1;
		int minY = -1;
		
		// 아래에서부터 위로 탐색
		for (int i = pos-1; i >= 0; i--) {
			for (int j = 0; j < m; j++) {
				if (tmpBoard[i][j] == 1) {
					int dist = canAttack(x, y, i, j);
					// 최단거리 갱신
					if (dist <= d) {
						if (dist == minDist) {
							if (j < minY) {
								minX = i;
								minY = j;
							}
						}
						else if (dist < minDist) {
							minX = i;
							minY = j;
							minDist = dist;
						}
					}
				}
			}
		}
		
		// 적의 좌표를 ArrayList에 넣기
		if(minX != -1 && minY != -1) enemy.add(new int[] {minX, minY});
		
	}
	
	static void disposeArchor(int depth, int start) {
		
		if (depth == 3) {
			copyArray();
			
			// 적이 남아 있다면
			while(pos > 0) {
				
				// 이번 턴에 공격하는 적을 담는 배열
				enemy = new ArrayList<>();
				
				// 궁수가 적 공격
				for (int i = 0; i < 3; i++) attackEnemy(pos, archor.get(i));

				// 적 제거
				for (int i = 0; i < enemy.size(); i++) {
					int ex = enemy.get(i)[0];
					int ey = enemy.get(i)[1];
					if (tmpBoard[ex][ey] == 1) {
						tmpBoard[ex][ey] = 0;
						count++;
					}
				}
				
				pos--;
			}
			
			answer = Math.max(count, answer);
			count = 0;
			pos = n;
			
			return ;
		}
		
		// 마지막 열의 m개 중 3개를 골라서 궁수를 배치
		for (int i = start; i < m; i++) {
			archor.add(i);
			disposeArchor(depth + 1, i + 1);
			archor.remove(archor.size()-1);
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		
		pos = n;
		
		board = new int[n][m];
		tmpBoard = new int[n][m];
		archor = new ArrayList<>();
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}	

		disposeArchor(0, 0);
		
		System.out.println(answer);
	}
}
