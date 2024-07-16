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
    private TreeNode findLCA(TreeNode root, int start, int dest){
        if(root==null || root.val==start || root.val==dest){
            return root;
        }
        TreeNode left = findLCA(root.left, start, dest);
        TreeNode right = findLCA(root.right, start, dest);

        if(right != null && left != null){
            return root;
        }
        else if(left==null){
            return right;
        }else{
            return left;
        }
    }
    private String leftPath = "", rightPath="";
    public String getDirections(TreeNode root, int startValue, int destValue) {
        TreeNode temp = root;
        TreeNode lca = findLCA(temp, startValue, destValue);
        temp = lca;
        if(temp.val==startValue){
            helper(temp, destValue, new StringBuilder());
            return rightPath;
        }else{
            helper2(temp, startValue, new StringBuilder());
            temp = lca;
            helper(temp, destValue, new StringBuilder());
        }

        return leftPath+rightPath;
    }

    private void helper(TreeNode root, int dest, StringBuilder sb){
        if(root.val == dest){
            rightPath = sb.toString();
            return ;
        }
        if(root.left != null){
            sb.append("L");
            helper(root.left, dest, sb);
            sb.setLength(sb.length() - 1);
        }
        if(root.right != null){
            sb.append("R");
            helper(root.right, dest, sb);
            sb.setLength(sb.length() - 1);
        }
    }
    private void helper2(TreeNode root, int start, StringBuilder sb){
        if(root.val == start){
            leftPath = sb.toString();
            return ;
        }
        if(root.left != null){
            sb.append("U");
            helper2(root.left, start, sb);
            sb.setLength(sb.length() - 1);
        }
        if(root.right != null){
            sb.append("U");
            helper2(root.right, start, sb);
            sb.setLength(sb.length() - 1);
        }
    }
}