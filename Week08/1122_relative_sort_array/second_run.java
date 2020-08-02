/**
这个题其实就是个排序题，只是comparator需要重定义一下
然后用quick sort来实现，比归并排序慢了点
*/
class Solution {
    private Map<Integer,Integer>map = new HashMap<>();

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        for(int i=0;i<arr2.length;i++){
            map.put(arr2[i],i);
        }

        quickSort(arr1,0,arr1.length-1);
        return arr1;
    }
    void quickSort(int[]arr, int left, int right) {
        if(left>=right) {
            return;
        }
        int pivot = partition(arr,left,right);
        quickSort(arr,left,pivot-1);
        quickSort(arr,pivot+1,right);
    }

    int partition(int[] arr, int left, int right) {
        int pivot = right, counter = left;
        for(int i=left; i<right; i++) {
            if(compare(arr[i],arr[pivot])<0) {
                int temp = arr[i];
                arr[i] = arr[counter];
                arr[counter] = temp;
                counter++;
            }
        }
        int temp = arr[pivot];
        arr[pivot] = arr[counter];
        arr[counter] = temp;
        return counter;
    }



    int compare(int a, int b){
        if(map.containsKey(a)) {
            if(map.containsKey(b)) {
                return map.get(a)-map.get(b);
            }else{
                return -1;
            }
        }else {
            if(map.containsKey(b)) {
                return 1;
            }else {
                return a-b;
            }
        }
    }
}