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
    public List<Integer> inorder(TreeNode root){
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        TreeNode node = root;
        while(true){
            if(node!=null){
                st.push(node);
                node=node.left;
            }
            else{
                if(st.isEmpty()){
                    break;
                }
                node = st.pop();
                result.add(node.val);
                node=node.right;
            }
        }
        return result;
        }
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> ans = new ArrayList<>();
        ans = inorder(root);
        int count=0;
        for(int num: ans){
            count++;
            if(k==count){
                return num;
            }
        }
        return 0;
    }
}
