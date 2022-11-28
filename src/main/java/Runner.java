public class Runner {

    public static void main(String[] args) {

        Menu menu = new Menu();
        menu.addFlight();
        menu.addFlight();
        menu.addFlight();
        menu.displayAllFLights();
        //menu.addPassenger();
        //menu.addPassenger();
        //menu.addPassenger();

        menu.cancelFLight();
    }

}
