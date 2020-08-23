/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
/*
 * first solution* public TreeNode bstFromPreorder(int[] preorder) { if(preorder
 * == null || preorder.length ==0) return null; TreeNode head = new
 * TreeNode(preorder[0]); TreeNode root;
 * 
 * for(int i = 1; i < preorder.length; i++){ TreeNode temp = new
 * TreeNode(preorder[i]); root = head; while(true){ if(temp.val < root.val){
 * if(root.left == null){ root.left = temp; break; }else{ root = root.left; }
 * }else if(temp.val > root.val){ if(root.right == null){ root.right = temp;
 * break; }else{ root = root.right; } } } }
 * 
 * return head; } }
 */

class Solution {
    public TreeNode bstFromPreorder(int[] preorder) {
        return helper(preorder, 0, preorder.length - 1);
    }
    
    // solution:
    // tie the tree from the root to the first right
    // and from first right to the end
    private TreeNode helper(int[] preorder, int start, int end) {
        if (start > end)
            return null;
        System.out.println("start: " + start + " end: " + end);
        TreeNode node = new TreeNode(preorder[start]);
        int firstRight;
        for (firstRight = start; firstRight <= end; firstRight++) {
            if (preorder[firstRight] > node.val)
                break;
        }
        System.out.println("start: " + start + " end: " + end + " i:" + firstRight);
        node.left = helper(preorder, start + 1, firstRight - 1);
        node.right = helper(preorder, firstRight, end);
        return node;

    }

}