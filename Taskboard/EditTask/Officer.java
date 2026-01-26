import java.util.*;
import javax.swing.JPanel;

public class Officer{
    public static ArrayList<Task> tasks = new ArrayList<>();
    public static int curID = 0;
    public static JPanel curPanel;

    public static ArrayList<Task> getTasks() {
        return tasks;
    }

    public static void addTask(String subject, String body) {
        Officer.tasks.add(new Task(subject, body, tasks.size()));
    }
    public static void editTask(String subject, String body) {
        Officer.tasks.get(getCurID()).setSubject(subject);
        Officer.tasks.get(getCurID()).setBody(body);
        for(Task t : tasks){
            System.out.println(t);
        }
    }


    


    public static int getCurID() {
        return curID;
    }

    public static void setCurID(int curID) {
        Officer.curID = curID;
    }

    public static JPanel getCurPanel() {
        return curPanel;
    }

    public static void setCurPanel(JPanel curPanel) {
        Officer.curPanel = curPanel;
    }

}