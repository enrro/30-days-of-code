/**
https://leetcode.com/explore/other/card/30-day-leetcoding-challenge/532/week-5/3315/
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isValidSequence(TreeNode root, int[] arr) {
        if(root == null) return arr.length == 0;
        return dfs(root, arr, 0);
    }
    
    public boolean dfs(TreeNode root,int[] arr,int index){
        if(arr[index] != root.val) return false;
        if(index == arr.length -1){
            return root.left == null && root.right == null;
        }
        return root.left  != null && dfs(root.left, arr, index+1) ||
                root.right != null && dfs(root.right,arr, index +1);
    }
}