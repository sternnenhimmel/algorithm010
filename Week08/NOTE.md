学习笔记

## 位运算
位运算可以在特定的情况下对运算进行简化
### 常用公式：
1. 把x最右边的n位清零：x & (~0 << n)
2. 获取x的第n位值（0或者1） (x >> n) & 1
3. 获取x的第n位幂值：x & (1 << n)
4. 将第n位置为1: x | (1 << n)
5. 将第n位置为0: x & (～(1 << n))
6. 将x最高位至第n位（含）清零：x & ((1 << n)-1)
7. 判断奇偶：(x & 1) == 1 ; (x & 1) == 0
8. x / 2 即为 x >> 1
9. x & (x-1) 清零最低位的1
10. x & (-x) 得到最低位的1
### N皇后终极形式
```java
class Solution {
	private int size; 
	private int count;
	private void solve(int row, int ld, int rd) { 
		if (row == size) { 
			count++; 
			return; 
		}
		int pos = size & (~(row | ld | rd)); 
		while (pos != 0) { 
			int p = pos & (-pos); 
			pos -= p; // pos &= pos - 1; 
			solve(row | p, (ld | p) << 1, (rd | p) >> 1); 
		} 
	} 
public int totalNQueens(int n) { 
	count = 0; 
	size = (1 << n) - 1; 
	solve(0, 0, 0); 
	return count; 
  } 
}
```

## 排序算法
这边主要搞清楚三个o(NlogN)的算法。其实之前做了大量的bfs，dfs，以及动归的题目以后，这个代码模板看起来一点也不复杂，就是个常规的递归套路，这里记录下三个排序的模板
### 归并排序
```java
public static void mergeSort(int[] array, int left, int right) {
    if (right <= left) return;
    int mid = (left + right) >> 1; // (left + right) / 2

    mergeSort(array, left, mid);
    mergeSort(array, mid + 1, right);
    merge(array, left, mid, right);
}

public static void merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right - left + 1]; // 中间数组
        int i = left, j = mid + 1, k = 0;

        while (i <= mid && j <= right) {
            temp[k++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];
        }

        while (i <= mid)   temp[k++] = arr[i++];
        while (j <= right) temp[k++] = arr[j++];

        for (int p = 0; p < temp.length; p++) {
            arr[left + p] = temp[p];
        }
        // 也可以用 System.arraycopy(a, start1, b, start2, length)
    }
```
### 快排
```java
public static void quickSort(int[] array, int begin, int end) {
    if (end <= begin) return;
    int pivot = partition(array, begin, end);
    quickSort(array, begin, pivot - 1);
    quickSort(array, pivot + 1, end);
}
static int partition(int[] a, int begin, int end) {
    // pivot: 标杆位置，counter: 小于pivot的元素的个数
    int pivot = end, counter = begin;
    for (int i = begin; i < end; i++) {
        if (a[i] < a[pivot]) {
            int temp = a[counter]; a[counter] = a[i]; a[i] = temp;
            counter++;
        }
    }
    int temp = a[pivot]; a[pivot] = a[counter]; a[counter] = temp;
    return counter;
}
```

### 堆排序
```java
static void heapify(int[] array, int length, int i) {
    int left = 2 * i + 1, right = 2 * i + 2；
    int largest = i;
    if (left < length && array[left] > array[largest]) {
        largest = left;
    }
    if (right < length && array[right] > array[largest]) {
        largest = right;
    }
    if (largest != i) {
        int temp = array[i]; array[i] = array[largest]; array[largest] = temp;
        heapify(array, length, largest);
    }
}
public static void heapSort(int[] array) {
    if (array.length == 0) return;
    int length = array.length;
    for (int i = length / 2-1; i >= 0; i-) 
        heapify(array, length, i);
    for (int i = length - 1; i >= 0; i--) {
        int temp = array[0]; array[0] = array[i]; array[i] = temp;
        heapify(array, i, 0);
    }
}
```