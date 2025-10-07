package Accenture;

import java.util.*;

// Interface already provided in your code
interface IShipmentSorter {
    List<Shipment> sortShipments(List<Shipment> shipments);
}

// Shipment class implementation
class Shipment {
    String id;
    String city;
    int daysLeft;

    // Constructor
    public Shipment(String id, String city, int daysLeft) {
        this.id = id;
        this.city = city;
        this.daysLeft = daysLeft;
    }

    // toString method for printing output
    @Override
    public String toString() {
        return id + " " + city + " " + daysLeft;
    }
}

// ShipmentSorter class implementation
class ShipmentSorter implements IShipmentSorter {

    @Override
    public List<Shipment> sortShipments(List<Shipment> shipments) {
        // Sort by daysLeft ascending, then by city alphabetically
        Collections.sort(shipments, new Comparator<Shipment>() {
            public int compare(Shipment s1, Shipment s2) {
                if (s1.daysLeft != s2.daysLeft) {
                    return Integer.compare(s1.daysLeft, s2.daysLeft);
                } else {
                    return s1.city.compareTo(s2.city);
                }
            }
        });
        return shipments;
    }
}

// Main class handles input/output
public class ShipmentDeliverySorter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        List<Shipment> shipments = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split(" ");
            String id = parts[0];
            String city = parts[1];
            int daysLeft = Integer.parseInt(parts[2]);
            shipments.add(new Shipment(id, city, daysLeft));
        }

        IShipmentSorter sorter = new ShipmentSorter();
        List<Shipment> sorted = sorter.sortShipments(shipments);

        for (Shipment s : sorted) {
            System.out.println(s);
        }
        sc.close();
    }
}

