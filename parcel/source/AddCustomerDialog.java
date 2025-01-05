import javax.swing.*;
import java.awt.*;

public class AddCustomerDialog extends JDialog {
    private JTextField idField, nameField, emailField;
    private JButton addButton, cancelButton;

    public AddCustomerDialog(JFrame parent, Manager manager) {
        super(parent, "Add Customer", true);
        setSize(450, 250);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        getContentPane().setBackground(new Color(245, 245, 245));

        gbc.gridx = 0;
        gbc.gridy = 0;
        addStyledLabel("Customer ID:", gbc);
        gbc.gridx = 1;
        idField = new JTextField();
        addStyledTextField(idField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        addStyledLabel("Name:", gbc);
        gbc.gridx = 1;
        nameField = new JTextField();
        addStyledTextField(nameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        addStyledLabel("Email:", gbc);
        gbc.gridx = 1;
        emailField = new JTextField();
        addStyledTextField(emailField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
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
            String id = idField.getText();
            String name = nameField.getText();
            String email = emailField.getText();

            if (id.isEmpty() || name.isEmpty() || email.isEmpty()) {
                JOptionPane.showMessageDialog(this, "All fields are required!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            manager.addCustomer(new Customer(id, name, email));
            Log.getInstance().addLog("Customer added: " + name + " (ID: " + id + ")");
            JOptionPane.showMessageDialog(this, "Customer added successfully!");
            dispose();
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
