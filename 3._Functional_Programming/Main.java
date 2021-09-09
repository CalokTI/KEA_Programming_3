import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        AbstractClass abstractClassImplemented = new AbstractClass() {
            @Override
            public void makeSurrealArt() {
                System.out.println("Created by Dali!");
            }
        };

        Comparator<String> stringComparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        };

        stringComparator.compare("hello", "world");

        Comparator<String> stringComparatorLambda = (String firstString, String secondString) -> firstString.compareTo(secondString);
        System.out.println(stringComparatorLambda.compare("a", "b"));

        String a = "hello";
        String b = "world";

        System.out.println(a.compareTo(b));


        AbstractClass abstractClassImplemented2 = new AbstractClass() {
            @Override
            public void makeSurrealArt() {

            }
        };
        //implementation of a functional interface
        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        };
        System.out.println(comparator.compare("b", "a"));


        Comparator<String> lambdaComparator = (String firstString, String secondString) -> firstString.compareTo(secondString);


        Concatenator concat = (String firstString, String secondString) -> (firstString + secondString);

        System.out.println(concat.cat(a, b));

    }

}
