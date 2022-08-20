package week3;

import java.util.*;
import java.io.*;

public class Bj_1504_특정한최단경로 {
	
	static final int INF = 100_000_000;
	static int n, e;
	
	static class Graph {
		int n;
		int graph[][];
		
		public Graph(int n) {
			this.n = n;
			graph = new int[n][n];
			
			// 그래프 초기화
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					graph[i][j] = INF;
				}
			}
		}
	}

	static class Node implements Comparable<Node> {
		int dist;
		int index;
		
		public Node(int dist, int index) {
			this.dist = dist;
			this.index = index;
		}

		@Override
		public int compareTo(Node node) {
			return Integer.compare(this.dist, node.dist);
		}
	}
	
	static int minDistance(Graph g, int start, int end) {
		PriorityQueue<Node> queue = new PriorityQueue<>();
		int[] distance = new int[n+1];
		boolean[] visited = new boolean[n+1];
		
		if (start == end) return 0;
		
		// 시작 값 초기화
		queue.offer(new Node(0, start));
		visited[start] = true;
		
		for (int i = 0; i <= n; i++) {
			distance[i] = INF;
		}
		
		// 시작 노드 기준으로 거리 갱신
		for (int i = 1; i <= n; i++) {
			if (!visited[i] && g.graph[start][i] != INF) distance[i] = g.graph[start][i];
			// 노드에 거리와 인덱스 전달
			queue.offer(new Node(g.graph[start][i], i));
		}
	
		while (!queue.isEmpty()) {
			Node node = queue.poll();
			
			int w = node.dist;
			int idx = node.index;
			
			visited[idx] = true;
			
			// i와 연결되어 있는 것 탐색
			for (int i = 1; i <= n; i++) {
				if(!visited[i] && g.graph[idx][i] != INF) {
					if (distance[idx] + g.graph[idx][i] < distance[i]) {
						distance[i] = distance[idx] + g.graph[idx][i];
						queue.add(new Node(distance[i], i));
					}
				}
			}
		}
		
		return distance[end];
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
			
		Graph g = new Graph(n+1);
		
		for (int i = 1; i <= e; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			g.graph[a][b] = c;
			g.graph[b][a] = c;
		}
		
		st = new StringTokenizer(br.readLine());
		
		int ma = Integer.parseInt(st.nextToken());
		int mb = Integer.parseInt(st.nextToken());
		
		int answer1 = minDistance(g, 1, ma) + minDistance(g, ma, mb) + minDistance(g, mb, n);
		int answer2 = minDistance(g, 1, mb) + minDistance(g, mb, ma) + minDistance(g, ma, n);
		
		int answer = Math.min(answer1, answer2);
		if (answer >= INF) answer = -1;
		
		System.out.println(answer);
	}
}
