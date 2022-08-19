import java.util.*;
import java.io.*;
public class Main {
	static int n;
	static int[] needs;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		needs = new int[n+1]; 
		for(int i = 1 ; i <= n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int time = Integer.parseInt(st.nextToken()); //�ɸ��� �ð�
			int nodes = Integer.parseInt(st.nextToken());// ���� �۾� ����
			for(int j = 0 ; j < nodes ; j++) {
				int node = Integer.parseInt(st.nextToken()); //���� �۾� ��ȣ
				if(j == 0) { needs[i] = needs[node]; }
				else { needs[i] = Math.max(needs[i], needs[node]); }
			}
			needs[i] += time;
		}
		
		int result = -1;
		for(int i = 1 ; i <=n ; i++) result = Math.max(needs[i], result);
		System.out.print(result);
	}
}
