class Solution {

    int n;
    int[][] cache;
    String word;
    String answer;
    int maxLen = 0;
    public String longestPalindrome(String s) {
        word = s;
        n = s.length();
        cache = new int[n][n];
        for(int i = 0; i < n; i++)
            Arrays.fill(cache[i],-1);

        for(int len =0 ; len < n; len++) {
            for(int i = 0; i < n; i++) {
                dfs(i,i+len);

            }
        }

        return answer;

    }

    public void dfs(int start, int end) {
        if(start < 0 || end >= n) return;

        boolean result = check(start, end);
        if(result && maxLen < end-start+1) {
            maxLen = end-start+1;
            answer = word.substring(start, end+1);
        }

        dfs(start-1,end+1);
    }

    public boolean check(int start, int end) {
        int left = start;
        int right = end;

        while(left < right) {
            if(cache[left][right] != -1) return true;
            if(word.charAt(left) != word.charAt(right)) return false;
            left++;
            right--;
        }
        cache[start][end] = 1;
        return true;
    }
}