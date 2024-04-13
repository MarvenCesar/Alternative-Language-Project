
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String line;
        Map<String, Cell> cellMap = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader("src/cells.csv"))) {
            // Skip the header
            br.readLine();

            while ((line = br.readLine()) != null) {
                String[] values = line.split(","); // Assumes no commas in values; use a CSV library otherwise
                if (values.length < 12) {
                    // If so, create a new array with 12 elements
                    String[] completeValues = new String[12];
                    // Copy the existing values into the new array
                    System.arraycopy(values, 0, completeValues, 0, values.length);
                    // Fill the rest of the array with a default value or an empty string
                    Arrays.fill(completeValues, values.length, 12, "default"); // You can choose an appropriate default value
                    // Use the new array with complete values
                    values = completeValues;
                }
                Cell cell = new Cell(values[0], values[1] , values[2], values[3], values[4], values[5], values[6],
                        values[7], values[8], values[9], values[10], values[11]);
                cellMap.put(values[1], cell); // Assumes the model name is unique and used as a key
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


