class Solution {
     class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    int[] dx = {0,1,0,-1};
    int[] dy = {1,0,-1,0};
    public List<Integer> spiralOrder(int[][] matrix) {

        int row = matrix.length;
        int col = matrix[0].length;
        boolean[][] visited = new boolean[row][col];

        List<Integer> list = new LinkedList<>();
        list.add(matrix[0][0]);
        visited[0][0] = true;
        int x = 0;
        int y = 0;
        int dir = 0;
        
        while(true) {
            
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            if(nx < 0 || nx >= row || ny < 0 || ny >= col || visited[nx][ny]) {
                dir = (dir+1)%4;
                nx = x + dx[dir];
                ny = y + dy[dir];
            }
            if(nx < 0 || nx >= row || ny < 0 || ny >= col || visited[nx][ny])
                break;
            visited[nx][ny] = true;
            list.add(matrix[nx][ny]);
            x = nx;
            y = ny;
            
        }
        return list;
    }
}