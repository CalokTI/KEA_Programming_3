import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringStream {

    public static void main(String[] args) {
        //Create a list of strings that contains cool words

        List<String> coolio = Arrays.asList("༼ つ ◕_◕ ༽つ", "(╯°□°）╯︵ ┻━┻)","(*/ω＼*)");
        List<String> coolio2 = Arrays.asList("Hest","hest","gnu","","gnu","","Oink","");
        System.out.println(coolio2);


        List<String> onlyWords = coolio2.stream().filter(word -> word.length() > 0).collect(Collectors.toList());
        System.out.println(onlyWords);

        int vocabulary = (int) coolio2.stream().distinct().count();
        int vocabulary2 = (int) coolio2.stream().distinct().filter(word -> word.length() > 0).count();
        int vocabulary3 = coolio2.size();
        System.out.println(vocabulary);
        System.out.println(vocabulary2);
        System.out.println(vocabulary3);


        String sentence = coolio2.stream().filter(word -> !word.isEmpty()).collect(Collectors.joining(" ")) + ".";
        System.out.println(sentence);


    }


}
