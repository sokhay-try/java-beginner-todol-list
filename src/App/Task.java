package App;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeParseException;
import java.util.Date;

public class Task {
    private String id;
    private String title;
    private Date dueDate;
    private String status;
    private String projectName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public static Task buildTask(String id, String title, Date dueDate, String status, String projectName) {
        Task task = new Task();

        task.setId(id);
        task.setTitle(title);
        task.setDueDate(dueDate);
        task.setStatus(status);
        task.setProjectName(projectName);

        return task;
    }

    @Override
    public String toString() {
        return id + "," + title + "," + convertDateToString(dueDate, "dd-MM-yyyy") + "," + status + "," + projectName;
    }

    public static String convertDateToString(Date d, String format) {
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        String result = null;
        try {
            result = formatter.format(d);

        } catch (DateTimeParseException e) {
            System.out.println(e);
        }
        return result;
    }
}
