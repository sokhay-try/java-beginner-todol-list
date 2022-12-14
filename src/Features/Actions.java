package Features;

public abstract class Actions {

    public static final int ADD_TASK = 1;
    public static final int DISPLAY_ALL_TASKS = 2;
    public static final int EXIT = 3;

    public abstract void showActionsInformation();

    public abstract String readUserInput();

    public abstract void executeAction(String command);
}
