// Caitlin Mooney, CS280, Summer 2020, NJIT
// Finds a https://en.wikipedia.org/wiki/Knight's_tour

public class KnightTour {
    public static final int size = 8;

    public static int movesX[] = {2, 1, -1, -2, -2, -1, 1, 2};
    public static int movesY[] = {1, 2, 2, 1, -1, -2, -2, -1};

    public static void outputBoard(final int board[][]) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(board[i][j] + " \t");
            }
            System.out.print("\n");
        }
    }

    public static boolean solve(final int row, final int col, int[][] board, int depth){
        if (depth == (size*size) + 1)
            return true;

        for (int i = 0; i < size; i++) {

            int newRow = row + movesX[i];
            int newCol = col + movesY[i];

            // If move is in bounds and not already visited
            if ((newRow >= 0 && newRow < size && newCol >= 0 && newCol < size) && 
                    (board[newRow][newCol] == 0)) {
                
                board[newRow][newCol] = depth;
                if (solve(newRow, newCol, board, depth+1))
                    return true;
                else
                    board[newRow][newCol] = 0;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int startX = 4;
        int startY = 4;

        int board[][] = new int[8][8];
        int depth = 1;

        board[startX][startY] = depth;
        if(solve(startX, startY, board, depth+1))
            outputBoard(board);
        else
            System.out.println("Could not find a solution for (" + startX + ", " + startY + ")");
    }

}