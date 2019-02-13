
public class Board {
    private static void showBoard() {
        System.out.println("Welcome to Sudoku.\n\n"
                + "- To enter a number in a cell, input the cell ID "
                + "\ni.e. the row letter and column number together "
                + "followed by the number you would like to be in the cell"
                + " E.g. A1 8 \n"
                + "- To delete a number you entered from a cell, enter \"Undo\" followed by "
                + "the cell ID. E.g. Undo A1 \n"
                + "- To swap two cells, input \"Swap\" and both cell IDs. E.g. Swap A1 F6 \n"
                + "- To restart the game, input \"Restart\" \n"
                + "- To complete the game after finishing the board, input \"Finish\" \n");
        System.out.println("Have fun playing Sudoku! Here is your initial board");
        System.out.println("   1  2  3   4  5  6   7  8  9  ");
        System.out.println(" |---------+---------+---------|");
        System.out.println("A| *  5' 8'| *  *  * | *  4' * |");
        System.out.println("B| 1  *  * | *  *  7'| *  *  6'|");
        System.out.println("C| 7  *  * | 9' *  5'| *  2' 1'|");
        System.out.println(" |---------+---------+---------|");
        System.out.println("D| *  4' 2'| 6' *  9'| *  *  * |");
        System.out.println("E| *  7' * | 1  4  8 | 5  3' * |");
        System.out.println("F| *  *  * | 5' *  2'| 9' 6' * |");
        System.out.println(" |---------+---------+---------|");
        System.out.println("G| 9' 6' * | 2' *  3'| *  1  8'|");
        System.out.println("H| 8' *  * | 7' *  * | *  *  * |");
        System.out.println("I| *  1' * | *  *  * | 2' 9' * |");
        System.out.println(" |---------+---------+---------|");
        System.out.println("What is your move? E.g.: A1 8");
    }
    
//    public static void main(String[] args) {
//        showBoard();
//    }

}
