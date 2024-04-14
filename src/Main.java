
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.FileReader;




public class Main {
    private static final int NUM_FIELDS = 12;
    private static final int WEIGHT_COLUMN_INDEX = 5;

    public static void main(String[] args) {
        Map<Integer, Cell> cellMap = processCsvFile("src/cells.csv");
        // Example of using the map
        for (Integer key : cellMap.keySet()) {
            System.out.println("Key: " + key + " Data: " + cellMap.get(key));
        }
        writeCellMapToCSV(cellMap, "output.csv");
    }


    private static Map<Integer, Cell> processCsvFile(String filePath) {
        Map<Integer, Cell> cellMap = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            br.readLine(); // Skip header
            String line = br.readLine();

            int index = 0; // Initialize a counter
            while ((line = br.readLine()) != null) {
                String[] values = processDataLine(line);
                Integer launchYear = extractYear(values[2]);
                Cell cell = new Cell(values[0], values[1], launchYear, values[3], values[4], values[5], values[6],
                        values[7], values[8], values[9], values[10], values[11]);
                cellMap.put(index, cell); // Use the index as the key
                index++; // Increment the index for the next entry
            }
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
        return cellMap;
    }
    private static String[] processDataLine(String line) {
        String[] rawValues = line.split(",");
        String[] values = new String[rawValues.length + 1];
        for (int i = 0; i < rawValues.length; i++) {
            // Trim the value to remove any leading or trailing whitespace.
            String trimmedValue = rawValues[i].trim();
            // Check if the value is empty or just a dash, and replace it with null.
            if (trimmedValue.isEmpty() || trimmedValue.equals("-")) {
                values[i] = null;
            } else {
                values[i] = trimmedValue;
            }
        }
        return values;
    }
    private static void writeCellMapToCSV(Map<Integer, Cell> cellMap, String filename) {
        try (PrintWriter out = new PrintWriter(new FileWriter(filename))) {
            // Optionally write a header line
            out.println("Index,OEM,Model,Launch Announced,Launch Status,Body Dimensions,Body Weight,Body SIM,Display Type,Display Size,Display Resolution,Features Sensors,Platform OS");
            // Iterate over each entry in the map
            for (Map.Entry<Integer, Cell> entry : cellMap.entrySet()) {
                out.println(entry.getKey() + "," + entry.getValue().toString());
            }
        } catch (IOException e) {
            System.err.println("Error while writing to the file: " + e.getMessage());
        }
    }
    private static String extractWeight(String weightStr) {
        Matcher matcher = Pattern.compile("(\\d+)").matcher(weightStr);
        return matcher.find() ? matcher.group(1) : "0"; // Default to 0 if no number found
    }
    private static Integer extractYear(String launchAnnounced) {
        if (launchAnnounced != null) {
            Pattern pattern = Pattern.compile("(\\d{4})");  // Regex to find four consecutive digits
            Matcher matcher = pattern.matcher(launchAnnounced);
            if (matcher.find()) {
                return Integer.parseInt(matcher.group(1));  // Return the first group of four digits found
            }
        }
        return null;  // Return null if no year is found or input is null
    }
}




