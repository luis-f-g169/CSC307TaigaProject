
import java.awt.*;
import javax.swing.*;

public class TaskListPanel extends JPanel{
    
    public TaskListPanel(EditTaskTest main, Nanny nanny) {
        setLayout(new GridLayout(Blackboard.getTasks().size(), 2));

        for (int i = 0; i < Blackboard.getTasks().size(); i++) {
            Task t = Blackboard.getTasks().get(i);

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