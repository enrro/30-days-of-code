/*
https://leetcode.com/explore/other/card/30-day-leetcoding-challenge/530/week-3/3304/
*/
class Solution {
    func search(_ nums: [Int], _ target: Int) -> Int {
        return recursiveFind(nums, target, 0,nums.count-1)
    }
    
    func recursiveFind(_ nums: [Int], _ target:Int ,_ left:Int,_ right:Int) -> Int{
        if left > right {return -1}
        var middle = (right + left) / 2
        if target == nums[middle]{return middle}
        print("left: \(left)\n middle: \(middle)\n right: \(right)\n ")
        if nums[left] < nums[middle]{
            if target >= nums[left] && target < nums[middle] {
                // go left
                return recursiveFind(nums, target, left, middle - 1)
            }else{
                // go right
                return recursiveFind(nums, target, middle + 1, right)
            }
        }
        else if nums[left] > nums[middle]{
            if target > nums[middle] && target <= nums[right]{
                // go right
                return recursiveFind(nums, target, middle + 1, right)
            }else{
                // go left
                return recursiveFind(nums, target, left, middle - 1)
            }
        }
        else if nums[left] == nums[middle]{
            if nums[right] != nums[middle]{
                // explore right 
                return recursiveFind(nums, target, middle + 1, right)
            }else{
                var result = recursiveFind(nums,target, left, middle - 1)
                if  result == -1{
                    recursiveFind(nums,target, middle + 1, right)
                }else{
                    return result
                }
                
            }
            
        }
        return -1
    }
}