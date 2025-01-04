
import java.util.LinkedList;
import java.util.Queue;

public class QueueOfCustomers {
    private Queue<Customer> customerQueue;

    public QueueOfCustomers() {
        customerQueue = new LinkedList<>();
    }

    public void addCustomer(Customer customer) {
        customerQueue.add(customer);
    }

    public Customer removeCustomer() {
        return customerQueue.poll();
    }

    public Customer peekCustomer() {
        return customerQueue.peek();
    }

    public boolean isEmpty() {
        return customerQueue.isEmpty();
    }

    @Override
    public String toString() {
        return "QueueOfCustomers [Queue=" + customerQueue + "]";
    }
}
