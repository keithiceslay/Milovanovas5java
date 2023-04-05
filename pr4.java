package s5;

import java.util.Arrays;

public class pr4 {
    public static void main(String[] args) {
        int[][] board = new int[8][8];
        if (!queens(board, 0))
            System.out.println("No solutions");
    }
    // доска 8 х 8
    static boolean isSafe(int[][] board, int row, int col) {
        for (int x = 0; x < col; x++) 
            if (board[row][x] == 1)
                return false;
        
        for (int x = row, y = col; x >= 0 && y >= 0; x--, y--)
            if (board[x][y] == 1)
                return false;
        
        for (int x = row, y = col; x < 8 && y >= 0; x++, y--) // доска 8 х 8
            if (board[x][y] == 1)
                return false;

        for (int y = 0; y < row; y++)
            if (board[y][col] == 1)
                return false;

        return true;
    }

    static boolean queens(int[][] board, int col) {
        if (col == 8) {
            for (int[] row: board)
                System.out.println(Arrays.toString(row));
            return true;
        }

        for (int i = 0; i < 8; i++) {
            if (isSafe(board, i, col)) {
                board[i][col] = 1;
                if (queens(board, col + 1))
                    return true;
                
                board[i][col] = 0;
            }
        }

        return false;
    }
}
