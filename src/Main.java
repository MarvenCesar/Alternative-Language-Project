
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.FileReader;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;




public class Main {

    public static void main(String[] args) {
        Map<Integer, Cell> cellMap = processCsvFile("src/cells.csv");

        for (Integer key : cellMap.keySet()) {
            System.out.println("Key: " + key + " Data: " + cellMap.get(key));
        }
        List<Cell> cells = new ArrayList<>(cellMap.values());
        calculateAverageLaunchYear(cells);
        Optional<Map.Entry<String, Double>> oemWithHighestAvgWeight = CellStatistics.getOemWithHighestAverageWeight(cells);
        // print function to display OEM and models of phones with different announce and release years
        CellUtils.printPhonesWithDifferentAnnounceAndReleaseYears(cells);

        // Print out the result
        if (oemWithHighestAvgWeight.isPresent()) {
            Map.Entry<String, Double> entry = oemWithHighestAvgWeight.get();
            System.out.println("OEM with the highest average body weight: " + entry.getKey() + " with an average of " + entry.getValue() + " grams");
        } else {
            System.out.println("Could not determine the OEM with the highest average body weight.");
        }
        writeCellMapToCSV(cellMap, "output.csv");
        Cell myCell = new Cell(
                "Samsung",
                "Galaxy S21",
                2021,
                "Released",
                "151.7 x 71.2 x 7.9 mm",
                171f,
                "Dynamic AMOLED 2X",
                "LTPS IPS LCD capacitive touchscreen, 16M colors",
                3.1f,
                "480 x 800 pixels, 5:3 ratio (~267 ppi density)",
                "Fingerprint (rear-mounted), accelerometer, gyro, proximity, compass, barometer",
                "Android 10"
        );


        // Call printSummary to print the cell details to the console
        myCell.printSummary();




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
                Float bodyWeight = extractWeightInGrams(values[5]);
                String bodySimProcessed = processBodySim(values[6]);
                Float displaySizeProcessed = extractDisplaySizeInInches(values[8]);
                String platformOSProcessed = processPlatformOS(values[11]);
                String bodyDimensionsProcessed = processBodyDimensions(values[4]);
                Cell cell = new Cell(values[0], values[1], launchYear,launchStatusProcessed, bodyDimensionsProcessed, bodyWeight, bodySimProcessed,
                        values[7], displaySizeProcessed, values[9], values[10], platformOSProcessed);
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
        int parenthesesLevel = 0; // This tracks the level of nested parentheses
        StringBuilder buffer = new StringBuilder();

        for (char c : line.toCharArray()) {
            switch (c) {
                case '"':
                    inQuotes = !inQuotes; // Toggle the inQuotes flag
                    buffer.append(c);
                    break;
                case '(':
                    if (!inQuotes) {
                        parenthesesLevel++; // Increase nesting level if not in quotes
                    }
                    buffer.append(c);
                    break;
                case ')':
                    if (!inQuotes && parenthesesLevel > 0) {
                        parenthesesLevel--; // Decrease nesting level if not in quotes
                    }
                    buffer.append(c);
                    break;
                case ',':
                    if (!inQuotes && parenthesesLevel == 0) {
                        // Only add to values and reset buffer if we're not in quotes or inside parentheses
                        values.add(buffer.toString().trim());
                        buffer.setLength(0);
                    } else {
                        buffer.append(c); // It's a comma inside quotes or parentheses
                    }
                    break;
                default:
                    buffer.append(c); // Continue building the field
            }
        }
        values.add(buffer.toString().trim()); // Add the last field to values

        return values.toArray(new String[0]);
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
            System.out.println("\n Average Launch Year: " + averageYear);
        } else {
            System.out.println("No valid launch years to calculate average.");
        }
    }
    private static Float extractWeightInGrams(String bodyWeight) {
        // Regex to find an integer or float number followed by a 'g' (ignoring case).
        Pattern pattern = Pattern.compile("(\\d+(?:\\.\\d+)?)\\s*g", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(bodyWeight);

        if (matcher.find()) {
            String weightString = matcher.group(1);  // Extract the number before 'g'
            try {
                return Float.parseFloat(weightString);  // Parse the number as float and return
            } catch (NumberFormatException e) {
                // Handle the case where the number is not in a valid format
                System.err.println("Invalid weight format: " + bodyWeight);
                return null;
            }
        }

        return null;  // Return null if no valid weight is found
    }
    private static String processBodySim(String body_sim) {
        // Check if the bodySim equals to "No", "Yes", or doesn't consist of only letters
        if ( "No".equalsIgnoreCase(body_sim) || "Yes".equalsIgnoreCase(body_sim) ) {
            return null;  // Return null for invalid data
        }
        return body_sim;  // Return the original bodySim for valid data
    }
    private static Float extractDisplaySizeInInches(String displaySizeStr) {
        // Regex to check if the string contains a number followed by "inches"
        Pattern pattern = Pattern.compile("(\\d+(\\.\\d+)?)\\s*inches", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(displaySizeStr);

        if (matcher.find()) {
            String size = matcher.group(1);  // This extracts the number before "inches"
            try {
                return Float.parseFloat(size);  // Parse the extracted number as a float and return
            } catch (NumberFormatException e) {
                System.err.println("Invalid format for display size: " + displaySizeStr);
                return null;
            }
        }

        return null;  // Return null if no valid format is found
    }
    private static String processPlatformOS(String platformOS) {
        if (platformOS == null || platformOS.matches("^\\d+(\\.\\d+)?$")) {
            // Returns null for null or purely numeric strings
            return null;
        }

        // Trim the string and remove leading and trailing quotes
        String cleanPlatformOS = platformOS.trim().replaceAll("^\"+|\"+$", "");

        // Find the first comma and return the substring up to that point, if it exists
        int commaIndex = cleanPlatformOS.indexOf(',');
        if (commaIndex != -1) {
            // Return the substring up to the first comma
            return cleanPlatformOS.substring(0, commaIndex).trim();
        }

        // Return the cleaned string if there's no comma
        return cleanPlatformOS;
    }
    private static String processBodyDimensions(String bodyDimensions) {
        if (bodyDimensions == null || bodyDimensions.contains("-") || bodyDimensions.contains("V1")) {
            return null;
        }
        return bodyDimensions;
    }
    public class CellStatistics {

        // ...

        public static Optional<Map.Entry<String, Double>> getOemWithHighestAverageWeight(List<Cell> cells) {
            // Map of OEM to their average weights
            Map<String, Double> oemAverageWeights = cells.stream()
                    // Filter out cells with no weight information
                    .filter(cell -> cell.getBodyWeight() != null)
                    // Group by OEM
                    .collect(Collectors.groupingBy(
                            Cell::getOem,
                            // Averaging the body weights
                            Collectors.averagingDouble(Cell::getBodyWeight)
                    ));

            // Find the entry with the highest average weight
            return oemAverageWeights.entrySet().stream()
                    .max(Map.Entry.comparingByValue());
        }
    }
    public class CellUtils {

        // Method to find phones that were announced in one year and released in another
        public static List<Cell> findPhonesWithDifferentAnnounceAndReleaseYears(List<Cell> cells) {
            return cells.stream()
                    // Filter for cells that have both announced and release years and they are different
                    .filter(cell -> cell.getLaunchAnnounced() != null && cell.getLaunchStatus() != null
                            && !cell.getLaunchAnnounced().equals(cell.getLaunchStatus()))
                    .collect(Collectors.toList());
        }

        // Method to print the OEM and model of those phones
        public static void printPhonesWithDifferentAnnounceAndReleaseYears(List<Cell> cells) {
            System.out.println("\nList of phones with different Announced and Released Years: ");
            findPhonesWithDifferentAnnounceAndReleaseYears(cells).forEach(cell ->
                    System.out.println("Company: " + cell.getOem() + ", Model: " + cell.getModel())
            );
        }
    }
    }







