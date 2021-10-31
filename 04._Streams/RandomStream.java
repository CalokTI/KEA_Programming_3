import java.util.Random;

public class RandomStream {
    public static void main(String[] args) {
        Random random = new Random(1);
        //random.nextInt(); //not a stream
        random.ints().limit(7).skip(4).forEach(System.out::println);
    }
}
