import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FlightFileWriter {

    public static void makeFile (String filePath, Menu menu, Flight flight) throws IOException {

        FileWriter outputFile;
        //File file = new File(filePath);
        Path path = Paths.get(filePath);
        if (Files.notExists(path)){
            File file = new File(filePath);
            outputFile = new FileWriter(file);

            CSVWriter writer = new CSVWriter(outputFile, '|', CSVWriter.NO_QUOTE_CHARACTER, CSVWriter.DEFAULT_ESCAPE_CHARACTER, CSVWriter.DEFAULT_LINE_END);

            String[] header = {"Flights: "};
            writer.writeNext(header);
        }
        else {
            outputFile = new FileWriter("flights.txt", true);
        }
        try {
            CSVWriter writer = new CSVWriter(outputFile, '|', CSVWriter.NO_QUOTE_CHARACTER, CSVWriter.DEFAULT_ESCAPE_CHARACTER, CSVWriter.DEFAULT_LINE_END);

            String[] dataFlights;
            dataFlights = new String[]{flight.getDestination(), String.valueOf(flight.getId()), String.valueOf(flight.getPassengers().toString())};
            writer.writeNext(dataFlights);

            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
