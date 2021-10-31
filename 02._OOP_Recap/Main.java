public class Main {

    public static void main(String[] args) {
        GameOfOctopus game = new GameOfOctopus();

        //game.run(); //implements Runnable in gameOfOctous - calls run in the main thread but doesn't create a new thread
        //Thread gameThread = new Thread(game);

        game.start(); //extends thread in gameOfOctopus - creates a new thread

    }

}
