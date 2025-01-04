import javax.swing.*;

public class LogViewer extends JDialog {
    public LogViewer(JFrame parent, Log log) {
        super(parent, "Log Viewer", true);
        setSize(400, 300);

        JTextArea logArea = new JTextArea();
        logArea.setText(log.getLogData());
        logArea.setEditable(false);
        add(new JScrollPane(logArea));

        setLocationRelativeTo(parent);
        setVisible(true);
    }
}
