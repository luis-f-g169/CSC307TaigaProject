
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Nanny {
    private final EditTaskTest main;
    public Nanny(EditTaskTest main){
        this.main = main;
    }

    public void SaveButton(JTextField subject, JTextArea body){
        Blackboard.editTask(subject.getText(), body.getText()); 
        main.setContentPane(new TaskListPanel(main, this));
        main.revalidate();
        main.repaint();
    }


    public void EditButton(ActionEvent e){
        int id = Integer.parseInt(e.getActionCommand());
        main.showEdit(id); 
    }

    


}