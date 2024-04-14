
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.FileReader;
import java.util.List;




public class Main {
    private static final int NUM_FIELDS = 12;
    private static final int WEIGHT_COLUMN_INDEX = 5;

    public static void main(String[] args) {
        Map<Integer, Cell> cellMap = processCsvFile("src/cells.csv");
        // Example of using the map
        for (Integer key : cellMap.keySet()) {
            System.out.println("Key: " + key + " Data: " + cellMap.get(key));
        }
        List<Cell> cells = new ArrayList<>(cellMap.values());
        calculateAverageLaunchYear(cells);
        writeCellMapToCSV(cellMap, "output.csv");

    }


    private static Map<Integer, Cell> processCsvFile(String filePath) {
        Map<Integer, Cell> cellMap = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            br.readLine(); // Skip header
            String line;

            int index = 0; // Initialize a counter
            while ((line = br.readLine()) != null) {
                String[] values = processDataLine(line);
                Integer launchYear = extractYear(values[2]);
                String launchStatusProcessed = processLaunchStatus(values[3]);
                Cell cell = new Cell(values[0], values[1], launchYear,launchStatusProcessed, values[4], values[5], values[6],
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
        List<String> values = new ArrayList<>();
        boolean inQuotes = false;
        StringBuilder buffer = new StringBuilder();

        for (char c : line.toCharArray()) {
            if (c == '"') {
                inQuotes = !inQuotes;  // Toggle the inQuotes flag
            } else if (c == ',' && !inQuotes) {
                values.add(buffer.toString().trim());  // Add the buffered field to values
                buffer.setLength(0);  // Reset the buffer
            } else {
                buffer.append(c);  // Continue building the field
            }
        }
        values.add(buffer.toString().trim());  // Add the last field to values

        return values.toArray(new String[0]);  // Convert the list to an array and return
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
        Pattern yearPattern = Pattern.compile("\\b(\\d{4})\\b");
        Matcher yearMatcher = yearPattern.matcher(launchAnnounced);
        if (yearMatcher.find()) {
            return Integer.parseInt(yearMatcher.group());  // Return the year as an Integer
        }
        return null;  // Return null if no year is found
    }
    private static String processLaunchStatus(String launchStatus) {
        if (launchStatus != null && (launchStatus.equals("Discontinued") || launchStatus.equals("Cancelled"))) {
            return launchStatus;
        }

        Pattern pattern = Pattern.compile("\\b(\\d{4})\\b");
        Matcher matcher = pattern.matcher(launchStatus);

        if (matcher.find()) {
            return matcher.group(1);  // Return the matched year
        }

        return null;  // If it doesn't match the year pattern or the special cases, return null
    }
    private static void calculateAverageLaunchYear(List<Cell> cells) {
        int totalYears = 0;
        int yearCount = 0;

        for (Cell cell : cells) {
            String launchStatus = cell.getLaunchStatus();

            // If launchStatus is a four-digit number, parse and include it in the calculation.
            if (launchStatus != null && launchStatus.matches("\\b\\d{4}\\b")) {
                totalYears += Integer.parseInt(launchStatus);
                yearCount++;
            }
            // Strings like 'Discontinued' or 'Cancelled' are ignored for the calculation.
        }

        if (yearCount > 0) {
            double averageYear = (double) totalYears / yearCount;
            System.out.println("Average Launch Year: " + averageYear);
        } else {
            System.out.println("No valid launch years to calculate average.");
        }
    }
    }







