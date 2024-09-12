package com.example.Pokemon.Pokedex;

import java.util.ArrayList;
import java.util.List;

import com.example.Pokemon.Nature;
import com.example.Pokemon.Pokemon;
import com.example.Pokemon.Attaques.Attaque;
import com.example.Pokemon.Attaques.FouetLianne;
import com.example.Pokemon.Attaques.Lutte;

public class Bulbizarre extends Pokemon{

    public Bulbizarre() {
        super("Bulbizarre", Nature.FEUILLE);
        List<Attaque> attaques = new ArrayList<>();
        attaques.add(new FouetLianne());
        attaques.add(new Lutte());

        setAttaques(attaques);
    }

    @Override
    public void attaque(Pokemon adversaire, int attaque) {
        if (adversaire.getNature() == Nature.FEU) {
            adversaire.setPvRestants(adversaire.getPvRestants() - (int)(100 - this.getAttaques().get(attaque).getDmgMultiplier()));
        } else {
            adversaire.setPvRestants(adversaire.getPvRestants() - (int)(100 + this.getAttaques().get(attaque).getDmgMultiplier()));
        }
    }
}
