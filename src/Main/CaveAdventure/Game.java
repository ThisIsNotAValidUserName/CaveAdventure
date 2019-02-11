package Main.CaveAdventure;

import Main.CaveAdventure.Bean.Player;
import Main.CaveAdventure.Adventure.Adventure;
import Main.CaveAdventure.System.AdventureManager;
import Main.CaveAdventure.System.ResourceHolder;

import java.util.Scanner;

public class Game {

    private Player player;
    private AdventureManager adventureManager;
    private ResourceHolder resourceHolder;

    /**
     * Run the game
     */
    public Game() {
        player = new Player();
        initialization();
    }

    public Game(Player player) {
        this.player = player;
        initialization();
    }

    public void run() {
        /*** Game Start ***/
        for (Adventure adventure : adventureManager.getAdventures()) {
            if (!player.isDead())
                adventure.adventure();
        }

        /*** Game End ***/
        if (!player.isDead())
            System.out.println("Congratulations brave knight!!!You have defeated the evil goblins and saved the village.");
        System.out.println("The game will not exit...");
    }

    private void initialization() {
        /*** Input player information ***/
        System.out.println("Brave knight, what is your name? ");
        Scanner scanner = new Scanner(System.in);
        player.setName(scanner.nextLine());

        /*** Game Resource Initialization ***/
        resourceHolder = new ResourceHolder();
        resourceHolder.loadResources();

        /*** Generate Adventures ***/
        adventureManager = new AdventureManager(player);
        int trickNumber = adventureManager.adventureToSecondTreasure();
        for (int i = 0 ; i < AdventureManager.getNumOfAdventures() ; i++) {
            Adventure adventure = adventureManager.generateAdventure(i);
            if (i == trickNumber)
                adventure.setThereIsATrick(true);
            adventureManager.addAdventure(adventure);
        }
    }

    /*** Setter and Getter ***/
    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
