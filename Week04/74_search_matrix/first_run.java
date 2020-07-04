/**
把二维看成一维的直接上二分查找
*/
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix==null||matrix.length<=0) {
            return false;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int left=0, right=row*col-1;
        while(left<=right) {
            int mid = (left+right)/2;
            int i = mid/col, j=mid%col;
            if(matrix[i][j]==target) {
                return true;
            }
            if(matrix[i][j]>target){
                right = mid-1;
            } else {
                left = mid+1;
            }
        }
        return false;
    }
}