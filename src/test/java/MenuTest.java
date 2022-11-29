//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Disabled;
//import org.junit.jupiter.api.Test;
//
//import java.io.ByteArrayInputStream;
//import java.io.InputStream;
//import java.util.ArrayList;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//public class MenuTest {
//
//    private Menu menu = new Menu();
//    private ArrayList<Flight> flights = new ArrayList<>();
//    private ArrayList<Passenger> passengers = new ArrayList<>();
//
//    @BeforeEach
//    public void setUp() {
//
//        Flight flightLondon = new Flight("London", 123456);
//        Flight flightToronto = new Flight("Toronto", 234567);
//        flights.add(flightLondon);
//        flights.add(flightToronto);
//        menu.setFlights(flights);
//
//        Passenger passengerBav = new Passenger("Bav Nagarajah", 102345);
//        Passenger passengerSara = new Passenger("Sara Ahmed", 204356);
//        passengers.add(passengerSara);
//        passengers.add(passengerBav);
//        menu.setPassengers(passengers);
//
//
//    }
//
//    @Test
//    @Disabled
//    public void canAddFlight() {
//
//        InputOutput inputOutput = new InputOutput();
//        menu.addFlight();
//        String inputDestination = "Cairo";
//        InputStream in = new ByteArrayInputStream(inputDestination.getBytes());
//        System.setIn(in);
//        assertEquals(inputDestination, menu.getFlights().get(2).getDestination());
//
////        menu.addFlight();
////        String actual = menu.getFlights().get(2).getDestination();
////        String expected =
////        assertEquals(expected, actual);
//    }
//}
