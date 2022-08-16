### 개념
어떤 수 pivot 을 기준으로 pivot 보다 작은 수들의 집합, pivot 보다 큰 수들의 집합으로 나누고

다시 각 집합에 대해 위 동작을 반복하여 배열을 정렬

<br> 

### 동작 설명
길이가 N인 배열 arr 이 있을 때 배열에 속한 임의의 수를 pivot 으로 설정 ( 아래 예시는 arr[0] 을 pivot 으로 설정 )

 

pivot을 제외한 배열의 왼쪽 끝을 left, 오른쪽 끝을 right 라고 하고 

 

배열 내에서 index 를 이동하며 swap 할 때 필요한 변수 start ( 초기값은 left ), end ( 초기값은 right ) 생성

 

start 가 end 보다 작을 동안                                                                                                                                                 (1)

start 는 해당 위치의 값이 pivot 보다 작은 값일 때 오른쪽으로 이동                                                                                    

end 는 해당 위치의 값이 pivot 보다 큰 값일 때 왼쪽으로 이동

 

start 와 end 가 더 이상 이동하지 못하는 경우는 start 위치에 pivot 보다 큰 수, end 위치에 pivot 보다 작은 수가 있는 경우

 

따라서 start 에 위치한 수와 end 에 위치한 수를 swap 해주고 다시 (1) 의 과정 진행

 

(1) 의 과정이 끝나면 start 가 pivot 이 있어야 할 위치를 가리키고 있게 된다

 

따라서 arr[0] 과 arr[start] 를 swap해주면

pivot 을 기준으로 왼쪽은 pivot 보다 작은 집합, 오른쪽은 pivot 보다 큰 집합이 되고 

각 집합에 대해 위 과정을 반복한다

 

 

### 그림 설명
![](https://velog.velcdn.com/images/justifinition/post/40baf29c-b235-4dba-81c9-cbe804a68f6f/image.png)


pivot = arr[0]        left = start = 0        right = end = N-1

초기 상태는 위와 같고 start 가 end 보다 작을 동안 아래의 동작을 반복하여 수행한다

 

arr[end] 가 pivot 보다 클 동안 end = end - 1
start < end 이고 arr[start] 가 pivot 보다 작거나 같을 동안 start = start + 1
start 와 end  swap
위 동작을 마치면 arr[left] 와 arr[start] 를 swap 하여 pivot 을 적절한 위치로 이동

---

1. arr[end] 가 pivot 보다 클 동안 end = end - 1

 
![](https://velog.velcdn.com/images/justifinition/post/29033690-afb9-4be0-a0dd-1b4123935980/image.png)


2. start < end 이고 arr[start] 가 pivot 보다 작거나 같을 동안 start = start + 1

![](https://velog.velcdn.com/images/justifinition/post/ac23d209-c8ae-42cc-bbf2-c759687ac9ae/image.png)


3. start 와 end  swap

![](https://velog.velcdn.com/images/justifinition/post/e5c7449e-62a6-49e3-b43f-f5320ff891ec/image.png)

---

위의 동작을 반복한다

![](https://velog.velcdn.com/images/justifinition/post/bfb5c826-9d87-4713-a0d3-c94566c2874b/image.png)

동작 1 수행
 

![](https://velog.velcdn.com/images/justifinition/post/27c00d71-e7fa-49fc-a6e3-67955581c891/image.png)

동작 2 수행
 
![](https://velog.velcdn.com/images/justifinition/post/c459f29e-5fc7-4a9f-854d-d321ace0cd4c/image.png)


동작 3 수행
 
---

![](https://velog.velcdn.com/images/justifinition/post/7c991278-070c-4aba-9d82-7a25dd3f3ab6/image.png)

동작 1 수행

![](https://velog.velcdn.com/images/justifinition/post/e04eaa2b-e91b-4772-b849-03f9f6f30a10/image.png)

동작 2를 수행해야 할 차례인데 start < end 조건을 만족하지 않으므로 arr[left] 와 arr[start] 를 swap 하고

pivot 의 최종 위치인 start 를 리턴한다


 

 ![](https://velog.velcdn.com/images/justifinition/post/3456cf5e-af28-489f-b953-fbeeb41a1fdb/image.png)



pivot 을 기준으로 나누어진 두 집합에 대해 다시 위 과정을 반복한다

 
---
 

 <br>

최선의 경우는 pivot 값이 계속해서 배열의 중간값 정도가 되면 호출 깊이가 logn 이 되어 수행시간은 O(nlogn) 이고

최악의 경우 pivot 값이 계속해서 배열의 최대 혹은 최솟값이 되면 호출 깊이가 n이 되어 수행시간은 O(n^2) 이 된다

 

 

### 코드 - JAVA
```java
import java.util.Arrays;

public class QuickSortTest {
	
	static int partition(int[] arr, int left, int right) {
		int pivot = arr[left];
		int start = left, end = right;
		int temp;
		while(start < end) {
			while(pivot < arr[end])	end--;
			while(start < end && pivot >= arr[start]) 	start++;
			
			
			temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;
		}
		arr[left] = arr[start];
		arr[start] = pivot;
		
		return start;
	}
	
	static void quickSort(int[] arr, int left, int right) {
		if(left >= right)	return;
		
		int pivot = partition(arr, left, right);
		quickSort(arr, left, pivot-1);
		quickSort(arr, pivot+1, right);
	}

	public static void main(String[] args) {
		int[] arr = {5, 3, 8, 4, 9, 1, 6, 2, 7};
		System.out.print("정렬 전 arr : ");
		System.out.println(Arrays.toString(arr));	// [5, 3, 8, 4, 9, 1, 6, 2, 7]
		
		quickSort(arr, 0, arr.length - 1);
		
		System.out.print("정렬 후 arr : ");
		System.out.println(Arrays.toString(arr));	// [1, 2, 3, 4, 5, 6, 7, 8, 9]
	}
}
```