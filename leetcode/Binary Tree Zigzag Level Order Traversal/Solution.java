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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean isLeft = true;
        while(!queue.isEmpty()) {

            int size = queue.size();
            List<Integer> sub = new ArrayList<>();
            Stack<Integer> stack = new Stack<>();
            while(size-- > 0) {
                TreeNode now = queue.poll();
                if(isLeft) sub.add(now.val);
                else stack.add(now.val);
                if(now.left != null) queue.add(now.left);
                if(now.right != null) queue.add(now.right);
            }
            while(!stack.isEmpty()) {
                sub.add(stack.pop());
            }
            ans.add(sub);
            isLeft = !isLeft;
        }

        return ans;
    }
}