package leetcode;

public class leetcode079 {
    public static void main(String[] args) {
        char[][] c={{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
         System.out.println(""+exist(c,"ABBCCED"));
    }


    public static boolean exist(char[][] board, String word) {
        int h = board.length, w = board[0].length;
        int[][] isVisited = new int[h][w];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (dfs(board, word, i, j, 1, isVisited)) return true;
            }
        }
        return false;
    }
    static int[] dx = {-1, 1, 0, 0};
   static int[] dy = {0, 0, -1, 1};
   static int m, n;
    public static boolean dfs(char[][] board, String word, int x, int y, int k, int[][] isVisited) {
        if (k >= word.length()) return true;
        isVisited[x][y] = 1;
        for (int i = 0; i < 4; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];
            if (newX >= 0 && newX < m && newY >= 0 && newY < n && isVisited[newX][newY] == 0) {
                if (board[newX][newY] == word.charAt(k)) {
                    if (dfs(board, word, newX, newY, k+1, isVisited)) return true;
                }
            }
        }
        isVisited[x][y] = 0;
        return false;
    }

}
