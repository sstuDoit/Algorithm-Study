### 개념
낮은 자리수부터 높은 자리수까지 각 자리수에 해당하는 bucket에 값을 넣다보면 정렬된 결과를 얻는 알고리즘이다

 <br>

### 동작 설명
모든 수에 대해 1의 자리수에 해당하는 bucket 에 해당 값을 넣는다

 

넣어진 수들을 bucket 0 부터 bucket 9 까지 순서대로 리스트로 뽑아낸다

 

다시 그 리스트의 모든 수에 대해 순서대로 10의 자리 수에 해당하는 bucket 에 해당하는 값을 넣는다 

 

넣어진 수들을 bucket 0 부터 bucket 9 까지 순서대로 리스트로 뽑아낸다

 

위 과정을 최고차수까지 진행하면 정렬된 결과를 얻을 수 있다

 

 
<br>
 

### 그림 설명

![](https://velog.velcdn.com/images/justifinition/post/ef63c7e8-18fc-42ff-bc58-037f6eec6191/image.png)


1의 자리수에 대해 bucket 에 집어넣기

![](https://velog.velcdn.com/images/justifinition/post/4c9448f7-4a65-4828-9842-4a9bdf92de32/image.png)

10의 자리수에 대해 bucket 에 집어넣기
 
![](https://velog.velcdn.com/images/justifinition/post/ed392bcb-b404-4425-8a05-5575dfb6b0e8/image.png)

100의 자리수에 대해 bucket 에 집어넣기

![](https://velog.velcdn.com/images/justifinition/post/00dbdd66-8b2e-4590-a96a-d51d7df1b8dc/image.png)

1000의 자리수에 대해 bucket 에 집어넣기

![](https://velog.velcdn.com/images/justifinition/post/96e2232a-f7f0-4a53-885f-a7225d8e12ad/image.png)

1000의 자리수에 대해 bucket 에 집어넣기
 

 ---

bucket 에 담긴 최종 결과를 보면 수가 정렬되어 있음을 알 수 있고시간 복잡도는 O(dn) 이다 ( n : 수의 개수, d : 최고차수 )

<br>

### 코드 - JAVA
```java
import java.util.ArrayDeque;
import java.util.Arrays;

public class RadixSortTest {
	
	static ArrayDeque<Integer>[] buckets = new ArrayDeque[10];
	
	static void radixSort(int[] arr) {
		int div = 10;
		while(div < 100000) {
			for(int i=0;i<arr.length;i++) 
				buckets[(arr[i]/div)%10].offer(arr[i]);

	
			for(int i=0, bi=0;i<10;i++) {
				while(buckets[bi].isEmpty())
					bi++;
				arr[i]=buckets[bi].poll();
			}
			div *= 10;
		}	
	}

	public static void main(String[] args) {
		for(int i=0;i<10;i++)
			buckets[i] = new ArrayDeque<>();
		
		int[] arr = {48081, 97342, 90287, 90583, 53202, 65215, 78397, 48001, 972, 65315};
		
		System.out.print("정렬 전 arr : ");
		System.out.println(Arrays.toString(arr));	
		// [48081, 97342, 90287, 90583, 53202, 65215, 78397, 48001, 972, 65315]
        
		radixSort(arr);
		
		System.out.print("정렬 후 arr : ");
		System.out.println(Arrays.toString(arr));	
		// [972, 48001, 48081, 53202, 65215, 65315, 78397, 90287, 90583, 97342]
	}
}
```