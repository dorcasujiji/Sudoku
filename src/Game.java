import java.util.Scanner;

public class Game {
    /* Game board */
    private static Board board;

    /* Status of game */
    private static boolean playing = true;

    /**
     * restarts game with new board and set
     */
    private static void startGame() {
        board = new Board(); // get new random game board
        board.printInstructions();
        board.printBoard();
        playGame();
    }

    /**
     * ends game and checks if player completed
     * the game accurately
     */
    private static void endGame() {
        if(board.isCorrectSolution()) {
            playing = false;
            System.out.println("Congratulations you have successfully completed the puzzle!");
        } else {
            playing = false;
            System.out.println("Sorry your board was incorrect. Here is the solution: ");
            board.printSolution(); // prints solution
        }
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

        while (playing) {
            System.out.println("\n~ Enter your next move [e.g. A1 4]: ");
            String move = reader.nextLine();
            move = move.toLowerCase();
            String[] entry = move.split(" ");

            switch (entry[0]) {
                case "enter": //for multiple entries
                    if ((entry.length - 1) % 2 == 0) { // if args(excl "enter") are even
                        int i = 1;
                        while (i < entry.length) {
                            int[] index = getIndex(entry[i]);
                            board.enter(index[0], index[1], Integer.parseInt(entry[++i]));
                            i++;
                        }
                    } else
                        invalidEntry();
                    break;
                case "swap":
                    if(entry.length == 3) {
                        int[] index1 = getIndex(entry[1]);
                        int[] index2 = getIndex(entry[2]);
                        board.swap(index1[0], index1[1], index2[0], index2[1]);
                    } else {
                        invalidEntry();
                    }
                    break;
                case "undo":
                    if(entry.length == 2) {
                        int[] index = getIndex(entry[1]);
                        board.undo(index[0], index[1]);
                    } else {
                        invalidEntry();
                    }
                    break;
                case "help":
                    board.printInstructions();
                    break;
                case "restart":
                    startGame();
                    break;
                case "end":
                    endGame();
                    break;
                default:
                    // for single entries
                    if (entry.length == 2) {
                        int[] ind = getIndex(entry[0]);
                        board.enter(ind[0], ind[1], Integer.parseInt(entry[1]));
                    } else
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
        startGame();
    }
}
