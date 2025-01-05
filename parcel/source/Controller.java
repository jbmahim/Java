import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class Controller {
    private MainView view;
    private Manager manager;

    public Controller(MainView view, Manager manager) {
        this.view = view;
        this.manager = manager;

        view.getProcessButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            processNextCustomer();
            }
        });

        view.getAddCustomerButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddCustomerDialog(view, manager);  
                updateView();  
            }
        });

        view.getAddParcelButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddParcelDialog(view, manager);  
                updateView();  
            }
        });

        view.getViewLogsButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new LogViewer(view, Log.getInstance());  
            }
        });
    }

private void processNextCustomer() {
    manager.processNextCustomer(); // Process the next customer

    if (manager.currentlyProcessing != null) {
        List<Parcel> parcels = manager.getParcelsForCustomer(manager.currentlyProcessing.getId());
        Object[][] parcelData = new Object[parcels.size()][4];
        for (int i = 0; i < parcels.size(); i++) {
            Parcel p = parcels.get(i);
            parcelData[i][0] = p.getId();
            parcelData[i][1] = p.getWeight();
            parcelData[i][2] = p.getDestination();
            parcelData[i][3] = p.getCustomerId();
        }
        view.updateParcelTable(parcelData); 
    } else {
        view.updateParcelTable(new Object[0][0]); 
    }

    updateView();
}



    private void updateView() {
        Object[][] customerData = manager.getCustomerDataForTable();
        view.updateCustomerTable(customerData);

        // view.updateParcelList(manager.getParcelListAsString());
        Object[][] parcelData = manager.getParcelDataForTable();
        view.updateParcelTable(parcelData);
        view.updateProcessingArea(manager.getProcessingInfo());
    }
}
