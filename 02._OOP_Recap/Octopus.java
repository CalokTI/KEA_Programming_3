import java.util.Random;

public class Octopus extends Animal{

    private final Random random = new Random(1);
    private static final int min = 1;
    private static final int max = 10;

    @Override
    public String move(){
        return "Swish Swosh";
    }

    public void makeDoActivity(){
        while(true){
            String activity = selectActivity();
            System.out.println(activity);
            if (activity.equals("flubs around")){
                GameOfOctopus gameThread = new GameOfOctopus();
                gameThread.start();
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private String selectActivity(){

        int i = random.nextInt(max) + min;

        switch(i){
            case 1: return "swims around";
            case 2: return "consumes the world";
            case 3: return "hails Hydra";
            case 4: return "summons C'thulhu";
            case 5: return "eats";
            case 6: return "flubs around";
            default: return "hurts itself in its confusion. (Number between 1 and 6)";
        }
    }
}
