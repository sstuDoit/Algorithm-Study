package algoStudy;
import java.io.*;
/*
 * 높이의 최대치, 적어도 M미터 만족
 */
import java.util.*;
public class BJ_2805_나무자르기 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb =new StringBuilder();
		
		st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int [] trees = new int[N];
		st = new StringTokenizer(br.readLine()," ");
		int h = 0;
		int l = 0;
		for(int i = 0; i<N; i++) {
			trees[i] = Integer.parseInt(st.nextToken());
			if(h < trees[i])
				h = trees[i];
		}
	

		while(l<h) {
			//System.out.println(l+" "+h);
			long sum = 0;
			int m = (l+h)/2;
			for(int i = 0; i<N; i++) {
				if(m < trees[i])
					sum += trees[i]-m;
			}
			if(sum < M) {
				h = m;
			}
			else l= m+1;
			
		}
		System.out.println(l-1);
		
	}

	
}
