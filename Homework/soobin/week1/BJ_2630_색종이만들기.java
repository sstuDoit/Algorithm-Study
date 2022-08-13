package week1;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_2630_색종이만들기 {
	
	static int[][] paper;
	static boolean[][] visited;
	static int whitePaper = 0;
	static int bluePaper = 0;
	
	public static boolean checkPaperColor(int x, int y, int n) {
		
		int color = paper[x][y];
		
		// 영역 내 색이 전부 같은지 확인
		for (int i = x; i < x+n; i++) {
			for (int j = y; j < y+n; j++) {
				if (color != paper[i][j]) return false;
			}
		}
		
		// 확인된 영역은 방문 처리
		for (int i = x; i < x+n; i++) {
			for (int j = y; j < y+n; j++) {
				visited[i][j] = true;
			}
		}

		if (color == 0) whitePaper++;
		else bluePaper++;
		
		return true;
	}
	
	
	public static void dividePaper(int x, int y, int n) {
		// 분할된 네 영역 탐색
		if (!checkPaperColor(x, y, n/2)) dividePaper(x, y, n/2);
		if (!checkPaperColor(x+n/2, y, n/2)) dividePaper(x+n/2, y, n/2);
		if (!checkPaperColor(x, y+n/2, n/2)) dividePaper(x, y+n/2, n/2);
		if (!checkPaperColor(x+n/2, y+n/2, n/2)) dividePaper(x+n/2, y+n/2, n/2);		
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		paper = new int[n][n];
		visited = new boolean[n][n];
		
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dividePaper(0, 0, n);
		System.out.println(whitePaper + "\n" + bluePaper);
	}
}
