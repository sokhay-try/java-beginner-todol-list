package Features;

import App.Task;
import App.TodoList;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;


public class AddTask extends Actions {
    @Override
    public void showActionsInformation() {
        System.out.println("");
        System.out.println("To add a new task, please follow the instructions and press ENTER:");
        System.out.println("App.Task ID, App.Task Title, Due Date (format: dd-mm-yyyy), App.Task Status, Project Name");
        System.out.println("");
        System.out.println("Enter 0 to RETURN");
    }

    @Override
    public String readUserInput() {
        while (true) {
            System.out.println("");
            System.out.print("Enter Information: ");
            Scanner in = new Scanner(System.in);
            String userInput = in.nextLine();

            return userInput;
        }
    }

    @Override
    public void executeAction(String command) {
        String[] parts = command.split(",");
        DateFormat formatter = new SimpleDateFormat("dd-mm-yyyy");
        try {
            Date d = formatter.parse(parts[2]);
            Task task = Task.buildTask(parts[0], parts[1], d , parts[3], parts[4]);
            TodoList.tasks.put(task.getId(), task);
            System.out.println("Task successfully added!");
        } catch (ParseException e) {
            System.out.println(e);
        }

    }
}
