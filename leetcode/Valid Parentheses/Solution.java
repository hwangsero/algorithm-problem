class Solution {
    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()) {
            if(c == '(' || c == '{' || c == '[') stack.push(c);
            else {
                if(stack.isEmpty()) return false;
                switch (c) {
                    case ')' : if(stack.peek() != '(') return false;
                    break;
                    case '}' : if(stack.peek() != '{') return false;
                        break;
                    case ']' : if(stack.peek() != '[') return false;
                        break;
                }
                stack.pop();
            }
    }
        if(!stack.isEmpty()) return false;
        return true;



}
}