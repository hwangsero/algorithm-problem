import java.util.*;



class Solution {

    List<String> answer = new ArrayList<>();
    String s;
    public List<String> restoreIpAddresses(String s) {
        this.s = s;
        go(0, 0, "");
        return answer;
    }
    
    public void go(int index, int count, String now) {
        if(count == 4) {
            if(index != s.length()) return;
            answer.add(now.substring(1));
            return;
        }
        
        for(int next = index+1; next <= index+3; next++) {
            if(next > s.length()) break;
            String nextStr = s.substring(index, next);
            if(nextStr.length() > 1 && nextStr.charAt(0) == '0') continue;
            int nextInt = Integer.parseInt(nextStr);
            if(nextInt < 0 || nextInt > 255) continue;
            go(next,count+1,now+ "." +nextStr);
        }
    }
}