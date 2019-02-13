import java.util.HashSet;

public class Game {
    // initial game board 
    private static int[][] boardOne = {
            {0, 5, 8, 0, 0, 0, 0, 4, 0}, 
            {0, 0, 0, 0, 0, 7, 0, 0, 6}, 
            {7, 0, 0, 9, 0, 5, 0, 2, 1}, 
            {0, 4, 2, 6, 0, 9, 0, 0, 0}, 
            {0, 7, 0, 1, 4, 8, 0, 3, 0}, 
            {0, 0, 0, 5, 0, 2, 9, 6, 0}, 
            {6, 9, 0, 2, 0, 3, 0, 0, 8}, 
            {8, 0, 0, 7, 0, 0, 0, 0, 0},
            {0, 1, 0, 0, 0, 0, 2, 9, 0}
            };
    
    /* Set with initial game entry stored by board index eg [0][3] is 03*/
    private static HashSet<String> set = new HashSet<>();
    
   
    
    /**
     * prints out instructions and board at start of the game 
     */
    private static void printBoard(int[][] board) {
        String letter = "";
        System.out.println("Welcome to Sudoku! \n");
        System.out.println("   1  2  3   4  5  6   7  8  9  ");
        for(int i=0; i<board.length; i++) {
            switch (i) {
            case 0:
                letter = "A";
                break;
            case 1: 
                letter = "B";
                break;
            case 2: 
                letter = "C";
                break;
            case 3: 
                letter = "D";
                break;
            case 4:
                letter = "E";
                break;
            case 5: 
                letter = "F";
                break;
            case 6: 
                letter = "G";
                break;
            case 7: 
                letter = "H";
                break;
            case 8: 
                letter = "I";
                break;
            default:
                break;
            }
            
            if(i%3 == 0) {
                System.out.println(" |---------+---------+---------|");
            }
            
            System.out.printf("%s| %d  %d' %d'| %d  %d  %d | %d  %d' %d | \n", 
                    letter, 
                    board[i][0], board[i][1], board[i][2], 
                    board[i][3], board[i][4], board[i][5], 
                    board[i][6], board[i][7], board[i][8]);
            
            if(i == 8) {
                System.out.println(" |---------+---------+---------|");
            }
        }
    }
    
    private static void showBoard(int[][] board) {
        System.out.println("   1  2  3   4  5  6   7  8  9  ");
        for(int i=0; i<board.length; i++) {
            if(i%3 == 0) {
                System.out.println(" |---------+---------+---------|");
            }
            
            // start row
            String row = ""; 
            row = row+ (char) ('A'+i); // add letter to row
            for(int j=0; j<board[0].length; j++) {
                
                // "%s| %d  %d' %d'| %d  %d  %d | %d  %d' %d | \n"
                if(j%3 == 0) {
                    row = row + "|";
                }
                
                int cellNum = board[i][j]; 
                if(cellNum == 0) {
                    row = row + " *";
                } else {
                    // add cell index in board array in string format e.g. [
                    set.add(Integer.toString(i) + Integer.toString(j)); 
                }
                
                
                // print row
            }
            if(i == 8) {
                System.out.println(" |---------+---------+---------|");
            }
        }
        
        
    }
    
    /**
     * selects board and adds initial game numbers to set 
     */
    private static int[][] pickBoard() {
        // TODO: pick random board
        
        return boardOne;
    }
    
    /**
     * controls game play 
     */
    private static void startGame() {
        // TODO: print out instructions 
        
//        printBoard(boardOne);
        int[][] board = pickBoard();
        showBoard(board);
    }

    /**
     * main method 
     * calls methods that controls game play 
     */
    public static void main(String[] args) {
        startGame();
    }
}
