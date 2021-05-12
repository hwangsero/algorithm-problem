class Solution {

    static int[] cache;
    public static int numDecodings(String s) {
        cache = new int[s.length()];
        Arrays.fill(cache, -1);
        return go(0, s);
    }

    public static int go(int index, String s) {
        if(index == s.length()) return 1;
        if(cache[index] != -1) return cache[index];
        // 1개 선택
        int ans = 0;
        if(s.charAt(index) - '0' != 0) {
            ans += go(index + 1, s);

            if(index+1 < s.length()) {
                int num = (s.charAt(index) - '0') * 10 + (s.charAt(index + 1) - '0');
                if(num >= 10 && num <= 26)
                    ans += go(index + 2, s);
            }
        }
        return cache[index] = ans;
    }
}