package com.example.Pokemon.Attaques;

import com.example.Pokemon.Nature;


public abstract class Attaque {
    private String name;
    private double dmgMultiplier;
    private Nature nature;
    private int ppMax;
    private int ppRestants;

    public Nature getNature() {
        return nature;
    }


    public void setNature(Nature nature) {
        this.nature = nature;
    }


    protected Attaque (String name, double dmgMultiplier, Nature nature, int ppMax) {
        this.name = name;
        this.dmgMultiplier = dmgMultiplier; 
        this.nature = nature;
        this.ppMax = ppMax;
        this.ppRestants = ppMax;
    }


    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getDmgMultiplier() {
        return dmgMultiplier;
    }
    public void setDmgMultiplier(double dmgMultiplier) {
        this.dmgMultiplier = dmgMultiplier;
    }


    public int getPpRestants() {
        return ppRestants;
    }


    public void setPpRestants(int ppRestants) {
        this.ppRestants = ppRestants;
    } 

    public void resetPpRestants() {
        this.ppRestants = ppMax;
    }

}
