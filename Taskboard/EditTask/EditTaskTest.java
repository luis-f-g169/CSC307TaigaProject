
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class EditTaskTest extends JFrame{
    public static void main(String[] arr) throws IOException{
        EditTaskTest app = new EditTaskTest();
        app.setSize(800,600);
        app.setTitle("Taiga");
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setResizable(false);
        app.setVisible(true);

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            List<String> lines = new ArrayList();
            for(Task t : Officer.getTasks()){
                lines.add(t.toString());
            }
            try {
                Files.write(Path.of("Taskboard/EditTask/tasks.txt"), lines);
            } catch (IOException ex) {
                System.getLogger(EditTaskTest.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            }
        }));

    }

    public EditTaskTest() throws IOException{
        // Officer.addTask("Task1", "Make a GUI");
        // Officer.addTask("Task2", "Add event listener");
        // Officer.addTask("Task3", "Load existing data");
        // Officer.addTask("Task4", "Save new data");
        // Officer.addTask("Task5", "idk what to do 1");
        // Officer.addTask("Task6", "idk what to do 2");
        // Officer.addTask("Task7", "idk what to do 3");
        // Officer.addTask("Task8", "idk what to do 4");
        for (String line : Files.readAllLines(Path.of("Taskboard/EditTask/tasks.txt"))) {
            String[] parts = line.split("\t", 2);
            Officer.addTask(parts[0], parts[1]);
        }

        
        setPanel(new TaskListPanel(this));
        

    }

    private void setPanel(JPanel p) {
        if (Officer.getCurPanel() != null) remove(Officer.getCurPanel());
        Officer.setCurPanel(p);
        add(Officer.getCurPanel());
        revalidate();
        repaint();
    }

    public void showEdit(int id) {
        EditPanel edit = new EditPanel(Officer.getTasks().get(id));
        Officer.setCurID(id);
        edit.addRemoveListener(e -> setPanel(new TaskListPanel(this)));

        setPanel(edit);
    }
}