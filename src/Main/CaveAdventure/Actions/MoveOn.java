package Main.CaveAdventure.Actions;

public class MoveOn extends Action {

    public MoveOn() {
        todoLine = "Move on to the next adventure";
        haveDoneLine = content;
    }

    public MoveOn(String content) {
        super(content);
        todoLine = "Move on to the next adventure";
        haveDoneLine = content;
    }
}
