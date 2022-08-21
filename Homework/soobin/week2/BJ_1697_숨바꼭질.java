package week2;

import java.io.*;
import java.util.*;

public class BJ_1697_숨바꼭질 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[] list = new int[100002];
		
		
		Queue<Integer> queue = new LinkedList<>();
		queue.add(n);
		list[n] = 1;
		
		while (list[k] == 0) {
			int cur = queue.poll(); // 큐의 값 뽑기
			
			for (int i = 0; i < 3; i++) {
				int next = 0;
				
				if (i == 0) next = cur + 1;
				else if (i == 1) next = cur - 1;
				else next = cur * 2;

				
				if (next>= 0 && next < list.length && list[next] == 0) { // 범위 내에 있고 값이 정해지지 않았다면
					queue.add(next); // 큐에 값 추가
					list[next] = list[cur] + 1;
				}
			}
		}
		
		System.out.println(list[k] - 1);
	}
}
