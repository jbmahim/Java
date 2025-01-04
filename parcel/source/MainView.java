import javax.swing.*;
import java.awt.*;

public class MainView extends JFrame {
    private JTextArea customerQueueArea;
    private JTextArea parcelListArea;
    private JTextArea processingArea;
    private JButton processButton;
    private JButton addCustomerButton;
    private JButton addParcelButton;
    private JButton viewLogButton;

    public MainView() {
        setTitle("Parcel Processing System");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel topPanel = new JPanel(new GridLayout(1, 2));
        customerQueueArea = new JTextArea("Customer Queue:\n");
        parcelListArea = new JTextArea("Parcel List:\n");
        topPanel.add(new JScrollPane(customerQueueArea));
        topPanel.add(new JScrollPane(parcelListArea));
        add(topPanel, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel(new GridLayout(2, 1));
        processingArea = new JTextArea("Processing Area:\n");
        processingArea.setEditable(false);
        bottomPanel.add(new JScrollPane(processingArea));

        JPanel buttonPanel = new JPanel(new FlowLayout());
        processButton = new JButton("Process Next Customer");
        addCustomerButton = new JButton("Add Customer");
        addParcelButton = new JButton("Add Parcel");
        viewLogButton = new JButton("View Logs");
        buttonPanel.add(processButton);
        buttonPanel.add(addCustomerButton);
        buttonPanel.add(addParcelButton);
        buttonPanel.add(viewLogButton);
        bottomPanel.add(buttonPanel);

        add(bottomPanel, BorderLayout.SOUTH);
        setVisible(true);
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

    public JButton getViewLogButton() {
        return viewLogButton;
    }

    public void updateCustomerQueue(String text) {
        customerQueueArea.setText("Customer Queue:\n" + text);
    }

    public void updateParcelList(String text) {
        parcelListArea.setText("Parcel List:\n" + text);
    }

    public void updateProcessingArea(String text) {
        processingArea.setText("Processing Area:\n" + text);
    }
}
