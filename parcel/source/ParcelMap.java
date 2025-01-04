import java.util.HashMap;

public class ParcelMap {
    private HashMap<String, Parcel> parcelMap;

    public ParcelMap() {
        parcelMap = new HashMap<>();
    }

    public void addParcel(Parcel parcel) {
        parcelMap.put(parcel.getId(), parcel);
    }

    public Parcel getParcel(String id) {
        return parcelMap.get(id);
    }

    public boolean removeParcel(String id) {
        return parcelMap.remove(id) != null;
    }

    @Override
    public String toString() {
        return "ParcelMap [Parcels=" + parcelMap.values() + "]";
    }
}
