import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Menu {

    private ArrayList<Flight> flights;
    private ArrayList<Passenger> passengers;

    public Menu() {
        this.flights = new ArrayList<>();
        this.passengers = new ArrayList<>();
    }

    // METHODS
    public int displayMenuOptions() throws InputMismatchException {
        System.out.println("Welcome to BNTA Airways");
        System.out.println("Please select from one of the following options, using the appropriate key");
        System.out.println("Add a new flight [1]");
        System.out.println("Display all available flights [2]");
        System.out.println("Add a new passenger [3]");
        System.out.println("Book a passenger onto a flight [4]");
        System.out.println("Cancel a flight [5]");
        Scanner scanner = new Scanner(System.in);
        int selection;
        try {
            selection = scanner.nextInt();
        } catch (Exception exception) {
            throw new InputMismatchException("invalid input: please provide a number from 1 to 5.");
        }
        return selection;
    }

    public Flight addFlight(){

        // Prompt user for flight destination
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter destination: ");
        // try
            String destination = scanner.nextLine();
        // } catch ( )

        // Generate unique ID
        Random id = new Random();
        int flightID = id.nextInt(100_000, 1_000_000);
        boolean isUniqueFlightId = false;
        // Use a while loop to ensure a unique random number is generated
        while (isUniqueFlightId == false){
            flightID = id.nextInt(100_000, 1_000_000);
            isUniqueFlightId = checkIfUniqueFlightId(flightID);
        }

        // Use the Flight constructor with the above as arguments
        Flight newFlight = new Flight(destination, flightID);

        // Add flight to arraylist of flights
        flights.add(newFlight);
        
        return newFlight;

        //System.out.println(flights);
        //System.out.println(flights.get(0).getDestination());
        //System.out.println(flights.get(0).getId());
    }

    public void displayAllFLights(){
        for (Flight flight : flights) {
            System.out.println(flight.toString());
        }
    }

    public Passenger addPassenger() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter First name: ");

            String firstName = scanner.nextLine();

        System.out.println("Enter Last name: ");

            String lastName = scanner.nextLine();

        // Generate unique ID
        Random id = new Random();
        int passengerID = id.nextInt(100_000, 1_000_000);
        boolean isUniqueUserId = checkIfUniqueUserId(passengerID);
        // Implements a way of ensuring the generated random number is unique and not shared by any other passengers in the collection
        while (isUniqueUserId == false){
            passengerID = id.nextInt(100_000, 1_000_000);
            isUniqueUserId = checkIfUniqueUserId(passengerID);
        }

        // Use the Passenger constructor with the above as arguments
        Passenger passenger = new Passenger(firstName + " " + lastName, passengerID);

        // Add passenger to arraylist of passengers
        passengers.add(passenger);

        // Print out registration confirmation message along with unique generated ID
        System.out.println("Thank you " + firstName + " " + lastName + ", your registration was successful: your unique passenger ID is " + passengerID + ". Please take note of this number for future reference.");
        // System.out.println(passenger);
        // System.out.println(passengers.get(0).getName());
        // System.out.println(passengers.get(0).getId());
        
        // Write passenger to file
        return passenger;
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

    public void bookPassengerOnFlight() throws Exception {
        
        if (flights.isEmpty()) {
            throw new Exception("No flights today");
        }
        
        // Get input from user on what is their ID
        System.out.println("Enter your unique passenger ID: ");

        // Need to implement a try statement and catch an expression here
        Scanner scanner = new Scanner(System.in);
        int userId = scanner.nextInt();

        // Match the provided ID to a passenger
        // If the user ID is not found, continually prompt the user until a valid ID is provided
        Passenger passenger = this.promptForPassengerId(userId);
        scanner.nextLine();

        // Prompt user for desired destination
        System.out.println("Please enter your desired destination: ");
        String destination = scanner.nextLine();
        try {
            checkForExistingDestinations(destination);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            exception.printStackTrace();
            return;
        }

        // Prompt user for a flight ID
        System.out.println("Please enter the flight ID for your desired flight: ");
        int flightId = scanner.nextInt();

        // Match the flightID to a flight
        int flightIndex = this.promptForFlightId(flightId);

        // Book the passenger onto the flight
        flights.get(flightIndex).addPassenger(passenger);
        //System.out.println(flights.get(flightIndex).getPassengers());
    }

    public Passenger promptForPassengerId(int userId){
        Scanner scanner = new Scanner(System.in);
        boolean userIdRecognised = false;
        while (userIdRecognised == false) {
            for (int i = 0; i < passengers.size(); i++) {
                if (userId == passengers.get(i).getId()) {
                    userIdRecognised = true;
                    System.out.println("Welcome " + passengers.get(i).getName() + ".");
                    return passengers.get(i);
                }
            }
            if (userIdRecognised == false) {
                System.out.println("User ID not recognised, please try again: ");
                userId = scanner.nextInt();
            }
        }
        // probably shouldn't have a return null here
        return null;
    }

    public void checkForExistingDestinations(String destination) throws Exception {
        int numOfFlights = 0;
        for (Flight flight : flights) {
            if (destination.equals(flight.getDestination())) {
                System.out.println(flight.toString());
                numOfFlights++;
            }
        }
        if (numOfFlights == 0){
            throw new Exception("No flights available for selected destination");
        }
    }

    public int promptForFlightId(int flightId) throws Exception {
        boolean flightIdRecognised = false;
        while (flightIdRecognised == false) {
            for (int i = 0; i < flights.size(); i++) {
                if (flightId == flights.get(i).getId()) {
                    flightIdRecognised = true;
                    System.out.println("You have been booked onto flight ID " + flights.get(i).getId() + ", destination " + flights.get(i).getDestination() + ".");
                    return i;
                }
            }
            if (flightIdRecognised == false) {
                System.out.println("Flight ID not recognised, please try again: ");
                Scanner scanner = new Scanner(System.in);
                flightId = scanner.nextInt();
            }
        }
        // not sure if i threw exception correctly here
        throw new Exception("error: no ID found");
    }

    public boolean checkIfUniqueUserId(int passengerId){

        for (Passenger passenger : passengers) {
            if (passengerId == passenger.getId()) {
                return false;
            }
        }
        return true;
    }

    public boolean checkIfUniqueFlightId(int flightId){

        for (Flight flight : flights) {
            if (flightId == flight.getId()) {
                return false;
            }
        }
        return true;
    }

    // GETTERS & SETTERS
    public ArrayList<Flight> getFlights() {
        return flights;
    }

    public void setFlights(ArrayList<Flight> flights) {
        this.flights = flights;
    }

    public ArrayList<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(ArrayList<Passenger> passengers) {
        this.passengers = passengers;
    }
}
