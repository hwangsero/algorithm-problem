class Solution {
    List<String> answer = new ArrayList<>();
    String[][] phone = new String[][] {{},{},{"a","b","c"}
            ,{"d","e","f"},{"g","h","i"},{"j","k","l"}
            ,{"m","n","o"},{"p","q","r","s"},{"t","u","v"}
            ,{"w","x","y","z"}};
    public List<String> letterCombinations(String digits) {

        combination(digits,0,"");
        return answer;
    }

    public void combination(String digits, int index, String s) {
        if(index == digits.length()) {
        //
            if(s != "") answer.add(s);
          return;  
        }
        
        String[] alphabets = phone[digits.charAt(index)-'0'];
        for(int i = 0; i < alphabets.length; i++) {
            combination(digits,index+1,s+alphabets[i]);
        }
    }
}