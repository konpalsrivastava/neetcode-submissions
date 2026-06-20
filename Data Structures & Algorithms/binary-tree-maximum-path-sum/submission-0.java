/**
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
    int max = Integer.MIN_VALUE;
    public int dfs(TreeNode root){
        TreeNode curr = root;
        if(curr==null){
            return 0;
        }
        int left = Math.max(0,dfs(curr.left));
        int right = Math.max(0,dfs(curr.right));

        max = Math.max(max,left+right+curr.val);
        return curr.val + Math.max(left,right);
    }
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return max;
    }
}
