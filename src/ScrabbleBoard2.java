public class ScrabbleBoard2 {
    private static final String RESET = "\u001B[0m";
    private static final String GREEN_BACKGROUND = "\u001B[42m";
    private static final String CYAN_BACKGROUND = "\u001B[46m";
    private static final String YELLOW_BACKGROUND = "\u001B[43m";

    private static final String BONUS_COLOR = "\u001B[36m"; // couleur cyan pour les points bonus

    private char[][] board;
    private int[][] bonus;

    public ScrabbleBoard2(int rows, int cols) {
        board = new char[rows][cols];
        bonus = new int[rows][cols];
        initializeBoard();
    }

    private void initializeBoard() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = '-';
                bonus[i][j] = 0;
            }
        }

        // Exemple de placement de bonus sur le plateau (MD, LD, et LT)
        bonus[1][1] = 1; // Mot double (MD)
        bonus[2][2] = 2; // Lettre double (LD)
        bonus[3][3] = 3; // Lettre triple (LT)
    }

    public void printBoard2() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                char cellValue = board[i][j];
                int cellBonus = bonus[i][j];
                String cellColor;

                // Définir la couleur en fonction du type de bonus
                switch (cellBonus) {
                    case 1:
                        cellColor = CYAN_BACKGROUND; // Mot double (MD)
                        break;
                    case 2:
                        cellColor = YELLOW_BACKGROUND; // Lettre double (LD)
                        break;
                    case 3:
                        cellColor = GREEN_BACKGROUND; // Lettre triple (LT)
                        break;
                    default:
                        cellColor = BONUS_COLOR;
                        break;
                }

                System.out.print(cellColor + cellValue + RESET + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int rows = 15; // nombre de lignes du plateau
        int cols = 15; // nombre de colonnes du plateau

        ScrabbleBoard2 scrabbleBoard = new ScrabbleBoard2(rows, cols);
        scrabbleBoard.printBoard2();
    }
}
