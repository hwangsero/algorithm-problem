class Solution {
    public boolean isPalindrome(int x) {

        if(x < 0 || (x % 10 == 0 && x != 0)) return false;

        int reversNumber = 0;
        while(x > reversNumber) {
            reversNumber = reversNumber * 10 + x %10;
            x /= 10;
        }
        return x == reversNumber || x == reversNumber /10;
    }
}