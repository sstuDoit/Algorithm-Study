package week2;

import java.util.*;
import java.io.*;

public class BJ_12015_가장긴증가하는부분수열2 {
	
	static ArrayList<Integer> list;
	
	static void BinarySearch(int start, int end, int k) {
		while (start < end) {
			int mid = (start + end) / 2;
			
			// 찾고자 하는 값이 더 작으면
			if (k < list.get(mid)) end = mid;
			else if (k > list.get(mid)) start = mid + 1;
			else {
				start = mid;
				break;
			}
		}
		list.set(start, k);
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] array = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			array[i] = Integer.parseInt(st.nextToken());
		}
		
		list = new ArrayList<>();
		list.add(array[0]);
		
		for (int i = 1; i < n; i++) {
			// 값이 리스트의 가장 마지막 값보다 크다면
			if (array[i] > list.get(list.size()-1)) list.add(array[i]);
			else {
				// 같거나, 큰 수 중 가장 작은 수와 대치
				BinarySearch(0, list.size()-1, array[i]);
			}
		}
		
		System.out.println(list.size());
	}
}
