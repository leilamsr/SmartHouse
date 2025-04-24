public abstract class Device {
    private String name;
    private String protocol;
    private boolean status;

    public Device(String name, String protocol) {
        this.name = name;
        this.protocol = protocol;
        this.status = false;
    }

    public String getName() {
        return name;
    }

    public String getProtocol() {
        return protocol;
    }

    public boolean getStatus() {
        return status;
    }

    public void turnOn() {
        status = true;
    }

    public void turnOff() {
        status = false;
    }

    public abstract String getStatusInfo();
}
