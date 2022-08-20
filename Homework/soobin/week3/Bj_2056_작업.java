package week3;

import java.util.*;
import java.io.*;

public class Bj_2056_작업 {
	
	static int n;
	static int[] indegree, time, memo;
	static ArrayList<ArrayList<Integer>> list;
	
	static void topologySort() {
		Queue<Integer> queue = new LinkedList<>();
		
		for (int i = 1; i <= n; i++) {
			if (indegree[i] == 0) {
				queue.offer(i);
				memo[i] = time[i];
			}
		}
		
		while (!queue.isEmpty()) {
			int k = queue.poll();
			for (int i = 0; i < list.get(k).size(); i++) {
				int next = list.get(k).get(i);
				// 이전 작업까지의 시간 + 다음 차수의 작업에 걸리는 최대 시간
				// => 이 시간이 지나야 다음 작업 시작 가능
				memo[next] = Math.max(memo[next], memo[k] + time[next]);
				indegree[next]--;
				if (indegree[next] == 0) queue.offer(next);
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		list = new ArrayList<>(n+1);
		
		for (int i = 0; i <= n; i++) {
			list.add(new ArrayList<Integer>());
		}
		
		indegree = new int[n+1];
		time = new int[n+1];
		memo = new int[n+1];
		
		for (int i = 1; i <= n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			time[i] = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			for (int j = 0; j < k; j++) {
				list.get(Integer.parseInt(st.nextToken())).add(i);
				indegree[i]++;
			}
		}
		
		topologySort();
		
		int answer = 0;
		for (int i = 1; i <= n; i++) answer = Math.max(answer, memo[i]);
		System.out.println(answer);
	}
}

