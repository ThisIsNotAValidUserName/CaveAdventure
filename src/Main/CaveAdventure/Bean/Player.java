package Main.CaveAdventure.Bean;

import Main.CaveAdventure.Actions.Action;

public class Player {

    private String name;
    private boolean isDead;

    public Player() {
        //Default constructor
        name = new String("Default player");
        isDead = false;
    }

    public Player(String name) {
        this.name = name;
        isDead = false;
    }

    /*** Setter and Getter ***/

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDead(boolean dead) {
        isDead = dead;
    }

    public boolean isDead() {
        return isDead;
    }
}
