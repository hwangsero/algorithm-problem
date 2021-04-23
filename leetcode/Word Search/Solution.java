class Solution {
         char[][] board;
    String word;
    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};
    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.word = word;
        for(int i = 0; i < board.length; i++) {
            for(int j = 0 ; j < board[0].length; j++) {
                if(board[i][j] != word.charAt(0)) continue;
                boolean[][] visited = new boolean[board.length][board[0].length];
                visited[i][j] = true;
                boolean result = check(i,j,1,visited);
                if(result) return true;
            }
        }
        return false;
    }

    public boolean check(int x, int y, int index, boolean[][] visited) {
        if(index == word.length()) return true;

        boolean ans = false;
        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >= 0 && nx < board.length && ny >= 0 && ny < board[0].length
                &&!visited[nx][ny] && word.charAt(index) == board[nx][ny]) {
                visited[nx][ny] = true;
                ans = ans || check(nx,ny, index+1,visited);
                visited[nx][ny] = false;

            }
        }
        return ans;
    }
}