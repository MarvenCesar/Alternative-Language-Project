public class Cell {
    private String oem;
    private String model;
    private String launch_announced;
    private String launch_status;
    private String body_dimensions;
    private String body_weight;
    private String body_sim;
    private String display_type;
    private String display_size;
    private String display_resolution;
    private String features_sensors;
    private String platform_os;

    public Cell(String oem, String model, String launched_announced, String launch_status, String body_dimension,
                String body_weight, String body_sim, String display_type, String display_size, String display_resolution,
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
    public String getLaunchAnnounced() {
        return launch_announced;
    }

    public void setLaunchAnnounced(String launchAnnounced) {
        this.launch_announced = launch_announced;
    }

    // Getters and setters for launchStatus
    public String getLaunchStatus() {
        return launch_status;
    }

    public void setLaunchStatus(String launchStatus) {
        this.launch_status = launch_status;
    }

    // Getters and setters for bodyDimensions
    public String getBodyDimensions() {
        return body_dimensions;
    }

    public void setBodyDimensions(String bodyDimensions) {
        this.body_dimensions = body_dimensions;
    }

    // Getters and setters for bodyWeight
    public String getBodyWeight() {
        return body_weight;
    }

    public void setBodyWeight(String bodyWeight) {
        this.body_weight = body_weight;
    }

    // Getters and setters for bodySim
    public String getBodySim() {
        return body_sim;
    }

    public void setBodySim(String bodySim) {
        this.body_sim = body_sim;
    }

    // Getters and setters for displayType
    public String getDisplayType() {
        return display_type;
    }

    public void setDisplayType(String displayType) {
        this.display_type = display_type;
    }

    // Getters and setters for displaySize
    public String getDisplaySize() {
        return display_size;
    }

    public void setDisplaySize(String displaySize) {
        this.display_size = display_size;
    }

    // Getters and setters for displayResolution
    public String getDisplayResolution() {
        return display_resolution;
    }

    public void setDisplayResolution(String displayResolution) {
        this.display_resolution = display_resolution;
    }

    // Getters and setters for featuresSensors
    public String getFeaturesSensors() {
        return features_sensors;
    }

    public void setFeaturesSensors(String featuresSensors) {
        this.features_sensors = features_sensors;
    }

    // Getters and setters for platformOs
    public String getPlatformOs() {
        return platform_os;
    }

    public void setPlatformOs(String platformOs) {
        this.platform_os = platform_os;
    }

}
