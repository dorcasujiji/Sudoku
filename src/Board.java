import java.util.HashSet;
import java.util.Random;

public class Board {
    /* Game board*/
    private int[][] board;
    private int[][] solution;

    /* Initial game entry stored by array index e.g. [0][3]*/
    private HashSet<String> set = new HashSet<>();

    /* Tracks if the board has been printed before
    * set need to be initialized if first time printing board */
    private boolean firstPrint = true;

    /* possible initial game boards */
    private int[][] gameBoardOne = {
            {0, 0, 0, 2, 6, 0, 7, 0, 1},
            {6, 8, 0, 0, 7, 0, 0, 9, 0},
            {1, 9, 0, 0, 0, 4, 5, 0, 0},
            {8, 2, 0, 1, 0, 0, 0, 4, 0},
            {0, 0, 4, 6, 0, 2, 9, 0, 0},
            {0, 5, 0, 0, 0, 3, 0, 2, 8},
            {0, 0, 9, 3, 0, 0, 0, 7, 4},
            {0, 4, 0, 0, 5, 0, 0, 3, 6},
            {7, 0, 3, 0, 1, 8, 0, 0, 0}
            };
    
    private int[][] gameBoardTwo = {
            {1, 0, 0, 4, 8, 9, 0, 0, 6},
            {7, 3, 0, 0, 0, 0, 0, 4, 0},
            {0, 0, 0, 0, 0, 1, 2, 9, 5},
            {0, 0, 7, 1, 2, 0, 6, 0, 0},
            {5, 0, 0, 7, 0, 3, 0, 0, 8},
            {0, 0, 6, 0, 9, 5, 7, 0, 0},
            {9, 1, 4, 6, 0, 0, 0, 0, 0},
            {0, 2, 0, 0, 0, 0, 0, 3, 7},
            {8, 0, 0, 5, 1, 2, 0, 0, 4}
    };
    private int[][] gameBoardThree = {
            {2, 0, 5, 0, 0, 7, 0, 0, 6},
            {4, 0, 0, 9, 6, 0, 0, 2, 0},
            {0, 0, 0, 0, 8, 0, 0, 4, 5},
            {9, 8, 0, 0, 7, 4, 0, 0, 0},
            {5, 7, 0, 8, 0, 2, 0, 6, 9},
            {0, 0, 0, 6, 3, 0, 0, 5, 7},
            {7, 5, 0, 0, 2, 0, 0, 0, 0},
            {0, 6, 0, 0, 5, 1, 0, 0, 2},
            {3, 0, 0, 4, 0, 0, 5, 0, 8}
    };
    private int[][] gameBoardOneSolution = {
            {4, 3, 5, 2, 6, 9, 7, 8, 1},
            {6, 8, 2, 5, 7, 1, 4, 9, 3},
            {1, 9, 7, 8, 2, 4, 5, 6, 2},
            {8, 2, 6, 1, 9, 5, 3, 4, 7},
            {3, 7, 4, 6, 8, 2, 9, 1, 5},
            {9, 5, 1, 7, 4, 3, 6, 2, 8},
            {5, 1, 9, 3, 2, 6, 8, 7, 4},
            {2, 4, 8, 9, 5, 7, 1, 3, 6},
            {7, 6, 3, 4, 1, 8, 2, 5, 9}
    };
    private int[][] gameBoardTwoSolution = {
            {1, 5, 2, 4, 8, 9, 3, 7, 6},
            {7, 3, 9, 2, 5, 6, 8, 4, 1},
            {4, 6, 8, 3, 7, 1, 2, 9, 5},
            {3, 8, 7, 1, 2, 4, 6, 5, 9},
            {5, 9, 1, 7, 6, 3, 4, 2, 8},
            {2, 4, 6, 8, 9, 5, 7, 1, 3},
            {9, 1, 4, 6, 3, 7, 5, 8, 2},
            {6, 2, 5, 9, 4, 8, 1, 3, 7},
            {8, 7, 3, 5, 1, 2, 9, 6, 4}
    };
    private int[][] gameBoardThreeSolution = {
            {2, 3, 5, 1, 4, 7, 9, 8, 6},
            {4, 1, 8, 9, 6, 5, 7, 2, 3},
            {6, 9, 7, 2, 8, 3, 1, 4, 5},
            {9, 8, 6, 5, 7, 4, 2, 3, 1},
            {5, 7, 3, 8, 1, 2, 4, 6, 9},
            {1, 4, 2, 6, 3, 9, 8, 5, 7},
            {7, 5, 9, 3, 2, 8, 6, 1, 4},
            {8, 6, 4, 7, 5, 1, 3, 9, 2},
            {3, 2, 1, 4, 9, 6, 5, 7, 8}
    };

