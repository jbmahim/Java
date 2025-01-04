import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddParcelDialog extends JDialog {
    private JTextField idField, weightField, destinationField;
    private JButton addButton, cancelButton;

    public AddParcelDialog(JFrame parent, Manager manager) {
        super(parent, "Add Parcel", true);
        setSize(300, 200);
        setLayout(new GridLayout(4, 2));

        add(new JLabel("Parcel ID:"));
        idField = new JTextField();
        add(idField);

        add(new JLabel("Weight:"));
        weightField = new JTextField();
        add(weightField);

        add(new JLabel("Destination:"));
        destinationField = new JTextField();
        add(destinationField);

        addButton = new JButton("Add");
        cancelButton = new JButton("Cancel");

        add(addButton);
        add(cancelButton);

        addButton.addActionListener(e -> {
            String id = idField.getText();
            double weight = Double.parseDouble(weightField.getText());
            String destination = destinationField.getText();

            manager.addParcel(new Parcel(id, weight, destination));
            JOptionPane.showMessageDialog(this, "Parcel added successfully!");
            dispose();
        });

        cancelButton.addActionListener(e -> dispose());
        setLocationRelativeTo(parent);
        setVisible(true);
    }
}
