package com.example;

import java.util.ArrayList;
import java.util.List;

import com.example.Pokemon.Pokemon;

public class Dresseur {
    private String nom;
    private List<Pokemon> pokemons;
    private Pokemon pokemonActif; 

    Dresseur (String nom) {
        this.nom = nom;
        pokemons = new ArrayList<>();
    }

    public String getNom() {
        return nom;
    }


    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    public void setPokemons(List<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }


    public Pokemon getPokemonActif() {
        return pokemonActif;
    }

    public void setPokemonActif(Pokemon pokemonActif) {
        this.pokemonActif = pokemonActif;
    }

    public void choisirPokemon (int index) {
        this.pokemonActif = this.pokemons.get(index);
    }

    public boolean estEquipeKo() {
        boolean tousKo = true;

        for (Pokemon pokemon : this.pokemons) {
            if (pokemon.getPvRestants() != 0) {
                tousKo = false;
            }
        }

        return tousKo;
    }

    
}
