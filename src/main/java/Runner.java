import java.util.Scanner;

public class Runner {

    public static void main(String[] args) throws Exception {

        Menu menu = new Menu();

//        menu.addFlight();
//        menu.addFlight();
//        menu.addFlight();
//        menu.displayAllFLights();
////        menu.cancelFLight();
//
//        menu.addPassenger();
////        menu.addPassenger();
////        menu.addPassenger();
//        menu.bookPassengerOnFlight();
        do {
            int selection = menu.displayMenuOptions();
            if (selection == 1) {
                menu.addFlight();
            }
            else if (selection == 2) {
                menu.displayAllFLights();
            }
            else if (selection == 3) {
                menu.addPassenger();
            }
            else if (selection == 4) {
                menu.bookPassengerOnFlight();
            }
            else if (selection == 5) {
                menu.cancelFLight();
            }
            else {
                System.out.println("Please provide a valid key between 1 and 5.");
            }
            System.out.println("");
        } while (true);
    }

}
