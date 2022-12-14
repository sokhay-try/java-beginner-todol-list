package App;

import Features.Actions;
import Features.AddTask;
import Features.TaskDisplay;

import java.util.*;

public class TodoList {

    public static Map<String, Task> tasks = new LinkedHashMap<>();
    public static boolean applicationRunning = true;

    public void start() {
        showApplicationTitle();
        while (TodoList.applicationRunning) {
            showAvailableActions();
            int actionNumber = readAction();
            executeAction(actionNumber);
        }
    }

    public void showApplicationTitle() {
        System.out.println("To DO List Application");
        System.out.println("-----------------------");
    }

    public void showAvailableActions() {
        System.out.println("");
        System.out.println("1. Add a task");
        System.out.println("2. Display all tasks");
        System.out.println("3. Exit");
        System.out.println("");
    }

    public int readAction() {
        List<Integer> availableActions = Arrays.asList(1,2,3);

        while (true) {
            try {
                System.out.println("Enter action: ");
                Scanner scan = new Scanner(System.in);
                int action = scan.nextInt();
                if (availableActions.contains(action)) {
                    return action;
                }
                else {
                    System.out.println("Please enter a valid action from the list: ");
                }

            } catch (Exception e) {
                System.out.println("Action must be a number...");
            }
        }
    }

    public void executeAction(int actionNumber) {
        Actions action;
        switch (actionNumber) {
            case Actions.ADD_TASK:
                action = new AddTask();
                action.showActionsInformation();
                String command = action.readUserInput();
                action.executeAction(command);
                break;
            case Actions.DISPLAY_ALL_TASKS:
                action = new TaskDisplay();
                action.showActionsInformation();
                action.executeAction(null);
                break;
            case Actions.EXIT:
                applicationRunning = false;
                System.out.println("Exit Application!");
                break;
        }

    }
}
