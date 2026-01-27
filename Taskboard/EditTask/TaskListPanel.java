
import java.awt.*;
import javax.swing.*;

public class TaskListPanel extends JPanel{
    private final EditTaskTest main;
    
    public TaskListPanel(EditTaskTest main, Nanny nanny) {
        this.main = main;
        setLayout(new GridLayout(Officer.getTasks().size(), 2));

        for (int i = 0; i < Officer.getTasks().size(); i++) {
            Task t = Officer.getTasks().get(i);

            JTextField taskText = new JTextField(t.getSubject() + ": " + t.getBody());
            taskText.setEditable(false);

            JButton edit = new JButton("Edit");
            edit.setActionCommand(String.valueOf(i)); 
            edit.addActionListener(e -> nanny.EditButton(e));

            add(taskText, BorderLayout.CENTER);
            add(edit, BorderLayout.EAST);
            
        }
    }

}