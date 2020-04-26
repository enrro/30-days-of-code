//https://leetcode.com/explore/other/card/30-day-leetcoding-challenge/531/week-4/3310/
class Solution {
    public boolean canJump(int[] nums) {
        if(nums == null ) return false;
        int lastGoodIndexPosition = nums.length-1;
        
        for(int i = nums.length -1; i >= 0; i--){
            if(nums[i] + i >= lastGoodIndexPosition){
                lastGoodIndexPosition = i;
            }
        }
            
        return lastGoodIndexPosition == 0;
    }
}