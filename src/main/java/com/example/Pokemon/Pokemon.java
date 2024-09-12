package com.example.Pokemon;

import java.util.HashMap;
import java.util.List;

import com.example.Pokemon.Attaques.Attaque;

public abstract class Pokemon {
    private String name;
    private int level;
    private Nature nature;
    private List<Attaque> attaques; 
    private int exp;
    private int expToLvlUp;
    private int pvRestants;

    private HashMap<String, Integer> stats; 

    protected Pokemon (String name, Nature nature) {
        this.name = name;
        this.nature = nature;

        this.stats = new HashMap<>();
        this.stats.put("Attaque", (int) (Math.random() * 10) + 1);
        this.stats.put("Santé", (int) (Math.random() * 20) + 10);
        this.stats.put("Défense", (int) (Math.random() * 5) + 1);

        this.pvRestants = getSanté();

        this.exp =expPourNiveau();
        this.expToLvlUp = 100;
        this.level = 1;
    }

    
    public int getPvRestants() {
        return pvRestants;
    }


    public void setPvRestants(int pvRestants) {
        this.pvRestants = pvRestants;
    }


    private int expPourNiveau() {
        return (int) (100 * Math.pow(1.5, this.level - 1));
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public Nature getNature() {
        return nature;
    }
    public List<Attaque> getAttaques() {
        return attaques;
    }

    public void setAttaques(List<Attaque> attaques) {
        this.attaques = attaques;
    }

    public void addExp(int exp) {
        this.exp += exp;

        if (this.exp > this.expToLvlUp) {
            System.out.println(name + " monte de niveau !");
            levelUp();
        }
    }

    public int getAttaque(){
        return this.stats.get("Attaque");
    }

    public int getDéfense(){
        return this.stats.get("Défense");
    }

    public int getSanté(){
        return this.stats.get("Santé");
    }

    private void levelUp(){
        this.level++;
        int atk = getAttaque() + (int) (Math.random() * 4) + 1;
        int pv = this.stats.get("Santé") + (int) (Math.random() * 4) + 1;
        int def = this.stats.get("Défense") + (int) (Math.random() * 4) + 1;

        this.stats.put("Attaque", atk);
        this.stats.put("Santé", pv);
        this.stats.put("Défense", def);

        this.expToLvlUp = expPourNiveau();
    }

    public boolean isKo(){
        return pvRestants<=0;
    }

    public abstract void attaque(Pokemon adversaire, int attaque);


    @Override
    public String toString() {
        return "Il reste " + pvRestants + "PV à votre " + name +". Il est actuellement niveau " + level +", et il lui reste " +( expToLvlUp - exp) + " points d'expérience à gagner avant de monter de niveau.\nSes stats sont : Attaque : " + getAttaque() +" défense : " + getDéfense();
    }
}
