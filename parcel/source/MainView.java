import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class MainView extends JFrame {
    private JTable customerTable;
    private JTable parcelTable;
    private DefaultTableModel customerTableModel;
    private DefaultTableModel parcelTableModel;
    private JTextArea parcelListArea;
    private JTextArea processingArea;
    private JButton processButton;
    private JButton addCustomerButton;
    private JButton addParcelButton;
    private JButton viewLogsButton;

    public MainView() {
        setTitle("Parcel Processing System");
        setSize(900, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout()); 
        getContentPane().setBackground(new Color(245, 245, 245)); 

        JPanel sidebar = new JPanel();
        sidebar.setLayout(new BoxLayout(sidebar, BoxLayout.Y_AXIS)); 
        sidebar.setBackground(new Color(54, 57, 63)); 
        sidebar.setPreferredSize(new Dimension(200, getHeight())); 

        processButton = createStyledButton("Process");
        addCustomerButton = createStyledButton("Add Customer");
        addParcelButton = createStyledButton("Add Parcel");
        viewLogsButton = createStyledButton("View Logs");

        sidebar.add(processButton);
        sidebar.add(Box.createVerticalStrut(15)); 
        sidebar.add(addCustomerButton);
        sidebar.add(Box.createVerticalStrut(15)); 
        sidebar.add(addParcelButton);
        sidebar.add(Box.createVerticalStrut(15)); 
        sidebar.add(viewLogsButton);

        add(sidebar, BorderLayout.WEST);

        JPanel mainContent = new JPanel(new BorderLayout());
        mainContent.setBackground(Color.WHITE);
        mainContent.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        String[] columnNames = {"ID", "Name", "Email"}; 
        customerTableModel = new DefaultTableModel(columnNames, 0); 
        customerTable = new JTable(customerTableModel);
        JScrollPane customerScrollPane = new JScrollPane(customerTable);

        String[] parcelColumnNames = {"ID", "Weight", "Destination", "Customer ID"}; 
        parcelTableModel = new DefaultTableModel(parcelColumnNames, 0); 
        parcelTable = new JTable(parcelTableModel); 
        JScrollPane parcelScrollPane = new JScrollPane(parcelTable);

        JPanel topPanel = new JPanel(new GridLayout(1, 2, 10, 10)); 
        topPanel.add(customerScrollPane);
        topPanel.add(parcelScrollPane);
        mainContent.add(topPanel, BorderLayout.CENTER);

        processingArea = createStyledTextArea("Processing Area:\n");
        mainContent.add(new JScrollPane(processingArea), BorderLayout.SOUTH);

        add(mainContent, BorderLayout.CENTER);

        setVisible(true);
    }

    private JButton createStyledButton(String text) {
        JButton button = new JButton(text);
        button.setFocusPainted(false);
        button.setBackground(new Color(89, 101, 114)); 
        button.setForeground(Color.WHITE); 
        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20)); 
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.setAlignmentX(Component.CENTER_ALIGNMENT); 
        return button;
    }

    private JTextArea createStyledTextArea(String text) {
        JTextArea textArea = new JTextArea(text);
        textArea.setEditable(false);
        textArea.setFont(new Font("Consolas", Font.PLAIN, 14));
        textArea.setBackground(new Color(245, 245, 245)); 
        textArea.setForeground(new Color(50, 50, 50)); 
        textArea.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200)));
        return textArea;
    }

    public void updateCustomerTable(Object[][] customerData) {
        customerTableModel.setRowCount(0); 
        for (Object[] row : customerData) {
            customerTableModel.addRow(row); 
        }
    }

    // Update the Parcel List Area
    public void updateParcelTable(Object[][] parcelData) {
        parcelTableModel.setRowCount(0); 
        for (Object[] row : parcelData) {
            parcelTableModel.addRow(row); 
        }
    }

    public void updateProcessingArea(String text) {
        processingArea.setText("Processing Area:\n" + text);
    }

    public JButton getProcessButton() {
        return processButton;
    }

    public JButton getAddCustomerButton() {
        return addCustomerButton;
    }

    public JButton getAddParcelButton() {
        return addParcelButton;
    }

    public JButton getViewLogsButton() {
        return viewLogsButton;
    }
}
