import javax.swing.*;
import java.awt.*;

public class AddParcelDialog extends JDialog {
    private JTextField idField, weightField, destinationField, customerIdField;
    private JButton addButton, cancelButton;

    public AddParcelDialog(JFrame parent, Manager manager) {
        super(parent, "Add Parcel", true);
        setSize(450, 300);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        getContentPane().setBackground(new Color(245, 245, 245));

        gbc.gridx = 0;
        gbc.gridy = 0;
        addStyledLabel("Parcel ID:", gbc);
        gbc.gridx = 1;
        idField = new JTextField();
        addStyledTextField(idField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        addStyledLabel("Weight:", gbc);
        gbc.gridx = 1;
        weightField = new JTextField();
        addStyledTextField(weightField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        addStyledLabel("Destination:", gbc);
        gbc.gridx = 1;
        destinationField = new JTextField();
        addStyledTextField(destinationField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        addStyledLabel("Customer ID:", gbc);
        gbc.gridx = 1;
        customerIdField = new JTextField();
        addStyledTextField(customerIdField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(new Color(245, 245, 245));

        addButton = createStyledButton("Add", new Color(76, 175, 80));
        cancelButton = createStyledButton("Cancel", new Color(244, 67, 54));

        buttonPanel.add(addButton);
        buttonPanel.add(cancelButton);
        add(buttonPanel, gbc);

        addButton.addActionListener(e -> {
            try {
                String id = idField.getText();
                double weight = Double.parseDouble(weightField.getText());
                String destination = destinationField.getText();
                String customerId = customerIdField.getText();

                if (id.isEmpty() || destination.isEmpty() || customerId.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "All fields are required!", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                manager.addParcel(new Parcel(id, weight, destination, customerId));
                Log.getInstance().addLog("Parcel added: " + id + " for Customer ID: " + customerId);
                JOptionPane.showMessageDialog(this, "Parcel added successfully!");
                dispose();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid weight value!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        cancelButton.addActionListener(e -> dispose());

        setLocationRelativeTo(parent);
        setVisible(true);
    }

    private void addStyledLabel(String text, GridBagConstraints gbc) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("Arial", Font.BOLD, 14));
        label.setForeground(new Color(50, 50, 50));
        add(label, gbc);
    }

    private void addStyledTextField(JTextField textField, GridBagConstraints gbc) {
        textField.setFont(new Font("Arial", Font.PLAIN, 14));
        textField.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200)));
        add(textField, gbc);
    }

    private JButton createStyledButton(String text, Color backgroundColor) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.setFocusPainted(false);
        button.setBackground(backgroundColor);
        button.setForeground(Color.WHITE);
        button.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        return button;
    }
}
