package Main.CaveAdventure.Actions;

public class PickUpTreasure extends Action {

    private Boolean isTrueTreasure;

    public PickUpTreasure() {
        todoLine = "Pick up " + content;
        haveDoneLine = "You have picked up " + content;
    }

    public PickUpTreasure(String content, boolean isTrueTreasure) {
        super(content);
        todoLine = "Pick up " + content;
        haveDoneLine = "You have picked up " + content;
        this.isTrueTreasure = isTrueTreasure;
    }

//    @Override
//    public String toString() {
//        return "The treasure is " + getContent() + ", but should you pick it up? " + isTrueTreasure;
//    }

    /*** Getter and Setter ***/

    public Boolean isTrueTreasure() {
        return isTrueTreasure;
    }

    public void setRightTreasure(Boolean isTrueTreasure) {
        this.isTrueTreasure = isTrueTreasure;
    }
}
