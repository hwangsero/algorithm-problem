class Solution {
 class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    int[] dx = {0,0,1,-1};
    int[] dy = {1, -1, 0, 0};
    boolean[][] visited;
    int row;
    int col;
    char[][] map;
    public int numIslands(char[][] grid) {
        row = grid.length;
        col = grid[0].length;
        visited = new boolean[row][col];
        map = grid;
        
        int count =0;
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(grid[i][j] == '0' || visited[i][j]) continue;
                bfs(new Point(i,j));
                count++;
            }
        }
        return count;
    }

    public void bfs(Point point) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(point);
        visited[point.x][point.y] = true;

        while(!queue.isEmpty()) {
            Point now = queue.poll();
            int x = now.x;
            int y = now.y;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx < 0 || nx >= row || ny < 0 || ny >= col 
                        || visited[nx][ny] || map[nx][ny] == '0') continue;
                visited[nx][ny] = true;
                queue.add(new Point(nx, ny));
            }
        }
    }
}