    /**
     * constructor for Board 
     * randomly picks a board as new board 
     */
    public Board() {
        Random random = new Random();
        int rand = random.nextInt(3);
        switch (rand) {
        case 0:
            this.board = gameBoardOne;
            this.solution = gameBoardOneSolution;
            break;
        case 1:
            this.board = gameBoardTwo;
            this.solution = gameBoardTwoSolution;
            break;
        case 2:
            this.board = gameBoardThree;
            this.solution = gameBoardThreeSolution;
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
            } // end for loop
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
        System.out.println("Welcome to Sudoku.\n\n"
                + "Remember to leave a space between commands. \n"
                + "- To enter a number use cellID + number "
                + "E.g. A1 8\n"
                + "- To enter into multiple cells use \"enter\" + cell ID + number \n"
                + " E.g. enter A1 1 B4 6 \n"
                + "- To delete a cell entry use \"undo\" + cell ID "
                + "E.g. undo A1 \n"
                + "- To swap two cells, use \"swap\" + cellID + cellID. \n"
                + "E.g. Swap A1 F6 \n"
                + "- To get instructions again use the \"help\" command\n"
                + "- To restart the game, use the \"restart\" command\n"
                + "- To end the game after completing the board, use \"end\" command \n");
        System.out.println("Have fun playing Sudoku! Here is your initial board");
    }

    /***
     * prints solution board to console
     */
    protected void printSolution(){
        System.out.println("   1  2  3   4  5  6   7  8  9  ");
        for(int i=0; i< solution.length; i++){
            if(i%3 == 0) { // print 3*3 row border
                System.out.println(" |---------+---------+---------|");
            }
            // start row -> "%s| %d  %d' %d'| %d  %d  %d | %d  %d' %d | \n"
            String row = "";
            row = row+ (char) ('A'+i); // add letter to row
            for(int j = 0; j<solution[0].length; j++){
                // adds 3*3 column border
                if(j%3 == 0) {
                    row = row + "|";
                }
                int cellNum = solution[i][j];
                row = row + " " + cellNum +" ";
                // add row border
                if(j == 8) {
                    row = row + "|";
                }
            }
            System.out.println(row); // print row
            if(i == 8) {            // print last border
                System.out.println(" |---------+---------+---------|");
            }
        }
    }

    /**
     * swaps cell entries in board if possible
     * prints error msg otherwise
     * @args cell1 index, cell2 index
     */
    protected boolean swap(int row1, int col1, int row2, int col2) {
        if(isValidCell(row1, col1) && isValidCell(row2, col2)) {
            int temp = board[row1][col1];
            board[row1][col1] = board[row2][col2];
            board[row2][col2] = temp;
            printBoard();
        } else {
            System.out.println("Error: Cell ID is invalid. May be filled in initial board (\' next to entry).");
        }
        return true;
    }

    /**
     * deletes cell entry if possible
     * prints error message otherwise
     * @param row,col;
     */
    protected boolean undo(int row, int col) {
        if(isValidCell(row, col)) {
            board[row][col] = 0;
            printBoard();
        } else {
            System.out.println("Error: Cell cannot be deleted, part of initial board.");
        }
        return true;
    }

    /**
     * enters player's number into board at cell if within board
     * and not filled in initial board
     * prints error msg otherwise
     * @param row,col,number;
     */
    protected boolean enter(int row, int col, int number) {
        if(isValidCell(row, col)) {
            board[row][col] = number;
            printBoard();
        } else {
            System.out.println("Error: Cell ID is invalid. " +
                    "May be filled in initial board with \' next to it.");
        }
        return true;
    }

    /**
     * checks if cell if a valid cell to delete or swap
     * cell entry
     * @param row,col;
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
     * compares board to solution for correctness
     * @return true if puzzle is complete
     */
    public boolean isCorrectSolution() {
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j<solution.length; j++){
                if (board[i][j] != solution[i][j]){
                    return false;
                }
            }
        }
        return true;
    }

}
