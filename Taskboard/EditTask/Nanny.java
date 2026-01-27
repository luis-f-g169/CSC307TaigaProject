
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Nanny {
    private final EditTaskTest main;
    public Nanny(EditTaskTest main){
        this.main = main;
    }

    public void SaveButton(JTextField subject, JTextArea body){
        Officer.editTask(subject.getText(), body.getText()); 
        main.setContentPane(new TaskListPanel(main, this));
        main.revalidate();
        main.repaint();
        saveData();
    }

    public void saveData(){
        ArrayList<String> lines = new ArrayList<>();
        for(Task t : Officer.getTasks()){
            lines.add(t.toString());
        }
        try {
            Files.write(Path.of("Taskboard/EditTask/tasks.txt"), lines);
        } catch (IOException ex) {
            System.getLogger(EditTaskTest.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }

    public void EditButton(ActionEvent e){
        int id = Integer.parseInt(e.getActionCommand());
        main.showEdit(id); 
    }

    


}