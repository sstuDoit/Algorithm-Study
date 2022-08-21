import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_bj_1978_소수찾기 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int cnt = 0;

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < N; i++) {
			boolean isPrime = true;
			if (arr[i] == 1) {
				isPrime = false;
			} else if (arr[i] == 2) {
				isPrime = true;
			} else {
				for (int j = 2; j * j <= arr[i]; j++) {
					if (arr[i] % j == 0) {
						isPrime = false;
						break;
					}
				}

			}
			if (isPrime) {
				System.out.println(arr[i]);

				cnt++;
			}
		}

		System.out.println(cnt);

	}// end main()

	static boolean isPrime(int[] n) {
		System.out.println(Arrays.toString(n));
		for (int i = 0; i < n.length; i++) {
			for (int j = 2; j * j < n[j]; j++) {
				if (n[j] % j == 0) {
					return true;
				}
			}
		}
		return false;
	}// isPrime()
}// end class
