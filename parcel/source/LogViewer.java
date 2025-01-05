import javax.swing.*;
import java.awt.*;

public class LogViewer extends JDialog {
    public LogViewer(JFrame parent, Log log) {
        super(parent, "Log Viewer", true);
        setSize(500, 400);
        setLayout(new BorderLayout(10, 10));
        getContentPane().setBackground(new Color(245, 245, 245));

        JLabel headerLabel = new JLabel("Application Logs");
        headerLabel.setFont(new Font("Arial", Font.BOLD, 16));
        headerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        headerLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        add(headerLabel, BorderLayout.NORTH);

        JTextArea logArea = new JTextArea();
        logArea.setText(log.getLogData());
        logArea.setEditable(false);
        logArea.setFont(new Font("Consolas", Font.PLAIN, 14));
        logArea.setBackground(new Color(240, 240, 240));
        logArea.setForeground(new Color(50, 50, 50));
        logArea.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200)));

        JScrollPane scrollPane = new JScrollPane(logArea);
        scrollPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        add(scrollPane, BorderLayout.CENTER);

        JButton closeButton = new JButton("Close");
        closeButton.setFont(new Font("Arial", Font.BOLD, 14));
        closeButton.setBackground(new Color(76, 175, 80));
        closeButton.setForeground(Color.WHITE);
        closeButton.setFocusPainted(false);
        closeButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        closeButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        closeButton.addActionListener(e -> dispose());
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(new Color(245, 245, 245));
        buttonPanel.add(closeButton);
        add(buttonPanel, BorderLayout.SOUTH);

        setLocationRelativeTo(parent);
        setVisible(true);
    }
}
