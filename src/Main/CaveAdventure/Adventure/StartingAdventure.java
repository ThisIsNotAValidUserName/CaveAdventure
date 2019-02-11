package Main.CaveAdventure.Adventure;

import Main.CaveAdventure.Bean.Player;

import java.util.Scanner;

public class StartingAdventure extends Adventure {

    public StartingAdventure(Player player, int adventureIndex) {
        super(player, adventureIndex);
        setFirstLine("now entering the mouth of the cave");
    }

    @Override
    public void adventure() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("We are in need of your help, " + player.getName() + "!");
        System.out.println("Our village is being overrun by the goblins of the NorthernCaves.");
        System.out.println("We need you to defeat them!");
        System.out.println("Will you accept the challenge (Y/N)?");
        while (scanner.nextLine().charAt(0) != 'Y') {
            System.out.println("... Please, please help up brave knight, are you ready to accept the challenge (Y/N)?");
        }
        System.out.println("Thank You Thank You Oh brave knight, are you ready to enter the mouth of the caves (Y/N)?");
        while (scanner.nextLine().charAt(0) != 'Y') {
            System.out.println("... Please, please help up brave knight, are you ready to enter the mouth of the caves (Y/N)?");
        }
        System.out.println("You are " + firstLine + ", what would you like to do? \n");
        run();
    }
}
