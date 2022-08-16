### **개념**
정렬되지 않은 요소를 정렬된 부분과 비교하며 올바른 위치를 찾아 삽입하는 정렬

<br>

### 동작 설명
길이가 N인 배열 arr 이 있을 때 배열의 왼쪽 부분을 정렬된 부분, 오른쪽 부분을 정렬되지 않은 부분으로 나눈다

 

초기 상태로 arr[0] 은 정렬된 부분 나머지는 정렬되지 않은 부분이다

 

정렬되지 않은 1 ~ N-1 까지 index를 증가시키며 해당하는 원소에 대한 정렬을 진행한다

 

각 원소를 정렬할 때는 i-1 ~ 0 까지 index를 감소시키며 i 번째 원소값(key)보다 작은 값이 나올 때 까지 탐색한다

<br>

### 그림 설명
<img src="https://velog.velcdn.com/images/justifinition/post/165827bd-028c-4075-9a4e-07090ddfeab7/image.png" width="400px">
크기 N = 5인 배열 arr 에 대해 삽입 정렬을 수행할 때 초기 상태는 위와 같다.

arr[0] = 5 는 이미 정렬된 상태이며 1~4 원소에 대해 정렬 수행

---
<img src="https://velog.velcdn.com/images/justifinition/post/68612fe1-433c-4e2b-bfbc-6bfa015cf19b/image.png" width="400px">


i = 1

현재 정렬할 key값은 arr[1] = 2

arr[0] (= 5) 과 비교했을 때 arr[1] 이 더 작으므로 위치를 바꾼다
<br>

<img src="https://velog.velcdn.com/images/justifinition/post/14e2d7d8-1947-4994-a71e-b00217e43f54/image.png" width="400px">
index 가 0 이 되어 더 이상 비교할 수 없으므로 수행을 마친다.

---


<img src="https://velog.velcdn.com/images/justifinition/post/06c62308-fa20-46c6-b4f5-c527bff4fc53/image.png" width="400px">
i = 2

현재 정렬할 key값은 arr[2] = 3

arr[1] (= 5) 와 비교했을 때 arr[2] 가 더 작으므로 위치를 바꾼다

<img src="https://velog.velcdn.com/images/justifinition/post/b9f535d1-346c-4e3a-bcc0-464132fa65f6/image.png" width="400px">

그 다음 arr[0] (= 2) 과 key값 3을 비교했을 때 key값 보다 작은 값이 나왔으므로 정렬을 마친다.

<img src="https://velog.velcdn.com/images/justifinition/post/6ea1f0cf-5ca3-432d-bd02-7558aa3a6e8f/image.png" width="400px">


---

i = 3

<img src="https://velog.velcdn.com/images/justifinition/post/0f6ae62b-be96-44c3-b86e-5685dae9ad60/image.png" width="400px">

i = 4

<img src="https://velog.velcdn.com/images/justifinition/post/1acc87c7-30b8-4839-bcdd-fc96940cd2f1/image.png" width="400px">
 

최악의 경우는 수가 역순으로 정렬되어 있는 경우 ( ex) 5 4 3 2 1 )

각 원소 i 에 대해 i-1번을 연산해야하므로 시간복잡도는 O(N^2) 이 된다
<img src="https://velog.velcdn.com/images/justifinition/post/e117a4ec-04c7-41a4-8043-4db7a77efeac/image.png" width="250px">

### 코드 - JAVA
```java
import java.util.Arrays;

public class InsertionSortTest {
	
	static void insertionSort(int[] arr) {
		int N=arr.length;
		int i, j, key;
		for(i=1;i<N;i++) {
			key = arr[i];
			for(j=i-1;j>=0 && arr[j] > key;j--) {
				arr[j+1] = arr[j];
			}
			arr[j+1] = key;
		}
	}

	public static void main(String[] args) {
		int[] arr = {5, 2, 3, 1, 4};
		System.out.print("정렬 전 arr : ");
		System.out.println(Arrays.toString(arr));		// [5, 2, 3, 1, 4]	
		
		insertionSort(arr);
		
		System.out.print("정렬 후 arr : ");
		System.out.println(Arrays.toString(arr));		// [1, 2, 3, 4, 5]
	}
}
```