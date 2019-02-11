package Main.CaveAdventure.System;

import Main.CaveAdventure.Bean.Player;
import Main.CaveAdventure.Adventure.Adventure;
import java.util.Vector;

public class AdventureManager {

    private Vector<Adventure> adventures;
    private Player player;

    private AdventureGenerator adventureGenerator;

    //Must be equal to or lesser than 3 because there are not enough resources for more than 3 adventures (treasures etc.)
    private static final int numOfAdventures = 3;

    public AdventureManager() {

    }

    public AdventureManager(Player player) {
        adventures = new Vector<>();
        adventureGenerator = new AdventureGenerator(player);
        this.player = player;
    }

    public void addAdventure(Adventure adventure) {
        adventures.add(adventure);
    }

    public Adventure generateAdventure(int index) {
        if (index == 0) {
            return adventureGenerator.generateTheStart(index);
        }
        else if (index == numOfAdventures - 1) {
            return adventureGenerator.generateFinalAdventure(index);
        }
        else {
            return adventureGenerator.generateNormalAdventure(index);
        }
    }

    public int adventureToSecondTreasure() {
        return (int)(0 + Math.random() * numOfAdventures);
    }

    /*** Getter and Setter ***/
    public static int getNumOfAdventures() {
        return numOfAdventures;
    }

    public Vector<Adventure> getAdventures() {
        return adventures;
    }
}
