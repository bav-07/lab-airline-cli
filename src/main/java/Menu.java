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
        // Need to implement a way of ensuring the generated random number is unique and not shared by any other passengers in the collection

        // Use the Passenger constructor with the above as arguments
        Passenger passenger = new Passenger(firstName + " " + lastName, passengerID);

        // Add passenger to arraylist of passengers
        passengers.add(passenger);

        // Print out registration confirmation message along with unique generated ID
        System.out.println("Thank you " + firstName + " " + lastName + ", your registration was successful: your unique passenger ID is " + passengerID + ". Please take note of this number for future reference.");
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

    public void bookPassengerOnFlight(){
        // Get input from user on what is their ID
        System.out.println("Enter your unique passenger ID: ");

        // Need to implement a try statement and catch an expression here
        Scanner scanner = new Scanner(System.in);
        int userId = scanner.nextInt();

        // Match the provided ID to a passenger
        // If the user ID is not found, continually prompt the user until a valid ID is provided
        boolean userIdRecognised = false;
        while (userIdRecognised == false) {
            for (int i = 0; i < passengers.size(); i++) {
                if (userId == passengers.get(i).getId()) {
                    userIdRecognised = true;
                    System.out.println("Welcome " + passengers.get(i).getName() + ". Please provide the flight ID for your desired flight: ");
                    break;
                }
            }
            if (userIdRecognised == false) {
                System.out.println("User ID not recognised, please try again: ");
                userId = scanner.nextInt();
            }
        }

        // Prompt user for a flight ID
        int flightId = scanner.nextInt();

        // Match the flightID to a flight
        boolean flightIdRecognised = false;
        while (flightIdRecognised == false) {
            for (int i = 0; i < flights.size(); i++) {
                if (flightId == flights.get(i).getId()) {
                    flightIdRecognised = true;
                    System.out.println("You have been booked onto flight ID " + flights.get(i).getId() + ", destination " + flights.get(i).getDestination());
                    break;
                }
            }
            if (flightIdRecognised == false) {
                System.out.println("Flight ID not recognised, please try again: ");
                flightId = scanner.nextInt();
            }
        }


    }
}
