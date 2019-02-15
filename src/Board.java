import java.util.HashSet;
import java.util.Random;

public class Board {
    // initial game board 
    private int[][] gameBoardOne = {
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
    
    private int[][] gameBoardTwo = {
            {6, 0, 0, 0, 4, 0, 1, 0, 0},
            {0, 4, 3, 0, 6, 0, 0, 0, 0},
            {0, 7, 1, 0, 0, 0, 8, 0, 4},
            {0, 8, 0, 0, 0, 9, 0, 0, 0},
            {0, 3, 0, 5, 0, 6, 0, 2, 0},
            {0, 0, 0, 8, 0, 0, 0, 4, 0},
            {1, 0, 7, 0, 0, 0, 2, 8, 0},
            {0, 0, 0, 0, 7, 0, 5, 9, 0},
            {0, 0, 2, 0, 8, 0, 0, 0, 7}
    };
    
    /* Game board*/
    private int[][] board;

    /* Initial game entry stored by array index e.g. [0][3]*/
    private HashSet<String> set = new HashSet<>();
    
    /**
     * constructor for Board 
     * randomly picks a board as new board 
     */
    public Board() {
        Random random = new Random();
        int rand = random.nextInt(3)+1;
        switch (rand) {
        case 1:
            this.board = gameBoardOne;
            break;
        case 2:
            this.board = gameBoardTwo;
            break;
        default:
            this.board = gameBoardOne;
            break;
        }
    }
    
    /**
     * prints out instructions and board at start of the game 
     */
    protected void printBoard() {
        System.out.println("   1  2  3   4  5  6   7  8  9  ");
        for(int i=0; i<board.length; i++) {
            
            if(i%3 == 0) { // print 3*3 border
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
                    row = row + " * ";
                } else {
                    // add cell index in board array in string format e.g. [
                    set.add(Integer.toString(i) + Integer.toString(j));
                    String s = Integer.toString(cellNum);
                    row = row + " "+s+"'"; 
                }
                
                // add end of row
                if(j == 8) {
                    row = row + "|";
                }
            } // end for loop
            
            // print row
            System.out.println(row);
           
            if(i == 8) { // print last border
                System.out.println(" |---------+---------+---------|");
            }
        }
    }
    
    protected void printInstructions() {
        // print out instructions 
        System.out.println("Welcome to Sudoku.\n\n"
                + "- To enter a number in a cell, input the cell ID "
                + "\ni.e. the row letter and column number together "
                + "followed by the number you would like to be in the cell"
                + " E.g. A1 8 \n"
                + "- To delete a number you entered from a cell, enter \"undo\" followed by "
                + "the cell ID. E.g. undo A1 \n"
                + "- To swap two cells, input \"swap\" and both cell IDs. E.g. Swap A1 F6 \n"
                + "- To get instructions again enter \"help\" \n"
                + "- To restart the game, input \"restart\" \n"
                + "- To end the game after completing the board, input \"end\" \n");
        System.out.println("Have fun playing Sudoku! Here is your initial board");
    }
    
    

}
