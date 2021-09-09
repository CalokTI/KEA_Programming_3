import java.util.Arrays;
import java.util.List;

public class MethodReference {

    public MethodReference(String content){
        System.out.println(content);
    }

    public static void main(String[] args) {
        List<String> greetings = Arrays.asList("Hello World", "Godmorgen");

        //lambda funktion
        greetings.forEach((greeting) -> System.out.println(greeting));

        //method reference non static
        //greetings.forEach(new MethodReference()::out);

        //method reference static
        greetings.forEach(MethodReference::staticOut);

        //calls constructor
        greetings.forEach(MethodReference::new);



    }

    public void out(String content) {
        System.out.println(content);
    }

    public static void staticOut(String content){
        System.out.println(content);
    }


}
