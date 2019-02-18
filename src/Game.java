import java.util.Scanner;

public class Game {
    /* Game board */
    private static Board board;

    /* Status of game */
    private static boolean playing = true;

    /**
     * restarts game with new board and set
     */
    private static void restartGame() {
        // TODO: restart game logic
        System.out.println("Will restart game");
    }

    /**
     * ends game and checks if player completed
     * the game accurately
     */
    private static void endGame() {
        // TODO: end game logic
        System.out.println("Will end game");
    }

    /**
     * prints error message when user enters an invalid entry 
     */
    private static void invalidEntry() {
        System.out.println("Invalid Entry. Enter \"help\" for instructions.");
        playGame();
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
            int row, col;
            char[] index= new char[2];

            if(entry.length == 2) {
                if(entry[0].length() == 2)
                    index = entry[0].toCharArray();
                else
                    index = entry[1].toCharArray();
            } else if(entry.length == 3) {
                index = entry[1].toCharArray();
            }
            char rowChar = (char) (index[0] - '1');
            row = Character.getNumericValue(rowChar);
            col = Character.getNumericValue(index[1]) - 1;

            // split move
            // if move.len == 3 : swap (swap A1 B3)
            // if move.len == 2 : move (A1 8) OR undo (undo A1)
            // if move.len == 1 : restart OR finish OR help
            // anything else, print wrong input msg, ask for help

            switch (entry.length) {
            case 3:
                if(entry[0].equals("swap")) { // swap entries if possible
                    board.swap(entry[1], entry[2]);
                } else {
                    invalidEntry(); 
                }
                break;
            case 2:
                if(entry[0].equals("undo")) { // undo cell entry for args[1]
                    board.undo(row, col);
                } else {
                    if(entry[0].length() == 2) {
                        board.enter(row, col, Integer.parseInt(entry[1]));
                    } else {
                        invalidEntry();
                    }
                }
                break;
            case 1:
                if(entry[0].equals("restart")) {
                    restartGame();
                } else if(entry[0].equals("end")) {
                    endGame();
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
        board = new Board(); // get new random game board
        board.printInstructions();
        board.printBoard();
        playGame();
    }
}
