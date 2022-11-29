import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class AirlinesFileWriter {

    public static void makeFile (String filePath, Menu menu) {

        File file = new File(filePath);
        try {

            FileWriter outputFile = new FileWriter(file);
            CSVWriter writer = new CSVWriter(outputFile);

            String[] header = {"Passengers: "};
            writer.writeNext(header);

            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    // public void addPassenger (String filePath, Passenger passenger, Menu menu){
    //
// String[] data = menu.getPassengers();
    // }

}
