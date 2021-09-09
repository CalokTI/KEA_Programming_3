public class GameOfOctopus extends Thread {


    @Override
    public void run() {
        System.out.println("Run has been called");

        Octopus otto = new Octopus();
        otto.makeDoActivity();

    }
}
