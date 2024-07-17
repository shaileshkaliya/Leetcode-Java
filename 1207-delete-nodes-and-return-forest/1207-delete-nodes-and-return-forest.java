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
    List<TreeNode> ans;
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        ans = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for(int i:to_delete){
            set.add(i);
        }
        root = helper(root, set);
        if(root != null) ans.add(root);
    
        return ans;
    }

    private TreeNode helper(TreeNode root, Set<Integer> set){
        if(root == null){
            return null;
        }
        root.left = helper(root.left, set);
        root.right = helper(root.right, set);

        if(set.contains(root.val)){
            if(root.left != null) ans.add(root.left);
            if(root.right != null) ans.add(root.right);
            return null;
        }
        return root;
    }
}