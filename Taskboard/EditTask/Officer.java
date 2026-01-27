import java.util.*;
import javax.swing.JPanel;

public class Officer{
    public static ArrayList<Task> tasks = new ArrayList<>();
    public static int curEditTaskID = 0;
    public static JPanel curPanel;

    public static ArrayList<Task> getTasks() {
        return tasks;
    }

    public static void addTask(String subject, String body) {
        Officer.tasks.add(new Task(subject, body, tasks.size()));
    }
    public static void editTask(String subject, String body) {
        Officer.tasks.get(getCurTaskID()).setSubject(subject);
        Officer.tasks.get(getCurTaskID()).setBody(body);
        for(Task t : tasks){
            System.out.println(t);
        }
    }

    public static int getCurTaskID() {
        return curEditTaskID;
    }

    public static void setCurTaskID(int curID) {
        Officer.curEditTaskID = curID;
    }

}