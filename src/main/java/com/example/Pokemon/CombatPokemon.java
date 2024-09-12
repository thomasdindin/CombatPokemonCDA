package com.example.Pokemon;

import java.util.Scanner;

import com.example.Dresseur;

public class CombatPokemon {
    Dresseur dresseur1;
    Dresseur dresseur2;
    int indexPokemonJoueur2 = 0 ;
    Scanner scan = new Scanner(System.in);

    public CombatPokemon(Dresseur dresseur1, Dresseur dresseur2){
        this.dresseur1 = dresseur1;
        this.dresseur2 = dresseur2;

        dresseur2.choisirPokemon(indexPokemonJoueur2);
        combat();
    }

    void combat(){
        int attaque = 0;
        dresseurChoixCombattant();
        while (!dresseur1.estEquipeKo() || !dresseur2.estEquipeKo()) {
            System.out.println("Quelle attaque devrait utiliser " + dresseur1.getPokemonActif().getName() + "?");
            attaque = scan.nextInt();
            dresseur1.getPokemonActif().attaque(dresseur2.getPokemonActif(), attaque);

            if (dresseur2.getPokemonActif().isKo() && !dresseur2.estEquipeKo()) {
                System.out.println(dresseur2.getPokemonActif().getName() + " est KO ! ");
                dresseur1.getPokemonActif().addExp(35);
                indexPokemonJoueur2++;
                dresseur2.choisirPokemon(indexPokemonJoueur2);
                System.out.println(dresseur2.getNom() + "envoie " + dresseur2.getPokemonActif().getName());
            }

            if (!dresseur2.estEquipeKo()) {
                dresseur2.getPokemonActif().attaque(dresseur1.getPokemonActif(), 0);

                if (dresseur1.getPokemonActif().isKo()) {
                    System.out.println(dresseur1.getPokemonActif().getName() + " est KO ! ");
                    dresseur2.getPokemonActif().addExp(35);
                    dresseurChoixCombattant();
                }
            }

        }
    }

    void dresseurChoixCombattant() {
        System.out.println(dresseur1.getNom() + " choisi son pokémon : ");
        try {
            int step = 0;
            for (Pokemon pokemon : dresseur1.getPokemons()) {
                if (pokemon.getPvRestants() >= 0) {
                    System.out.println(Integer.toString(step) + pokemon);
                }
                step++;
        }
            int PokemonChoisi = scan.nextInt();
            dresseur1.choisirPokemon(PokemonChoisi);
            System.out.println(dresseur1.getNom() + " envoie " + dresseur1.getPokemonActif().getName());
        } catch (Exception e) {
            dresseurChoixCombattant();
        }
    }
}
