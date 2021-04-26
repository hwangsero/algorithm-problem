class Solution {
   String s1;
    String s2;
    String s3;
    int[][] cache;
    public boolean isInterleave(String s1, String s2, String s3) {
        this.s1 = s1;
        this.s2 = s2;
        this.s3 = s3;
        cache = new int[s1.length()][s2.length()];
        for(int i = 0; i < s1.length(); i++)
            Arrays.fill(cache[i],-1);
        if(s1.length()+ s2.length() != s3.length()) return false;
        return combination(0, 0, 0);
    }   

    public boolean combination(int s1Index, int s2Index, int index) {
        if(index == s3.length()) return true;
        if(s1Index == s1.length()) {
            return s2.substring(s2Index).equals(s3.substring(index));
        }
        if(s2Index == s2.length()) {
            return s1.substring(s1Index).equals(s3.substring(index));
        }
        
        if(cache[s1Index][s2Index] != -1) return cache[s1Index][s2Index] == 1 ? true : false;
        boolean ans = false;
        if(s1Index < s1.length() && s1.charAt(s1Index) == s3.charAt(index))
            ans = ans || combination(s1Index + 1, s2Index, index + 1);
        if(s2Index < s2.length() && s2.charAt(s2Index) == s3.charAt(index))
            ans = ans || combination(s1Index, s2Index + 1, index + 1);

        cache[s1Index][s2Index]= ans ?  1 : 0;
        return ans;
    }
}