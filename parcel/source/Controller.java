import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

        view.getViewLogButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new LogViewer(view, Log.getInstance());  
            }
        });
    }

    private void processNextCustomer() {
        String processed = manager.processNextCustomer();
        if (processed != null) {
            view.updateProcessingArea(processed);
            updateView();
        } else {
            view.updateProcessingArea("No customers or parcels to process.");
        }
    }

    private void updateView() {
        view.updateCustomerQueue(manager.getCustomerQueueAsString());
        view.updateParcelList(manager.getParcelListAsString());
    }
}
