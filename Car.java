import java.util.ArrayList;
import java.util.Arrays;

public class Car {
    /**
     * Attributes
     */
    public ArrayList<Passenger> passengersOnBoard;
    private int maxCapacity;


    /**
     * Constructor
     * @param passengersOnBoard List of initial passengers
     * @param maxCapacity Maximum capacity of the car
     */
    public Car(ArrayList<Passenger> passengersOnBoard, int maxCapacity) {
        this.passengersOnBoard = new ArrayList<>(passengersOnBoard); // Fix the initialization
        this.maxCapacity = maxCapacity;
    }

    /**
     * Accessor for max capacity
     * @return max capacity of the car
     */
    public int getCapacity() {
        return this.maxCapacity;
    }

    /**
     * Get remaining seats
     * @return number of available seats
     */
    public int seatsRemaining() {
        return this.maxCapacity - this.passengersOnBoard.size();
    }

    /**
     * Add a passenger
     * @param p The passenger object
     * @return true if successfully added, throws exception if full
     */
    public boolean addPassenger(Passenger p){
        if (this.passengersOnBoard.size() < this.maxCapacity) {
            this.passengersOnBoard.add(p);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Remove a passenger
     * @param p The passenger object
     * @return true if successfully removed, throws exception if not found
     */
    public boolean removePassenger(Passenger p){
        if (this.passengersOnBoard.contains(p)) {
            this.passengersOnBoard.remove(p);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Print the names of all passengers
     */
    public void printManifest() {
        if (this.passengersOnBoard.isEmpty()) {
            System.out.println("This car is empty.");
            return;
        }
        int i = 1;
        for (Passenger p : this.passengersOnBoard) {
            System.out.println("Passenger " + i + ": " + p.name);
            i++;
        }
    }

    /**
     * Main method for testing
     */
    public static void main(String[] args) {
        Passenger ada = new Passenger("Ada");
        Passenger bob = new Passenger("Bob");
        Passenger carmen = new Passenger("Carmen");

        // Create a car object
        ArrayList<Passenger> passengersA = new ArrayList<>(Arrays.asList(ada, bob, carmen));
        Car a = new Car(passengersA, 3);

        // Test getCapacity()
        System.out.println("Car a, max capacity: " + a.getCapacity());

        // Test seatsRemaining()
        System.out.println("Car a, seats remaining: " + a.seatsRemaining());

        // Test addPassenger()
        Passenger dan = new Passenger("Dan");
        try {
            a.addPassenger(dan);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: car is full.");
        }

        // Test removePassenger()
        try {
            a.removePassenger(bob);
        } catch (NullPointerException e) {
            System.out.println("Error: passenger not on board.");
        }

        // Test printManifest()
        a.printManifest();
    }
}