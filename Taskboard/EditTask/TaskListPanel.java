
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class TaskListPanel extends JPanel implements ActionListener{
    private final EditTaskTest main;
    public TaskListPanel(EditTaskTest main) {
        this.main = main;
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        for (int i = 0; i < Officer.getTasks().size(); i++) {
            Task t = Officer.getTasks().get(i);
            JPanel curTask = new JPanel(new BorderLayout(5, 5));

            JTextField taskText = new JTextField(t.getSubject() + ": " + t.getBody());
            taskText.setEditable(false);

            JButton edit = new JButton("Edit");
            edit.setActionCommand(String.valueOf(i)); 
            edit.addActionListener(this);

            curTask.add(taskText, BorderLayout.CENTER);
            curTask.add(edit, BorderLayout.EAST);

            add(curTask);
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        int id = Integer.parseInt(e.getActionCommand());
        main.showEdit(id); 
    }

}