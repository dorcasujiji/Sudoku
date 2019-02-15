import java.util.HashSet;
import java.util.Random;

public class Board {
    /* Game board*/
    private int[][] board;

    /* Initial game entry stored by array index e.g. [0][3]*/
    private HashSet<String> set = new HashSet<>();

    /* Tracks if the board has been printed before
    * set need to be initialized if first time printing board */
    private boolean firstPrint = true;

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
     * prints initial game board at start of game
     * and adds unchangeable cells to set
     */
    protected void printBoard() {
        System.out.println("   1  2  3   4  5  6   7  8  9  ");
        for(int i=0; i<board.length; i++) {
            
            if(i%3 == 0) { // print 3*3 row border
                System.out.println(" |---------+---------+---------|");
            }
            
            // start row -> "%s| %d  %d' %d'| %d  %d  %d | %d  %d' %d | \n"
            String row = ""; 
            row = row+ (char) ('A'+i); // add letter to row

            for(int j=0; j<board[0].length; j++) {
                // adds 3*3 column border
                if(j%3 == 0) {
                    row = row + "|";
                }
                // add number or * to row string
                int cellNum = board[i][j]; 
                if(cellNum == 0) {
                    row = row + " * ";
                } else {
                    // add cell index in board array in string format e.g. [
                    String index = Integer.toString(i) + j;
                    if(firstPrint) {
                        set.add(index);
                        row = row + " " + cellNum + "'";
                    } else {
                        if(set.contains(index)) {
                            row = row + " " + cellNum + "'";
                        } else { row = row + " " + cellNum + " ";}
                    }
                }
                // add row border
                if(j == 8) {
                    row = row + "|";
                }
            } // end forloop
            System.out.println(row); // print row
            if(i == 8) {            // print last border
                System.out.println(" |---------+---------+---------|");
            }
        }

        // avoid changing set after first time print board
        if(firstPrint)
            firstPrint = false;
    }

    /**
     * prints out instructions at begining of game
     * or when player enters "help"
     */
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

    /**
     * swaps cell entries in board if possible
     * prints error msg otherwise
     * @args cell1 index, cell2 index
     */
    protected boolean swap(String index1, String index2) {
        // TODO: swap cells
        // swap cells in args
        System.out.println("Will swap cells " + index1 + " and " + index2 );
        return true;
    }

    /**
     * deletes cell entry if possible
     * prints error message otherwise
     * @args index
     */
    protected boolean undo(String index) {
        // TODO: undo cell logic
        System.out.println("Will remove entry in cell " + index);
        // System.out.println("Error: Cell part of initial board. Entry cannot be undo.");
        return true;
    }

    /**
     * enters player's number into board at index if possible
     * prints error msg otherwise
     * @param index,number
     */
    protected boolean enter(String index, int number) {
        char[] indexes = index.toCharArray();
        char row = (char) (indexes[0] - '1');
        int rowNum = Character.getNumericValue(row);
        int colNum = Character.getNumericValue(indexes[1]) - 1;

        // adds/changes number if cell is valid
        // if(isValidCell(Integer.toString(rowNum)+indexes[1])) {
        if(isValidCell(rowNum, colNum)) {
            board[rowNum][colNum] = number;
            printBoard();
        } else {
            System.out.println("Error: Cell ID is invalid. May be filled in initial board with \' next to it.");
        }
        return true;
    }

    /**
     * checks if cell if a valid cell to delete or swap
     * cell entry
     * @param row,col
     * @return boolean
     */
    private boolean isValidCell(int row, int col) {
        if(0 <= row && 8 >= row && 0 <= col && 8 >= col) {
            if(set.contains(Integer.toString(row)+col))
                return false;
            return true;
        } else {
            return false;
        }
    }

    /**
     * TODO: delete this function
     * prints set of intially filled cells indexes
     * for testing purposes
     */
    private void printSet() {
        for(String string: set) {
            System.out.println(string);
        }
    }


}
