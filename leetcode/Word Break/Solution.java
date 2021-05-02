class Solution {

    static List<String> wordDict;
    static String s;
    static int[] cache;
    public static boolean wordBreak(String s, List<String> wordDict) {
        Solution.wordDict = wordDict;
        Solution.s = s;
        Solution.cache = new int[s.length()+1];
        Arrays.fill(cache,-1);
        return go(0) > 0 ? true : false;
    }

    public static int go(int index) {
        if(index == s.length()) return 1;
        if(index > s.length()) return 0;
        if(cache[index] != -1) return cache[index];
        
        int ans = 0;
        for (String word : wordDict) {
            int len = word.length();
            if(index+len > s.length()) continue;
            if(s.substring(index,index+len).equals(word))
                ans += go(index + len);
        }
        return cache[index] = ans;
    }
}