import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_bj_2839_설탕배달_서울_20반_류제엽 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
//		int cnt=0;	//해의 개수
//		int res = Integer.MAX_VALUE;
//		
//		for(int x=0; 5*x<=5000; x++) {
//			for(int y=0; 3*y<=5000; y++) {
//				if(N==5*x+3*y) {
//					cnt++;
//					res = Math.min(res, x+y);
//				}
//			}
//		}
//		if(cnt>0) System.out.println(res);		//해가 존재
//		else System.out.println(-1);			//해가 없음
//		
		int ans=0;
		while(true) {
			if(N%5==0) {
				ans += N/5;
				System.out.println(ans);
				return;
			}else {
				N -=3;
				ans++;
			}
			if(N<0) {
				System.out.println(-1);
				return;
			}
		}
	}// end main()
}// end class
