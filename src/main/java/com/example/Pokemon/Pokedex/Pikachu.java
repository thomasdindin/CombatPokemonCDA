package com.example.Pokemon.Pokedex;

import java.util.ArrayList;
import java.util.List;

import com.example.Pokemon.Nature;
import com.example.Pokemon.Pokemon;
import com.example.Pokemon.Attaques.Attaque;
import com.example.Pokemon.Attaques.Eclair;
import com.example.Pokemon.Attaques.Lutte;

public class Pikachu extends Pokemon{

    public Pikachu() {
        super("Pikachu", Nature.ECLAIR);

        List<Attaque> attaques = new ArrayList<>();
        attaques.add(new Eclair());
        attaques.add(new Lutte());

        setAttaques(attaques);
    }

    @Override
    public void attaque(Pokemon adversaire, int attaque) {
        if (adversaire.getNature() == Nature.FEUILLE) {
            adversaire.setPvRestants(adversaire.getPvRestants() - (int)(100 - this.getAttaques().get(attaque).getDmgMultiplier()));
        } else {
            adversaire.setPvRestants(adversaire.getPvRestants() - (int)(100 + this.getAttaques().get(attaque).getDmgMultiplier()));
        }
    }
    
}
