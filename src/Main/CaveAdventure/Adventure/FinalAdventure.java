package Main.CaveAdventure.Adventure;

import Main.CaveAdventure.Bean.Player;

import java.util.*;

public class FinalAdventure extends Adventure {

    private Set<String> words;

    public FinalAdventure(Player player, int adventureIndex) {
        super(player, adventureIndex);
        setFirstLine("now reached the depths of the caves");
        words = new HashSet<>();
    }

    private void poem() {
        Scanner scanner = new Scanner(System.in);
        for (int i = 1 ; i <= 100 ; i++) {
            System.out.println("Village Idiot #" + i + ", what is your special word? (EOP to stop)");
            String word = scanner.nextLine();
            if (word.equals("EOP"))       //EOP == End of Poem
                break;
            else
                words.add(word);
        }
        //Generate the poem
        System.out.println("Now the poem is (drum roll here....): ");
        Iterator<String> iterator = words.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
    }

    @Override
    public void adventure() {
        System.out.println();
        System.out.println("Great! You have " + firstLine + ", what would you like to do? \n");
        run();
        System.out.println("Are you ready for the final mission (Y/N)?");
        Scanner scanner = new Scanner(System.in);
        while (scanner.nextLine().charAt(0) != 'Y') {
            System.out.println("Put yourself together brave knight, are you ready for the final mission (Y/N)?");
        }
        poem();
    }
}
