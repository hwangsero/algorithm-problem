class Solution {

    public String convert(String s, int numRows) {

        if(numRows == 1) return s;

        List<StringBuilder> list = new ArrayList<>();
        for(int i = 0; i < numRows; i++)
            list.add(new StringBuilder());

        int curRow = 0;
        boolean goingDown = true;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            list.get(curRow).append(c);
            curRow = goingDown ? curRow+1 : curRow-1;
            if(curRow == 0 || curRow == numRows-1) goingDown = !goingDown;
        }
        StringBuilder sb = new StringBuilder();
        for(int i= 0; i < numRows; i++) {
            sb.append(list.get(i));
        }
        return sb.toString();
    }
}