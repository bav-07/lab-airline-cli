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
        //PassengerFileWriter.readFile("passengers.txt");

        do {
            int selection = menu.displayMenuOptions();
            if (selection == 1) {
                Flight flight = menu.addFlight();
                FlightFileWriter.makeFile("/Users/bav/Documents/coursework/week_04/day_01/lab-airline-cli/flights.txt",menu,flight);
            }
            else if (selection == 2) {
                menu.displayAllFLights();
            }
            else if (selection == 3) {
                Passenger passenger = menu.addPassenger();
                PassengerFileWriter.makeFile("/Users/bav/Documents/coursework/week_04/day_01/lab-airline-cli/passengers.txt",menu,passenger);
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


        } while (true);
    }

}
