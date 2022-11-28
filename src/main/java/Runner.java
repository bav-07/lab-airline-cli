public class Runner {

    public static void main(String[] args) throws Exception {

        Menu menu = new Menu();

        menu.addFlight();
//        menu.addFlight();
//        menu.addFlight();
        menu.displayAllFLights();
//        menu.cancelFLight();

        menu.addPassenger();
//        menu.addPassenger();
//        menu.addPassenger();
        menu.bookPassengerOnFlight();
    }

}
