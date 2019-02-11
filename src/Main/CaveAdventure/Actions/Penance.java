package Main.CaveAdventure.Actions;

public class Penance extends Action {

    public Penance() {
        todoLine = "They tricked you into picking up a second treasure, your penance is to " + content + ".";
        haveDoneLine = "Great! You have done your penance, what would you like to do? ";
    }

    public Penance(String content) {
        super(content);
        todoLine = "They tricked you into picking up a second treasure, your penance is to " + content + ".";
        haveDoneLine = "Great! You have done your penance, what would you like to do? ";
    }

}
