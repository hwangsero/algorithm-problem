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
    public boolean isValidBST(TreeNode root) {
        return check(root, null, null);
    }

    boolean check(TreeNode now, Integer min, Integer max) {
        if(now == null) return true;
        if (now.left != null) {
            if (now.val <= now.left.val || (min != null &&now.left.val <= min)) return false;
        }

        if (now.right != null) {
            if (now.val >= now.right.val || (max != null &&now.right.val >= max)) return false;
        }
        return check(now.left,min,now.val) && check(now.right,now.val,max);
    }

}
