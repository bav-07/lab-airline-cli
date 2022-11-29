import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;


public class PassengerFileWriter {

    public static void makeFile (String filePath, Menu menu, Passenger passenger) throws IOException {

        FileWriter outputFile;
        //File file = new File(filePath);
        Path path = Paths.get(filePath);
        if (Files.notExists(path)){
            File file = new File(filePath);
            outputFile = new FileWriter(file);

            CSVWriter writer = new CSVWriter(outputFile, '|', CSVWriter.NO_QUOTE_CHARACTER, CSVWriter.DEFAULT_ESCAPE_CHARACTER, CSVWriter.DEFAULT_LINE_END);

            String[] header = {"Passengers: "};
            writer.writeNext(header);
        }
        else {
            //Files.write(path, )
            outputFile = new FileWriter("passengers.txt", true);
        }
        try {

            CSVWriter writer = new CSVWriter(outputFile, '|', CSVWriter.NO_QUOTE_CHARACTER, CSVWriter.DEFAULT_ESCAPE_CHARACTER, CSVWriter.DEFAULT_LINE_END);

            String[] dataPassenger;
            dataPassenger = new String[]{passenger.getName(), String.valueOf(passenger.getId()), String.valueOf(passenger.getContactInfo())};
            writer.writeNext(dataPassenger);

            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void readFile (String file){
        try {
            FileReader fileReader = new FileReader(file);
            CSVReader csvReader = new CSVReader(fileReader);
            String[] nextRecord;
            csvReader.readNext();
            while ((nextRecord = csvReader.readNext())!=null) {
                String stringRecord = Arrays.toString(nextRecord);
                stringRecord = stringRecord.substring(1,stringRecord.length()-1);
                String[] stringArray = stringRecord.split("\\|");

               // String [] splitString = nextRecord.toString().split("\\|");

                for (String element : stringArray) {
                    System.out.println(element.toString());

                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
