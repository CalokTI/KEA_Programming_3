package edu.kea.trash.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class SuperMarioController {
    Random random = new Random();
    String[] marioCharacters = new String[]{"Mario", "Luigi", "Toad", "Toadette", "Princess Peach",
            "Princess Daisy", "Yoshi", "Bowser", "Bowser jr.", "Roy", "Larry", "Morton", "Wendy", "Iggy",
            "Lemmy", "Ludwig"};

    SuperMarioCharacter superMarioCharacter = new SuperMarioCharacter();

    @GetMapping("/supermario/characters")
    public String returnRandomCharacter(){
        int randomNumber = random.nextInt(marioCharacters.length);

        return marioCharacters[randomNumber];
    }

    @GetMapping("/supermario/class")
    public SuperMarioCharacter returnClass(){
        return superMarioCharacter;
    }

    @GetMapping("/supermario/mario")
    public String returnMario(){
        return "Mario";
    }
    @GetMapping("/supermario/luigi")
    public String returnLuigi(){
        return "Luigi";
    }
    @GetMapping("/supermario/toad")
    public String returnToad(){
        return "toad";
    }
    @GetMapping("/supermario/Peach")
    public String returnPeach(){
        return "peach";
    }

}
