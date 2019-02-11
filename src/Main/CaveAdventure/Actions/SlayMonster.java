package Main.CaveAdventure.Actions;

public class SlayMonster extends Action {

    private String monsterName;

    public SlayMonster() {
        if (getContent().equals("(no other mission)")) {
            todoLine = "Attack the " + monsterName;
        } else {
            todoLine = "Attack the " + monsterName + " and " + getContent();
        }
        haveDoneLine = "You have slayed the " + monsterName;
    }

    public SlayMonster(String content, String monsterName) {
        super(content);
        this.monsterName = monsterName;
        if (getContent().equals("(no other mission)")) {
            todoLine = "Attack the " + monsterName;
        } else {
            todoLine = "Attack the " + monsterName + " and " + getContent();
        }
        haveDoneLine = "You have slayed the " + monsterName;
    }

//    @Override
//    public String toString() {
//        return "The monster is: " + monsterName + " and the mission is " + getContent();
//    }

    /*** Getter and Setter ***/
    public String getMonsterName() {
        return monsterName;
    }

    public void setMonsterName(String monsterName) {
        this.monsterName = monsterName;
    }
}
