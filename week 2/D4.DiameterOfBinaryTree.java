/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        return diameter(root)-1;
    }
    
    public int diameter(TreeNode root){
        if(root == null ) return 0;
        
        int rootDiameter = height(root.left) + height(root.right) + 1;
        int leftDiameter = diameter(root.left);
        int rightDiameter = diameter(root.right);
        return Math.max(rootDiameter, Math.max(leftDiameter,rightDiameter));
    }
    
    public int height(TreeNode root){
        if(root == null) return 0;
        return Math.max(height(root.right), height(root.left)) + 1; 
    }
}