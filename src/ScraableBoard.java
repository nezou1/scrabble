public class ScraableBoard {
    public static final String ANSI_GREEN = "\033[42m";
    public static final String RED_BACKGROUND = "\033[41m";
    public static final String WHITE_BOLD = "\033[0;97m";
    public static final String BLUE_BACKGROUND = "\033[44m";

    public static final String YELLOW_BACKGROUND_BRIGHT = "\033[0;103m";

    public static final String BLUE_BACKGROUND_BRIGHT = "\033[0;104m";
    static String[][] board;

    public ScraableBoard(int rows, int cols) {
        board = new String[rows][cols];
        initializeBoard();
    }

    private void initializeBoard() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (i==1 || i==15){
                    if(j==1 || j==8|| j==15){
                        board[i][j] = RED_BACKGROUND+" _ |";
                    }else if(j==4 || j==12) {
                        board[i][j] = BLUE_BACKGROUND + " _ |";
                    }else{
                        board[i][j] = " _ |";
                    }
                }
                else if (i==2 || i==14){
                    if(j==2 || j==14){
                        board[i][j] = YELLOW_BACKGROUND_BRIGHT+" _ |";
                    }else if(j==6 || j==10) {
                        board[i][j] = BLUE_BACKGROUND_BRIGHT + " _ |";
                    }else{
                        board[i][j] = " _ |";
                    }
                }
                else{
                    board[i][j] = " _ |";
                }
            }
        }
    }

    public static void coordonnees(){
        int j=0;
        char a = 'A';
        for(int i=1; i<16; i++){
            j=j+1;
            board[i][0]=" "+String.valueOf(j)+" |";
            board[i][16]=" "+String.valueOf(j);
        }
        board[0][1]=" "+String.valueOf(a)+"  ";
        for(int i=2; i<16; i++){
            int ASCII= (int)a;
            ASCII++;
            a=(char)ASCII;
            board[0][i]=" "+String.valueOf(a)+"  ";
        }
    }

    public static void bonus(){

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (i==1 && (j==1 || j==8|| j==15)){
                    System.out.print(WHITE_BOLD+RED_BACKGROUND+board[i][j]);
                }
            }
            System.out.println();
        }

    }
    public static void printBoard() {
        coordonnees();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(WHITE_BOLD+ANSI_GREEN+board[i][j]);
            }
            System.out.println();
        }
    }



}
