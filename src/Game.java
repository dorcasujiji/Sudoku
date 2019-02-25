import java.util.Scanner;
import java.util.Random;
import java.util.Arrays; 

public class Game {
    /* Game board */
    private static Board board;

    /* Status of game */
    private static boolean playing = true;

    /**
     * restarts game with new board and set
     */
    private static void restartGame() {
        Random random = new Random();
        int rand = (random.nextInt(100)+1) % 4;
        board = new Board(3); // get new random game board
        board.printInstructions();
        board.printBoard();
        playGame();
        // System.out.println("Will restart game");
    }

    /**
     * ends game and checks if player completed
     * the game accurately
     */
    private static void endGame(Board board) {
        int solutionNum = board.boardPicked + 3;
        int[][] boardByUser = board.board;
        Board solutionBoard = new Board(solutionNum);
        int[][] solutionBoardByComp = solutionBoard.board;
        boolean isEqual = board.isEqual(solutionBoardByComp, boardByUser);
        if (isEqual){
            System.out.println("You won!!!!!");
        }else{
            System.out.println("Sorry, here is the solution: ");
            solutionBoard.printSolution();
        }
        System.out.println(isEqual);
        playing = false;
    }

    /**
     * prints error message when user enters an invalid entry 
     */
    private static void invalidEntry() {
        System.out.println("Invalid Entry. Enter \"help\" for instructions.");
        playGame();
    }

    /**
     * returns the index of a cell as it should be on board array
     */
    private static int[] getIndex(String cell) {
        int[] index = new int[2];
        char[] ind = cell.toCharArray();
        char rowChar = (char) (ind[0] - '1');
        index[0] = Character.getNumericValue(rowChar);
        index[1] = Character.getNumericValue(ind[1]) - 1;
        return index;
    }

    /**
     * controls game play 
     */
    private static void playGame() {
        Scanner reader = new Scanner(System.in);  // Reading from System.in
        
        while(playing) {
            System.out.println("\n~ Enter your next move [e.g. A1 4]: ");
            String move = reader.nextLine();
            move = move.toLowerCase();
            String[] entry = move.split(" ");
            // split move
            // if move.len == 3 : swap (swap A1 B3)
            // if move.len == 2 : move (A1 8) OR undo (undo A1)
            // if move.len == 1 : restart OR finish OR help
            // anything else, print wrong input msg, ask for help

            switch (entry.length) {
            case 3:
                if(entry[0].equals("swap")) { // swap entries if possible
                    int[] index1 = getIndex(entry[1]);
                    int[] index2 = getIndex(entry[2]);
                    board.swap(index1[0], index1[1], index2[0], index2[1]);
                } else {
                    invalidEntry(); 
                }
                break;
            case 2:
                int[] index;
                if(entry[0].equals("undo")) { // undo cell entry for args[1]
                     index = getIndex(entry[1]);
                    board.undo(index[0], index[1]);
                } else {
                    if(entry[0].length() == 2) {
                        index = getIndex(entry[0]);
                        board.enter(index[0], index[1], Integer.parseInt(entry[1]));
                    } else {
                        invalidEntry();
                    }
                }
                break;
            case 1:
                if(entry[0].equals("restart")) {
                    restartGame();
                } else if(entry[0].equals("end")) {
                    endGame(board);
                } else if(entry[0].equals("help")) {
                    board.printInstructions();
                } else {
                    invalidEntry();
                }
                break;
            default:
                invalidEntry();
                break;
            }
        }
        // close at game end
        reader.close();
    }

    /**
     * main method 
     * calls methods that controls game play 
     */
    public static void main(String[] args) {
        Random random = new Random();
        int rand = (random.nextInt(50)%3)+1;
        board = new Board(rand); // get new random game board
        // System.out.println(rand);
        board.printInstructions();
        board.printBoard();
        playGame();
    }
}
