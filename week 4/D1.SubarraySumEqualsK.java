/*
Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum equals to k.

Example 1:

Input:nums = [1,1,1], k = 2
Output: 2
 

Constraints:

The length of the array is in range [1, 20,000].
The range of numbers in the array is [-1000, 1000] and the range of the integer k is [-1e7, 1e7].
*/
// [1,1,1]
// the distance between 2 points 
// if you add a current sum and you have seen a sum in 2 different points at the array
// and you substract them, the total sums from those points at different index and they add up to k
// then the array between those points is size k.
    
//     have we seen our sum - k before.? 
// the dictionary is a relationship between the sum of numbers and the amount of apperances
// HashMap<Sum,count>
// it makes sense to start with the empty sum with a count of 1 time found.

class Solution {
    public int subarraySum(int[] nums, int k) {
        if(nums == null) return 0;
        HashMap<Integer,Integer> hm = new HashMap<>();
        hm.put(0,1); //the empty sum
        int sum = 0;
        int totalways = 0;
        
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            if(hm.containsKey(sum - k)){
                totalways += hm.get(sum-k);
            }
            hm.put(sum, hm.getOrDefault(sum, 0)+1);
        }
        
        return totalways;
    }
}
