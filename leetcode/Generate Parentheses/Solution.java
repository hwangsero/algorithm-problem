class Solution {
    List<String> ans = new LinkedList<>();
    public List<String> generateParenthesis(int n) {
        making(n,n,new StringBuilder());
        return ans;
    }

    public void making(int left, int right, StringBuilder sb) {
        if(left != 0 && right == 0) return;

        if(left == 0) {
            for(int i = 0; i < right; i++) {
                sb.append(')');
            }
            ans.add(sb.toString());
            for(int i = 0; i < right; i++) {
                sb.deleteCharAt(sb.length() - 1);
            }
            return;
        }



        making(left-1,right,sb.append('('));
        sb.deleteCharAt(sb.length() - 1);
        if(left < right) {
            making(left,right-1,sb.append(')'));
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}