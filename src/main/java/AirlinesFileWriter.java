import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class AirlinesFileWriter {

    public static void makeFile (String filePath, Menu menu) {

        File file = new File(filePath);
        try {

            FileWriter outputFile = new FileWriter(file);
            CSVWriter writer = new CSVWriter(outputFile, '|', CSVWriter.NO_QUOTE_CHARACTER, CSVWriter.DEFAULT_ESCAPE_CHARACTER, CSVWriter.DEFAULT_LINE_END);

            String[] header = {"Passengers: "};
            writer.writeNext(header);

            String[] dataPassenger;
            for (Passenger passenger : menu.getPassengers()) {
                dataPassenger = new String[]{passenger.getName(), String.valueOf(passenger.getId()), String.valueOf(passenger.getContactInfo())};
                writer.writeNext(dataPassenger);
            }

            String[] horizontalDivider = {"--------------------"};
            writer.writeNext(horizontalDivider);
            String[] headerFlights = {"Flights: "};
            writer.writeNext(headerFlights);

            String[] dataFlights;
            for (Flight flight : menu.getFlights()) {
                dataFlights = new String[]{flight.getDestination(), String.valueOf(flight.getId()), String.valueOf(flight.getPassengers().toString())};
                writer.writeNext(dataFlights);
            }

            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
