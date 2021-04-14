class Solution {
       public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) return "";

        StringBuilder common = new StringBuilder(strs[0]);
        for(int i = 1; i < strs.length; i++) {
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < Math.min(strs[i].length(),common.length()); j++) {
                if(common.charAt(j) != strs[i].charAt(j)) break;
                sb.append(common.charAt(j));
            }
            common = sb;
        }
        return common.toString();
    }
}