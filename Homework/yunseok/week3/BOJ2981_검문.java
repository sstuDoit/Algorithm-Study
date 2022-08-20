import java.io.*;
import java.util.*;

public class BOJ2981_검문 {
	
	static int Euclid(int a, int b) {
		if(a < b) {
			int temp = a;
			a = b;
			b = temp;
		}
		int n = a % b;
		while(n != 0) {
			a = b;
			b = n;
			n = a % b;
		}
		return b;
	}
	
	public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
    	StringTokenizer st;
    	
    	int N = Integer.parseInt(br.readLine());
    	int[] arr = new int[N];
    	
    	for(int i=0;i<N;i++)
    		arr[i] = Integer.parseInt(br.readLine());
    	
    	Arrays.sort(arr);
    	
    	int gcd = arr[1]-arr[0], dif;
    	for(int i=1;i<N-1;i++) {
    		dif = arr[i+1]-arr[i];
    		gcd = Euclid(gcd, dif);
    	}
    	
    	for(int i=2;i<=gcd;i++)
    		if(gcd % i == 0)
    			sb.append(i).append(' ');
    	System.out.println(sb);
    	
    	br.close();
    }
}