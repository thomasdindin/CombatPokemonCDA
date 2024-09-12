package com.example;

import java.util.ArrayList;
import java.util.List;

import com.example.Pokemon.CombatPokemon;
import com.example.Pokemon.Pokemon;
import com.example.Pokemon.Pokedex.Bulbizarre;
import com.example.Pokemon.Pokedex.Pikachu;

public class App {
    public static void main(String[] args) {
        Dresseur dresseur1 = new Dresseur("Thomas");
        Dresseur dresseur2 = new Dresseur("Ennemi");

        List<Pokemon> equipeBulbizarre = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            equipeBulbizarre.add(new Bulbizarre());
        }

        List<Pokemon> equipePikachu = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            equipePikachu.add(new Pikachu());
        }

        dresseur1.setPokemons(equipeBulbizarre);
        dresseur2.setPokemons(equipePikachu);

        CombatPokemon combat1= new CombatPokemon(dresseur1, dresseur2);
    }
}
