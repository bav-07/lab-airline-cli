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
                throw new Exception("Please provide a valid key between 1 and 5.");
            }
            if (selection == 0){

            }
            System.out.println("");
            AirlinesFileWriter.makeFile("/Users/bav/Documents/coursework/week_04/day_01/lab-airline-cli/temp.txt",menu);
        } while (true);
    }

}
