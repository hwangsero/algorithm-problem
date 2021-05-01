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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;
        Stack<List<Integer>> stack = new Stack<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            while(size-- > 0) {
                TreeNode now = queue.poll();
                list.add(now.val);
                if (now.left != null) queue.add(now.left);
                if (now.right != null) queue.add(now.right);
            }
            stack.add(list);
        }
        
        while(!stack.isEmpty()) {
            ans.add(stack.pop());
        }
        return ans;
    }
}