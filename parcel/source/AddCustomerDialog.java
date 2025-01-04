import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddCustomerDialog extends JDialog {
    private JTextField idField, nameField, emailField;
    private JButton addButton, cancelButton;

    public AddCustomerDialog(JFrame parent, Manager manager) {
        super(parent, "Add Customer", true);
        setSize(300, 200);
        setLayout(new GridLayout(4, 2));

        add(new JLabel("Customer ID:"));
        idField = new JTextField();
        add(idField);

        add(new JLabel("Name:"));
        nameField = new JTextField();
        add(nameField);

        add(new JLabel("Email:"));
        emailField = new JTextField();
        add(emailField);

        addButton = new JButton("Add");
        cancelButton = new JButton("Cancel");

        add(addButton);
        add(cancelButton);

        addButton.addActionListener(e -> {
            String id = idField.getText();
            String name = nameField.getText();
            String email = emailField.getText();

            manager.addCustomer(new Customer(id, name, email));
            JOptionPane.showMessageDialog(this, "Customer added successfully!");
            dispose();
        });

        cancelButton.addActionListener(e -> dispose());
        setLocationRelativeTo(parent);
        setVisible(true);
    }
}
