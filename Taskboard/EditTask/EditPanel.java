
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class EditPanel extends JPanel{
    private JTextField subject;
    private JTextArea body;
    private JButton saveButton = new JButton("SAVE");

    public EditPanel(Task task){
        String subjectText = task.getSubject();
        String bodyText = task.getBody();
        setBackground(Color.WHITE);
        setLayout(new BorderLayout(10, 10));
        setBorder(new EmptyBorder(15, 15, 15, 15));

        JLabel title = new JLabel("Edit Task", SwingConstants.CENTER);
        title.setFont(title.getFont().deriveFont(Font.BOLD, 28f));

        JPanel center = new JPanel();

        subject = new JTextField(subjectText);
        subject.setPreferredSize(new Dimension(0, 20));
        subject.setBorder(new LineBorder(Color.blue));

        body = new JTextArea(bodyText);
        body.setLineWrap(true);
        body.setPreferredSize(new Dimension(0, 100));
        body.setBorder(new LineBorder(Color.blue));

        center.setLayout(new BorderLayout(10, 10));
        center.setBorder(new EmptyBorder(50, 50, 50, 50));
        center.add(subject, BorderLayout.NORTH);
        center.add(body, BorderLayout.CENTER);

        add(title, BorderLayout.NORTH);
        add(center, BorderLayout.CENTER);
        add(saveButton, BorderLayout.SOUTH);
    }



    public void addRemoveListener(ActionListener listener){
        saveButton.addActionListener(e -> {
            Officer.editTask(subject.getText(), body.getText()); 
            listener.actionPerformed(e);
            saveData();
        });
    }

    public void saveData(){
        List<String> lines = new ArrayList();
        for(Task t : Officer.getTasks()){
            lines.add(t.toString());
        }
        try {
            Files.write(Path.of("Taskboard/EditTask/tasks.txt"), lines);
        } catch (IOException ex) {
            System.getLogger(EditTaskTest.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }

    
}