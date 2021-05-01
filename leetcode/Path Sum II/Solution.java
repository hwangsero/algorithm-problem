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
    List<List<Integer>> ans = new ArrayList<>();
    int targetSum;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if(root == null) return ans;
        this.targetSum = targetSum;
        List<Integer> path = new ArrayList<>();
        path.add(root.val);
        go(root, root.val, path);
        return ans;
    }

    public void go(TreeNode treeNode, int sum, List<Integer> path) {
         if(treeNode.left == null && treeNode.right == null && sum == targetSum) {
             ans.add(new ArrayList<>(path));
             return;
         }

        if(treeNode.left != null) {
            path.add(treeNode.left.val);
            go(treeNode.left, sum + treeNode.left.val, path);
            path.remove(path.size() - 1);
        }
        if(treeNode.right != null) {
            path.add(treeNode.right.val);
            go(treeNode.right, sum + treeNode.right.val, path);
            path.remove(path.size() - 1);
        }
    }
}