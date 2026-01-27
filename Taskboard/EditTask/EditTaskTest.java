
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import javax.swing.JFrame;
import javax.swing.JPanel;

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
        // Officer.addTask("Task1", "Make a GUI");
        // Officer.addTask("Task2", "Add event listener");
        // Officer.addTask("Task3", "Load existing data");
        // Officer.addTask("Task4", "Save new data");
        // Officer.addTask("Task5", "idk what to do 1");
        // Officer.addTask("Task6", "idk what to do 2");
        // Officer.addTask("Task7", "idk what to do 3");
        // Officer.addTask("Task8", "idk what to do 4");
        for (String line : Files.readAllLines(Path.of("Taskboard/EditTask/tasks.txt"))) {
            String[] parts = line.split(":", 3);
            Officer.addTask(parts[1], parts[2]);
        }

        
        setPanel(new TaskListPanel(this, nanny));
        

    }

    private void setPanel(JPanel p) {
        setContentPane(p);
        revalidate();
        repaint();
    }

    public void showEdit(int id) {
        EditPanel edit = new EditPanel(Officer.getTasks().get(id), nanny);
        Officer.setCurTaskID(id);
        setPanel(edit);
    }
}