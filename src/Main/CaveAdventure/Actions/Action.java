package Main.CaveAdventure.Actions;

public abstract class Action {

    protected String content;
    protected boolean completed;
    protected String todoLine;
    protected String haveDoneLine;

    public Action() {
        todoLine = new String("");
        haveDoneLine = new String("");
    }

    public Action(String content) {
        this();
        this.content = content;
    }

    /*** Setter and Getter ***/

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public boolean isCompleted() {
        return completed;
    }

    public String getHaveDoneLine() {
        return haveDoneLine;
    }

    public void setHaveDoneLine(String haveDoneLine) {
        this.haveDoneLine = haveDoneLine;
    }

    public String getTodoLine() {
        return todoLine;
    }

    public void setTodoLine(String todoLine) {
        this.todoLine = todoLine;
    }
}
