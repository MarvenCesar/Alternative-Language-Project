public class Cell {
    private String oem;
    private String model;
    private Integer launch_announced;
    private String launch_status;
    private String body_dimensions;
    private Float body_weight;
    private String body_sim;
    private String display_type;
    private String display_size;
    private String display_resolution;
    private String features_sensors;
    private String platform_os;

    public Cell(String oem, String model, Integer launched_announced, String launch_status, String body_dimension,
                Float body_weight, String body_sim, String display_type, String display_size, String display_resolution,
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
    public String getDisplaySize() {
        return display_size;
    }

    public void setDisplaySize(String display_size) {
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
                (display_size != null ? display_size : "") + "," +
                (display_resolution != null ? display_resolution : "") + "," +
                (features_sensors != null ? features_sensors : "") + "," +
                (platform_os != null ? platform_os : "");
    }

}
