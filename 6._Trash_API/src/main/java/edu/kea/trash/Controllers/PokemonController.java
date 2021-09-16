package edu.kea.trash.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class PokemonController {

    private List<String> pokemons = Arrays.asList("Bulbasaur", "Ivysaur", "Venusaur", "Charmander", "Charmeleon", "Charizard", "Squirtle", "Wartortle", "Blastoise");

    //todo create an endpoint /pokemon/go
    //todo return true or false

    @GetMapping("pokemon/go")
    public boolean renderpokemonGo(){
        return true;
    }

    //todo create an arraylist that contains pokemon and
    //todo create a route (on /pokemon) that serves them

    @GetMapping("pokemon")
    public List renderPokemonList(){
        return pokemons;
    }


}
