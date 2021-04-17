class Solution {

   public boolean isValidSudoku(char[][] board) {
        HashMap<Integer, Integer> row[] = new HashMap[9];
        HashMap<Integer, Integer> col[] = new HashMap[9];
        HashMap<Integer, Integer> box[] = new HashMap[9];
        for(int i = 0; i < 9; i++) {
            row[i] = new HashMap<>();
            col[i] = new HashMap<>();
            box[i] = new HashMap<>();
        }

        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                char c = board[i][j];
                if(c == '.') continue;

                int num = (int)c;
                row[i].put(num, row[i].getOrDefault(num,0)+1);
                col[j].put(num, col[j].getOrDefault(num,0)+1);
                int index = i / 3 * 3 + j / 3;
                box[index].put(num, box[index].getOrDefault(num,0) + 1);

                if(row[i].get(num) > 1 || col[j].get(num) > 1 || box[index].get(num) > 1) return false;
            }
        }
        return true;
    }
}