### 개념
배열을 더이상 쪼개지 못 할 때까지 반으로 나누고 합치면서 정렬하는 방식

 <br>

### 동작 설명
길이가 N인 배열 arr 이 있을 때 배열을 0 ~ N/2 와 N/2+1 ~ N-1 의 두 영역으로 나누고 

 

두 영역으로 나뉜 배열을 또 반씩 나누는 방식으로 더이상 나누지 못할 때까지 분할하여 함수를 호출한다

 

다 나뉘었다면 각 원소는 하나의 원소만을 가지고 있을 것이고 하나로 나뉘어진 원소들은 다시 합치면서 올라간다

 

두 배열을 합칠 때는 각 배열의 맨 앞 원소를 기준으로 더 작은 수를 가진 배열의 맨 앞의 수를

 

임시 저장할 배열에 저장하고 해당 배열의 index 를 하나 증가시킨다

 

한 배열의 원소가 모두 저장되었다면 나머지 배열의 원소를 모두 임시 저장할 배열에 저장한다

 

위 과정을 마치면 임시 저장할 배열의 값은 정렬되어 있을 것이므로 원래 배열을 저장한 배열 값으로 업데이트 해준다

 

 <br>

 

### 그림 설명

![](https://velog.velcdn.com/images/justifinition/post/102b5d63-780f-4024-b185-088fef245897/image.png)

배열의 원소가 하나가 될 때 까지 나눈다

 


 ![](https://velog.velcdn.com/images/justifinition/post/2a07a552-3eab-45c8-a603-d13dc9e4876e/image.png)


합치면서 정렬을 진행한다

 
---
 

병합 정렬은 계속해서 반으로 나누게 되므로 깊이가 logn 이 된다

따라서 각 깊이마다 n 번의 비교 연산을 하고 깊이는 logn 이므로

최악 수행시간은 O(nlogn) 이 된다

 

 <br>

### 코드 - JAVA
```java
import java.util.Arrays;

public class MergeSortTest {
	static int[] sorted;
	
	static void merge(int[] arr, int left, int right) {
		int mid = (left+right)/2;
		int indexA, indexB, index;
		  indexA = left;
		  indexB = mid+1;
		  index = left;

		  while(indexA<=mid && indexB<=right){
		    if(arr[indexA]<=arr[indexB])	
		    	sorted[index++] = arr[indexA++];
		    else	
		    	sorted[index++] = arr[indexB++];
		  }

		  if(indexA>mid){		// B 배열의 원소가 남은 경우
		    for(int i=indexB; i<=right; i++)
		      sorted[index++] = arr[i];
		  }
		  else{
		    for(int i=indexA; i<=mid; i++) // A 배열의 원소가 남은 경우
		      sorted[index++] = arr[i];
		  }
		  
		  for(int i=left; i<=right; i++){
			    arr[i] = sorted[i];
		  }
			
	}
	
	static void mergeSort(int[] arr, int left, int right) {
		if(left >= right)	return;
		
		int mid = (left+right)/2 ;
	    mergeSort(arr, left, mid); 
	    mergeSort(arr, mid+1, right);
	    merge(arr, left, right);
	}

	public static void main(String[] args) {
		int[] arr = {5, 3, 8, 4, 9, 1, 6, 2, 7};
		sorted = new int[arr.length];
		
		System.out.print("정렬 전 arr : ");
		System.out.println(Arrays.toString(arr));	// [5, 3, 8, 4, 9, 1, 6, 2, 7]
		
		mergeSort(arr, 0, arr.length - 1);
		
		System.out.print("정렬 후 arr : ");
		System.out.println(Arrays.toString(arr));	// [1, 2, 3, 4, 5, 6, 7, 8, 9]
	}
}


```