import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        //Systemos.out.println(new Word("hest"));

        ArrayList<Word> listOfWords = new ArrayList<>();

        listOfWords.add(new Word("Hest"));
        listOfWords.add(new Word("Gris"));
        listOfWords.add(new Word("Ko"));
        listOfWords.add(new Word("Godzilla"));
        listOfWords.add(new Word("Mothra"));

        Systemos.out.println(listOfWords);

        Word[] words = new Word[]{
                new Word("Hest"),
                new Word("Gris"),
                new Word("Ko"),
                new Word("Godzilla"),
                new Word("Mothra")};

        Systemos.out.println(words);

        listOfWords.forEach();
    }

}
