package Main.CaveAdventure.System;

import Main.CaveAdventure.Actions.SlayMonster;
import Main.CaveAdventure.Actions.Penance;
import Main.CaveAdventure.Actions.PickUpTreasure;
import Main.Utils.Utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class ResourceHolder {

    private static List<Penance> penances;
    private static List<String> mcdonaldLyrics;
    private static List<PickUpTreasure> trueTreasures;
    private static List<PickUpTreasure> falseTreasures;
    private static List<SlayMonster> monsters;

    public ResourceHolder() {
        penances = new ArrayList<>();
        mcdonaldLyrics = new ArrayList<>();
        trueTreasures = new ArrayList<>();
        falseTreasures = new ArrayList<>();
        monsters = new ArrayList<>();
    }

    public void loadResources() {
        loadPenance();
        loadMcDonald();
        loadTreasures();
        loadMonsters();
    }

    /*** Load resources ***/
    public void loadPenance() {
        List<String> temp = Utils.loadFile("resource//penance.txt");
        for (String str : temp) {
            penances.add(new Penance(str));
        }
    }

    public void loadMcDonald() {
        mcdonaldLyrics = Utils.loadFile("resource//mcdonald.txt");
    }

    public void loadTreasures() {
        List<String> temp = Utils.loadFile("resource//treasures.txt");
        for (String str : temp) {
            String[] info = str.split("#");
            PickUpTreasure treasure = new PickUpTreasure(info[0], info[1].equals("false") ? false : true);
            if (treasure.isTrueTreasure())
                trueTreasures.add(treasure);
            else
                falseTreasures.add(treasure);
        }
    }

    public void loadMonsters() {
        List<String> monsterName = Utils.loadFile("resource//monsters.txt");
        List<String> missions = Utils.loadFile("resource//missions.txt");
        for (int i = 0; i < AdventureManager.getNumOfAdventures() ; i++) {
            //SlayMonster monster = new SlayMonster(missions.get(i), monsterName.get(i));
            monsters.add(new SlayMonster(missions.get(i), monsterName.get(i)));
        }
    }
    /*** Load resources end ***/

    /**
     * Randomly return a penance.
     */
    public static Penance getOnePenance() {
        //Each penance can be selected more than once.
        Random random = new Random();
        int n = random.nextInt(penances.size());
        return penances.get(n);
    }

    public static SlayMonster getOneMonsterByAdventureIndex(int i) {
        return monsters.get(i);
    }

    public static PickUpTreasure getOneTrueTreasureByAdventureIndex(int i) {
        return trueTreasures.get(i);
    }

    /**
     * Randomly return a false treasure
     */
    public static PickUpTreasure getOneFalseTreasure() {
        Random random = new Random();
        int n = random.nextInt(falseTreasures.size());
        return falseTreasures.get(n);
    }

    /**
     * Shuffle the lyrics of the McDonald song and return it.
     */
    public static List<String> randomMcDonald() {
        Collections.shuffle(mcdonaldLyrics);
        return mcdonaldLyrics;
    }
}
