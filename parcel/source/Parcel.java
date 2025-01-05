public class Parcel {
    private String id;
    private double weight;
    private String destination;
    private String customerId; 

    public Parcel(String id, double weight, String destination, String customerId) {
        this.id = id;
        this.weight = weight;
        this.destination = destination;
        this.customerId = customerId;
    }

    public String getId() {
        return id;
    }

    public double getWeight() {
        return weight;
    }

    public String getDestination() {
        return destination;
    }

    public String getCustomerId() {
        return customerId;
    }
    public double calculateFee() {
        double baseFee = 50; 
        double weightFee = this.weight * 10; 
        double destinationFee = this.destination.equalsIgnoreCase("international") ? 100 : 20;

        return baseFee + weightFee + destinationFee;
    }
    @Override
    public String toString() {
        return "Parcel [ID=" + id + ", Weight=" + weight + ", Destination=" + destination + ", Customer ID=" + customerId + "]";
    }

}
