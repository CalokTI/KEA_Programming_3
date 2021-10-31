import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

public class NumberStream {
    public static void main(String[] args) {
        List <Integer> numbers = Arrays.asList(1,2,2,3,4,4,5,6,7,8,8,9,0);
        System.out.println(numbers);

        int sum = numbers.stream().mapToInt(number -> number).sum();
        double averageTemperature = numbers.stream().mapToInt(number -> number).average().getAsDouble();

        List <Integer> squaredNumbers =  numbers
                                            .stream()
                                            .map(nomNom -> nomNom * nomNom)
                                            .collect(Collectors.toList());


        List<Integer> evenNumbers = numbers.stream().filter(number -> number % 2 == 0).collect(Collectors.toList());
        List<Integer> oddNumbers = numbers.stream().filter(number -> number % 2 != 0).collect(Collectors.toList());
        List<Integer> distinctNumbers = numbers.stream().distinct().collect(Collectors.toList());

        IntSummaryStatistics summary = numbers.stream().mapToInt(number -> number).summaryStatistics();


        System.out.println("Sum: " + sum);
        System.out.println("Average: " + averageTemperature);

        System.out.println(squaredNumbers);
        System.out.println(evenNumbers);
        System.out.println(oddNumbers);
        System.out.println(distinctNumbers);

        System.out.println(summary);
    }
}
