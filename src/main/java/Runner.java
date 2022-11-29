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
            if (selection == 2) {
                menu.displayAllFLights();
            }
            if (selection == 3) {
                menu.addPassenger();
            }
            if (selection == 4) {
                menu.bookPassengerOnFlight();
            }
            if (selection == 5) {
                menu.cancelFLight();
            }
            System.out.println("");
        } while (true);
    }

}
