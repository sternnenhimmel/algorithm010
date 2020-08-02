/**
这个题其实就是个排序题，只是comparator需要重定义一下
先用merge sort来实现
*/
class Solution {
    private Map<Integer,Integer>map = new HashMap<>();

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        for(int i=0;i<arr2.length;i++){
            map.put(arr2[i],i);
        }

        mergeSort(arr1,0,arr1.length-1);
        return arr1;
    }
    void mergeSort(int[]arr, int left, int right) {
        if(left>=right){
            return;
        }
        int mid = (left+right)>>1;
        mergeSort(arr,left,mid);
        mergeSort(arr,mid+1,right);
        merge(arr, left, mid, right);
    }

    void merge(int[] arr, int left, int mid, int right) {
        int[]temp = new int[right-left+1];
        int i=left, j=mid+1, k=0;
        while(i<=mid && j<=right) {
            if(compare(arr[i],arr[j])<=0){
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }
        while(i<=mid) {
            temp[k++] = arr[i++];
        }
        while(j<=right) {
            temp[k++] = arr[j++];
        }
        System.arraycopy(temp,0,arr,left,temp.length);
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