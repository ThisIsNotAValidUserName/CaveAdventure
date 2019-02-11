package Main.CaveAdventure.Adventure;

import Main.CaveAdventure.Bean.Player;
import Main.CaveAdventure.Actions.*;
import Main.CaveAdventure.System.AdventureManager;
import Main.CaveAdventure.System.ResourceHolder;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Adventure {

    /***
     * In each adventure, the player needs to slay a monster and pick up a hidden treasure
     */
    private int adventureIndex;

    private List<Action> actions;

    private boolean monsterSlayed;
    private boolean treasureFound;
    private boolean missionCompleted;
    private boolean thereIsATrick;

    protected Player player;
    protected String firstLine;

    public Adventure() {
        actions = new ArrayList<>();
        firstLine = "ventured deeper into the cave";
    }

    public Adventure(Player player, int adventureIndex) {
        this();
        this.player = player;
        this.adventureIndex = adventureIndex;
    }

    public void adventure() {
        System.out.println();
        System.out.println("You have " + firstLine + ", what would you like to do?" );
        run();
    }

    protected void run() {
        Scanner scanner = new Scanner(System.in);
        while (!player.isDead()) {
            int numberOfChoices = actions.size() > 1 ? 2 : 1;
            for (int i = 0 ; i < numberOfChoices ; i++) {
                System.out.println("    " + (i + 1) + ")  " + actions.get(i).getTodoLine());
            }

            String choice = scanner.nextLine();
            while (!isValidOption(numberOfChoices, choice)) {
                System.out.println("Please brave knight, tell us what would you do (1/2): ");
                choice = scanner.nextLine();
            }

            int num = Integer.parseInt(choice) - 1;
            Action action = actions.get(num);

            if (action instanceof SlayMonster) {
                monsterSlayed = true;
                actions.remove(num);
                if (treasureFound && monsterSlayed) {
                    missionCompleted = true;
                    System.out.print(action.getHaveDoneLine());
                    if (adventureIndex == AdventureManager.getNumOfAdventures() - 1) {
                        System.out.println(", you are ready for the final mission.\n ");
                        break;
                    } else
                        System.out.println(", you are ready for the next adventure.\n ");
                } else {
                    System.out.println(action.getHaveDoneLine() + ", what would you like to do?\n ");
                }
            } else if (action instanceof PickUpTreasure) {
                if (treasureFound) {
                    //Pick up the second treasure
                    Penance penance = ResourceHolder.getOnePenance();
                    System.out.println(penance.getTodoLine());
                    System.out.println("Blah blah blah.......");

                    System.out.println(penance.getHaveDoneLine());
                    actions.remove(num);
                    continue;
                }

                treasureFound = true;
                actions.remove(num);

                if (thereIsATrick) {
                    actions.add(ResourceHolder.getOneFalseTreasure());
                }

                if (treasureFound && !monsterSlayed) {
                    rest();
                } else if (treasureFound && monsterSlayed) {
                    missionCompleted = true;
                    System.out.print(action.getHaveDoneLine() + " and slayed the evil monster");
                    if (adventureIndex == AdventureManager.getNumOfAdventures() - 1) {
                        System.out.println(", you are ready for the final mission.\n ");
                        break;
                    } else
                        System.out.println(", you are ready for the next adventure.\n ");
                } else
                    System.out.println(action.getHaveDoneLine() + ", what would you like to do?\n ");

            } else if (action instanceof MoveOn) {
                if (!treasureFound) {
                    System.out.println("You cannot move on to the next adventure without the treasure.....you are dead.\n");
                    player.setDead(true);
                    break;
                } else {
                    actions.remove(num);
                    break;
                }
            }

            if ((actions.size() < 2 && monsterSlayed && !missionCompleted) || actions.isEmpty()) {
                actions.add(new MoveOn());
            }
        }
    }

    private void rest() {
        System.out.println("You have picked up the treasure, now go rest before continuing the mission. ");
        List<String> songLyrics = ResourceHolder.randomMcDonald();
        for (String str : songLyrics) {
            System.out.println(str);
        }
        System.out.println("Great! You are awake and rested what would you like to do?" );
    }

    public void addAction(Action action) {
        actions.add(action);
    }

    private boolean isValidOption(int numberOfOptions, String option) {
        try{
            int choice = Integer.parseInt(option);
            if (choice < 1 || choice > numberOfOptions)
                return false;
            else
                return true;
        } catch(NumberFormatException e) {
            return false;
        }
    }

    /*** Setter and Getter ***/
    public void setFirstLine(String firstLine) {
        this.firstLine = firstLine;
    }

    public boolean isMonsterSlayed() {
        return monsterSlayed;
    }

    public boolean isTreasureFound() {
        return treasureFound;
    }

    public boolean isMissionCompleted() {
        return missionCompleted;
    }

    public void setThereIsATrick(boolean thereIsATrick) {
        this.thereIsATrick = thereIsATrick;
    }

    public boolean isThereIsATrick() {
        return thereIsATrick;
    }
}
