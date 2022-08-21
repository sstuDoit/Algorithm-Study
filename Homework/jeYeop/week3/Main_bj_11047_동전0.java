import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_bj_11047_동전0 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int cnt=0;
		int[] arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i]=Integer.parseInt(br.readLine());
		}
//		System.out.println(Arrays.toString(arr));
		while(K>0) {
			//배열 뒤에서부터 검사
			for(int i=arr.length-1; i>=0; i--) {
				if(K/arr[i]!=0) {
					cnt+=K/arr[i];
					K=K%arr[i];
				}
//				System.out.println("K: "+K);
			}
		}//end while
		System.out.println(cnt);
		
	}//end main()
}//end class
