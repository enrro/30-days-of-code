/**
 * // This is the BinaryMatrix's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface BinaryMatrix {
 *     public int get(int x, int y) {}
 *     public List<Integer> dimensions {}
 * };
 */

class Solution {
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        if(binaryMatrix == null) return -1;
        List<Integer> ld = binaryMatrix.dimensions();
        int row = ld.get(0);
        int col = ld.get(1);
        System.out.println(" row: " + row + " col: " + col );
        
        // by default not found
        int minPositionValue = -1;
        int result = col; 
        for(int  i = 0; i < row;i++ ){
            result = binarySearchLeftMost(binaryMatrix,i, 0, result - 1);
            System.out.println(result);
            if(result == 0) return 0;
            if(result > minPositionValue && minPositionValue == -1){
                minPositionValue = result;
            }
            else if(result < minPositionValue && result != -1){
                minPositionValue = result;
            }
            if(result == -1){
                if(minPositionValue == -1){
                    result = col;
                }
                else{
                    result = minPositionValue;
                }
            }
            
        }
        return minPositionValue;
    }
    
    public int binarySearchLeftMost(BinaryMatrix binaryMatrix,int row, int left, int right){
        if(left > right){
            return -1;
        }
        int middle  = (left + right)/ 2;
        int middleValue = binaryMatrix.get(row, middle);
        if((middleValue == 1 && middle == 0) ||
           (middleValue == 1 && binaryMatrix.get(row, middle - 1) == 0)){
            return middle;
        }
        else{
            if(middleValue == 0){ // since is cero it means that the ones are to the right
                 return binarySearchLeftMost(binaryMatrix,row, middle + 1, right);
            }else{ //  since is one it means that the largest is on the left
                return binarySearchLeftMost(binaryMatrix, row, left, middle - 1);
            }
        }
    }
    
}