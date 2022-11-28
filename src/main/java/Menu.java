import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Menu {

    private ArrayList<Flight> flights;
    private ArrayList<Passenger> passengers;

    public Menu() {
        this.flights = new ArrayList<>();
        this.passengers = new ArrayList<>();
    }

    public void addFlight(){

        // Prompt user for flight destination
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter destination: ");
        // try
            String destination = scanner.nextLine();
        // } catch ( )

        // Generate unique ID
        Random id = new Random();
        int flightID = id.nextInt(100_000, 1_000_000);

        // Use the Flight constructor with the above as arguments
        Flight newFlight = new Flight(destination, flightID);

        // Add flight to arraylist of flights
        flights.add(newFlight);

        //System.out.println(flights);
        //System.out.println(flights.get(0).getDestination());
        //System.out.println(flights.get(0).getId());


    }

    public void displayAllFLights(){
        for (Flight flight : flights) {
            System.out.println(flight.toString());
        }
    }

    public void addPassenger() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter First name: ");

            String firstName = scanner.nextLine();

        System.out.println("Enter Last name: ");

            String lastName = scanner.nextLine();



        // Generate unique ID
        Random id = new Random();
        int passengerID = id.nextInt(100_000, 1_000_000);

        // Use the Flight constructor with the above as arguments
        Passenger passenger = new Passenger(firstName + " " + lastName, passengerID);

        // Add flight to arraylist of flights
        passengers.add(passenger);

        // System.out.println(passenger);
        // System.out.println(passengers.get(0).getName());
        // System.out.println(passengers.get(0).getId());
    }

    public void cancelFLight(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Flight ID you wish to cancel: ");

        int inputFlightId = scanner.nextInt();
        
        for (int i = 0; i < flights.size() ; i++) {
            if (inputFlightId == flights.get(i).getId()) {
                flights.remove(i);
                break;
            }

        }
        
        

        System.out.println(flights);
    }
}
