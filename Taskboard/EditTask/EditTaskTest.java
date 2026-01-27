
import java.io.IOException;
import javax.swing.JFrame;

public class EditTaskTest extends JFrame{
    Nanny nanny;
    public static void main(String[] arr) throws IOException{
        EditTaskTest app = new EditTaskTest();
        app.setSize(800,600);
        app.setTitle("Taiga");
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setLocationRelativeTo(null);
        app.setResizable(false);
        app.setVisible(true);
    }

    public EditTaskTest() throws IOException{
        nanny = new Nanny(this);
        Blackboard.addTask("Task1", "Make a GUI");
        Blackboard.addTask("Task2", "Add event listener");
        Blackboard.addTask("Task3", "Load existing data");
        Blackboard.addTask("Task4", "Save new data");
        Blackboard.addTask("Task5", "idk what to do 1");
        Blackboard.addTask("Task6", "idk what to do 2");
        Blackboard.addTask("Task7", "idk what to do 3");
        Blackboard.addTask("Task8", "idk what to do 4");

        
        setContentPane(new TaskListPanel(this, nanny));
        revalidate();
        repaint();
    }

    public void showEdit(int id) {
        Blackboard.setCurTaskID(id);
        setContentPane(new EditPanel(Blackboard.getTasks().get(id), nanny));
        revalidate();
        repaint();
    }
}