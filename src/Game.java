
public class Game {

    
    /**
     * controls game play 
     */
    private static void startGame() {
       // TODO: game play logic
       
    }

    /**
     * main method 
     * calls methods that controls game play 
     */
    public static void main(String[] args) {
        Board board = new Board();
        board.showInstructionAndBoard();;
        startGame();
    }
}
