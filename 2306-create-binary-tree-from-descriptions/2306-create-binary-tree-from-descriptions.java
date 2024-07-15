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
    public TreeNode createBinaryTree(int[][] descriptions) {
        final TreeNode[] nodes = new TreeNode[100001];
        final boolean[] child = new boolean[100001];

        for(final int[] desc : descriptions){
            if(nodes[desc[0]] == null){
                nodes[desc[0]] = new TreeNode(desc[0]);
            }
            if(nodes[desc[1]] == null){
                nodes[desc[1]] = new TreeNode(desc[1]);
            }
            if(desc[2]==1){
                nodes[desc[0]].left = nodes[desc[1]];
            }else{
                nodes[desc[0]].right = nodes[desc[1]];
            }
            child[desc[1]] = true;
        }

        for(final int[] desc : descriptions)
            if(!child[desc[0]])
                return nodes[desc[0]];

        return null;
    }
}