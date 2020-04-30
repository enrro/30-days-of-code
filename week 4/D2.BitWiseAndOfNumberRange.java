class Solution {
    public int rangeBitwiseAnd(int a, int b) {
        // Flip the LSB of b.
        // And check if the new number is in range(a < number < b) or not
        while(a < b){  
            // -b is the 2's complement of b when do bitwise or with b  
            //we get LSB and we subtract that from b  

            System.out.println(Integer.toBinaryString(b));
            System.out.println(Integer.toBinaryString(-b));
            
            b -= (b & -b);  
        }  
        return b;
        
    }
}