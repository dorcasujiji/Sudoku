import java.util.Scanner;

import com.sun.jndi.toolkit.ctx.StringHeadTail;

import sun.net.www.content.text.plain;

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
        System.out.println("Will end game ");
    }
    
    /**
     * removes number entry in cell 
     * @args cell ID 
     */
    private static boolean undoEntry(String cell) {
        // TODO: undo cell logic
        System.out.println("Will remove entry in cell " + cell);
        return true; 
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
            System.out.println("\n~Enter your next move [e.g. A1 4]: ");
            String move = reader.nextLine();
            move = move.toLowerCase(); // lower move
            
            // split move
            // if (len) == 3 : swap (swap A1 B3) 
            // if (len) == 2 : move (A1 8) OR undo (undo A1) 
            // if (len) == 1 : restart OR finish OR help
            // anything else, print wrong input msg, ask for help
            String[] entry = move.split(" ");
            switch (entry.length) {
            case 3:
                if(entry[0].equals("swap")) {
                    // TODO: swap cells 
                    // swap cells in args
                    System.out.println("Will swap cells " + entry[1] + " and " + entry[2] );
                } else {
                    invalidEntry(); 
                }
                break;
            case 2:
                if(entry[0].equals("undo")) {
                    // undo cell entry for args[1]
                    Boolean undone = undoEntry(entry[1]);
                    // TODO: check that undoing entry is possible
                    // ...
                } else {
                    char[] cell = entry[0].toCharArray();
                    if(cell.length == 2) {
                        // TODO: read cell and number move
                        // number to be entered in cell 
                        int numEntry = Integer.parseInt(entry[1]);
                        // TODO: do move logic
                        System.out.println("Will enter " + numEntry + " in cell " + entry[0]);
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
        board = new Board();
        board.printInstructions();
        board.printBoard();
        playGame();
    }
}
