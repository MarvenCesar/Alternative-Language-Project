
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class Main {
    public static void main(String[] args) {
        String line;
        Map<String, Cell> cellMap = new HashMap<>();
        final int weightColumnIndex = 5;

        try (BufferedReader br = new BufferedReader(new FileReader("src/cells.csv"))) {
            // Skip the header
            br.readLine();

            while ((line = br.readLine()) != null) {
                String[] rawValues = line.split(",");
                String[] values = new String[rawValues.length];

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
                for (int i = 0; i < rawValues.length; i++) {
                    if (rawValues[i].trim().isEmpty() || rawValues[i].trim().equals("-")) {
                        values[i] = null; // Replace with null or ""
                    } else if (i == weightColumnIndex) { // Replace with the actual index of the weight column
                        values[i] = extractWeight(rawValues[i]);
                    } else {
                        values[i] = rawValues[i].trim();
                    }
                }
                Integer weight = (values[weightColumnIndex] != null && !values[weightColumnIndex].isEmpty())
                        ? Integer.parseInt(values[weightColumnIndex]) : null;

                Cell cell = new Cell(values[0], values[1] , values[2], values[3], values[4], values[5], values[6],
                        values[7], values[8], values[9], values[10], values[11]);
                cellMap.put(values[1], cell); // Assumes the model name is unique and used as a key

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        writeCellMapToFile(cellMap, "output.txt");
    }
    private static void writeCellMapToFile(Map<String, Cell> cellMap, String filename) {
        try (PrintWriter out = new PrintWriter(new FileWriter(filename))) {
            for (Map.Entry<String, Cell> entry : cellMap.entrySet()) {
                out.println(entry.getKey() + " => " + entry.getValue().toString());
                // Make sure your Cell class has a meaningful toString() method
            }
        } catch (IOException e) {
            System.err.println("Error while writing to the file: " + e.getMessage());
        }
    }
    private static String extractWeight(String weightStr) {
        Matcher matcher = Pattern.compile("(\\d+)").matcher(weightStr);
        return matcher.find() ? matcher.group(1) : "0"; // Default to 0 if no number found
    }
}




