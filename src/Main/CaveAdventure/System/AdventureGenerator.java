package Main.CaveAdventure.System;

import Main.CaveAdventure.Adventure.Adventure;
import Main.CaveAdventure.Adventure.FinalAdventure;
import Main.CaveAdventure.Adventure.StartingAdventure;
import Main.CaveAdventure.Bean.Player;

public class AdventureGenerator {

    private Player player;

    public AdventureGenerator() {

    }

    public AdventureGenerator(Player player) {
        this.player = player;
    }

    //Generate the first adventure
    public StartingAdventure generateTheStart(int index) {
        StartingAdventure startingAdventure = new StartingAdventure(player, index);
        startingAdventure.addAction(ResourceHolder.getOneMonsterByAdventureIndex(index));
        startingAdventure.addAction(ResourceHolder.getOneTrueTreasureByAdventureIndex(index));
        return startingAdventure;
    }

    //Generate middle adventures
    public Adventure generateNormalAdventure(int index) {
        Adventure adventure = new Adventure(player, index);
        adventure.addAction(ResourceHolder.getOneMonsterByAdventureIndex(index));
        adventure.addAction(ResourceHolder.getOneTrueTreasureByAdventureIndex(index));
        return adventure;
    }

    //Generate the last adventure
    public FinalAdventure generateFinalAdventure(int index) {
        FinalAdventure finalAdventure = new FinalAdventure(player, index);
        finalAdventure.addAction(ResourceHolder.getOneMonsterByAdventureIndex(index));
        finalAdventure.addAction(ResourceHolder.getOneTrueTreasureByAdventureIndex(index));
        return finalAdventure;
    }
}
