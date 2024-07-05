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
    int max=-1;
    private void helper(TreeNode root, List<Integer> ans, int curr){
        if(root == null) return ;
        if(curr>max){
            ans.add(root.val);
            max = curr;
        }
        helper(root.right, ans, curr+1);
        helper(root.left, ans, curr+1);
    }
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        helper(root, ans, 0);
        return ans;
    }
}