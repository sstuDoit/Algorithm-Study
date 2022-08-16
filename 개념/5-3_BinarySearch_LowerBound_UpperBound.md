### 개념

정렬된 배열에서 어떤 값이 존재하는 지를 확인하거나 해당 값의 인덱스를 알고싶을 때 사용하는 방식이다

 

배열의 중간을 찍어 목표값과 비교하여

 

중간에 있는 값이 목표값보다 크다면 배열은 정렬되어 있으므로 중간보다 오른쪽에 있는 모든 값은 목표값보다 크고

 

반대로 중간에 있는 값이 목표값보다 작다면 중간보다 왼쪽에 있는 모든 값은 목표값보다 작게 된다

 <br>

### 동작 설명
길이가 N인 배열 arr 이 있을 때 start = 0, end = N -1, 중간에 위치한 값 mid = (start + end) / 2 로 설정한다

 

arr[mid] 와 목표값을 비교하여

 

arr[mid]가 목표값 보다 크다면 mid 의 오른쪽에 위치한 값은 볼 필요가 없으므로 end = mid -1 로 설정

arr[mid]가 목표값 보다 작다면 mid 의 왼쪽에 위치한 값은 볼 필요가 없으므로 start = start + 1 로 설정

 

하여 다시 start 와 end 의 중간에 위치한 값을 목표값과 비교한다

 

위 과정을 start < end 조건을 만족하는 동안 반복해서 수행하여 목표값의 인덱스를 찾을 수 있다

 

 <br>

 

### 그림 설명

![](https://velog.velcdn.com/images/justifinition/post/e03c8086-d956-4ff5-bf6d-8a3241ba84c7/image.png)

![](https://velog.velcdn.com/images/justifinition/post/f9af69bd-fd2c-455b-a4e1-09947bd766c7/image.png)


모든 배열의 원소를 logn 번만에 접근할 수 있으므로 최악 수행시간은 O(logn) 이다

 

 <br>

### 코드
```java
public class BinarySearchTest {

	static int binarySearch(int[] arr, int key) {
		int start = 0;
		int end = arr.length - 1;
		
		int mid;
		while(start < end) {
			mid = (start+end) / 2;
			
            if(arr[mid] == key)
            	returm mid;
			else if(arr[mid] < key)
				start = mid + 1;
			else
				end = mid - 1;
		}
		return -1;
	}
	
	public static void main(String[] args) {
		
		int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		
		System.out.println("3 의 인덱스 : " + binarySearch(arr, 3));	// 2
		System.out.println("8 의 인덱스 : " + binarySearch(arr, 8));	// 7
	}

}
```

 <br>

 ---

 <br>

이진 탐색을 이용해 특정한 위치의 인덱스를 구할 수도 있다

 <br>

#### LowerBound / UpperBound
 
 <br>

LowerBound 는 key값 이상의 값이 처음 나오는 index 를 반환한다

 

mid 위치의 값이 key 값보다 작다면 start = mid + 1, 크거나 같다면 end = mid


start < end 조건을 더이상 만족하지 않을 때까지 반복하여

반복문을 탈출했을 때 start 가 key 값 이상의 값이 처음 나오는 index 이다

 
 <br>

### 그림 설명

![](https://velog.velcdn.com/images/justifinition/post/89697bfb-69bf-4f12-b51f-3b952ce64fa4/image.png)


arr[6] >= 3 이므로 end = mid (= 5)

 ![](https://velog.velcdn.com/images/justifinition/post/a1e5cf60-d6cc-4d7e-9421-b31e787442b2/image.png)



arr[3] < 3 이므로 start = mid + 1 (= 4)

 ![](https://velog.velcdn.com/images/justifinition/post/e2e65f2e-fd34-4938-bd81-101822d9d893/image.png)



arr[5] >= 3 이므로 end = mid (= 5)

 
![](https://velog.velcdn.com/images/justifinition/post/0a1c9ec5-b8ad-4e41-994e-11d460a4172d/image.png)


arr[4] >= 3 이므로 end = mid (= 4)

 
![](https://velog.velcdn.com/images/justifinition/post/93afd76b-f511-482e-b9a8-1408710ccaf3/image.png)


 


start < end 조건을 더이상 만족하지 않으므로 처음으로 key 값 이상인 위치 start 를 리턴한다

 

 
---
 

 

UpperBound 는 key값 초과의 값이 처음 나오는 index 를 반환한다

 

mid 위치의 값이 key 값보다 작거나 같다면 start = mid + 1, 크다면 end = mid

 

start < end 조건을 더이상 만족하지 않을 때까지 반복하여

반복문을 탈출했을 때 start 가 key 값 이상의 값이 처음 나오는 index 이다

 
<br>

### 그림 설명

![](https://velog.velcdn.com/images/justifinition/post/c2d92c67-81a1-4ba3-9028-ba6af3aebed1/image.png)



arr[6] <= 3 이므로 start = mid + 1 (= 7)

![](https://velog.velcdn.com/images/justifinition/post/5adc60b8-2a77-4f45-8e9e-47679ffd3e3f/image.png)



arr[9] > 3 이므로 end = mid (= 9)

![](https://velog.velcdn.com/images/justifinition/post/2445d529-1444-42b5-a9b7-0ee2102644e1/image.png)





arr[8] > 3 이므로 end = mid (= 8)

![](https://velog.velcdn.com/images/justifinition/post/dd382e1e-66da-4b73-903a-da97b51395da/image.png)



 


arr[7] > 3 이므로 end = mid (= 7)

![](https://velog.velcdn.com/images/justifinition/post/eb86128f-7656-4f10-8610-e10c991181bb/image.png)


start < end 조건을 더이상 만족하지 않으므로 처음으로 key 값 이상인 위치 start 를 리턴한다

 
<br>
 

### 코드
```java
import java.io.*;
import java.util.*;

public class BoundTest {
	
	static int lowerBound(int[] arr, int start, int len, int key) {
		int end = start + len;
		int mid;
		while(start < end) {
			mid = (start + end) / 2;
			
			if(arr[mid] < key)	start = mid + 1;
			else 	end = mid;
		}
		return start;
	}
	
	static int upperBound(int[] arr, int start, int len, int key) {
		int end = start + len;
		int mid;
		while(start < end) {
			mid = (start + end) / 2;
			
			if(arr[mid] <= key)	start = mid + 1;
			else 	end = mid;
		}
		return start;
	}
	
	public static void main(String[] args) {
		int[] arr = { 1, 1, 2, 2, 3, 3, 3, 4, 4, 5, 5, 5 };
		for(int i=1;i<=6;i++) {
			int lower = lowerBound(arr, 0, arr.length, i);
			int upper = upperBound(arr, 0, arr.length, i);
			System.out.printf("%d 의 lower bound = %d, upper bound = %d\n", i, lower, upper);
            
                // 1 의 lower bound = 0, upper bound = 2
                // 2 의 lower bound = 2, upper bound = 4
                // 3 의 lower bound = 4, upper bound = 7
                // 4 의 lower bound = 7, upper bound = 9
                // 5 의 lower bound = 9, upper bound = 12
                // 6 의 lower bound = 12, upper bound = 12

		}
	}
}
```