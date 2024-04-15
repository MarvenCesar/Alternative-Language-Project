public class Cell {
    private String oem;
    private String model;
    private Integer launch_announced;
    private String launch_status;
    private String body_dimensions;
    private Float body_weight;
    private String body_sim;
    private String display_type;
    private Float display_size;
    private String display_resolution;
    private String features_sensors;
    private String platform_os;

    public Cell(String oem, String model, Integer launched_announced, String launch_status, String body_dimension,
                Float body_weight, String body_sim, String display_type, Float display_size, String display_resolution,
                String features_sensors, String platform_os) {
        this.oem = oem;
        this.model = model;
        this.launch_announced = launched_announced;
        this.launch_status = launch_status;
        this.body_dimensions = body_dimension;
        this.body_weight = body_weight;
        this.body_sim = body_sim;
        this.display_type = display_type;
        this.display_size = display_size;
        this.display_resolution = display_resolution;
        this.features_sensors = features_sensors;
        this.platform_os = platform_os;
    }

    public String getOem() {
        return oem;
    }

    public void setOem(String oem) {
        this.oem = oem;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getLaunchAnnounced() {
        return launch_announced;
    }

    public void setLaunchAnnounced(Integer launch_announced) {
        this.launch_announced = launch_announced;
    }

    // Getters and setters for launchStatus
    public String getLaunchStatus() {
        return launch_status;
    }

    public void setLaunchStatus(String launch_status) {
        this.launch_status = launch_status;
    }

    // Getters and setters for bodyDimensions
    public String getBodyDimensions() {
        return body_dimensions;
    }

    public void setBodyDimensions(String body_dimensions) {
        this.body_dimensions = body_dimensions;
    }

    // Getters and setters for bodyWeight
    public Float getBodyWeight() {
        return body_weight;
    }

    public void setBodyWeight(Float body_weight) {
        this.body_weight = body_weight;
    }

    // Getters and setters for bodySim
    public String getBodySim() {
        return body_sim;
    }

    public void setBodySim(String body_sim) {
        this.body_sim = body_sim;
    }

    // Getters and setters for displayType
    public String getDisplayType() {
        return display_type;
    }

    public void setDisplayType(String display_type) {
        this.display_type = display_type;
    }

    // Getters and setters for displaySize
    public Float getDisplaySize() {
        return display_size;
    }

    public void setDisplaySize(Float display_size) {
        this.display_size = display_size;
    }

    // Getters and setters for displayResolution
    public String getDisplayResolution() {
        return display_resolution;
    }

    public void setDisplayResolution(String display_resolution) {
        this.display_resolution = display_resolution;
    }

    // Getters and setters for featuresSensors
    public String getFeaturesSensors() {
        return features_sensors;
    }

    public void setFeaturesSensors(String features_sensors) {
        this.features_sensors = features_sensors;
    }

    // Getters and setters for platformOs
    public String getPlatformOs() {
        return platform_os;
    }

    public void setPlatformOs(String platform_os) {
        this.platform_os = platform_os;
    }
    public String printSummary() {
        // StringBuilder to create the summary string
        StringBuilder summary = new StringBuilder();

        // Append each field with a label for clarity
        summary.append("OEM: ").append(this.oem != null ? this.oem : "Unknown").append("\n");
        summary.append("Model: ").append(this.model != null ? this.model : "Unknown").append("\n");
        summary.append("Launch Year: ").append(this.launch_announced != null ? this.launch_announced : "Unknown").append("\n");
        summary.append("Launch Status: ").append(this.launch_status != null ? this.launch_status : "Unknown").append("\n");
        summary.append("Body Dimensions: ").append(this.body_dimensions != null ? this.body_dimensions : "Unknown").append("\n");
        summary.append("Body Weight: ").append(this.body_weight != null ? this.body_weight + "g" : "Unknown").append("\n");
        summary.append("Display Type: ").append(this.display_type != null ? this.display_type : "Unknown").append("\n");
        summary.append("Display Size: ").append(this.display_size != null ? this.display_size + " inches" : "Unknown").append("\n");
        summary.append("Platform OS: ").append(this.platform_os != null ? this.platform_os : "Unknown").append("\n");
        // Continue for other fields as necessary

        // Print to console or return the string
        String summaryString = summary.toString();
        System.out.println(summaryString);
        return summaryString;
    }

    @Override
    public String toString() {
        return (oem != null ? oem : "") + "," +
                (model != null ? model : "") + "," +
                (launch_announced != null ? launch_announced : "") + "," +
                (launch_status != null ? launch_status : "") + "," +
                (body_dimensions != null ? body_dimensions : "") + "," +
                (body_weight != null ? body_weight : "") + "," +
                (body_sim != null ? body_sim : "") + "," +
                (display_type != null ? display_type : "") + "," +
                (display_size != null ? display_size + " inches" : " ") + "," +
                (display_resolution != null ? display_resolution : "") + "," +
                (features_sensors != null ? features_sensors : "") + "," +
                (platform_os != null ? platform_os : "");
    }

}
