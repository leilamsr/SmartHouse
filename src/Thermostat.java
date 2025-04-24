public class Thermostat extends Device {
    private int temperature;

    public Thermostat(String name, String protocol) {
        super(name, protocol);
        this.temperature = 0;
    }

    @Override
    public String getStatusInfo() {
        if (getStatus()) {
            return getName() + " " + "On" + " " + temperature + " c " + getProtocol();
        }
        else {
            return getName() + " " + "Off" + " " + temperature + " c " + getProtocol();
        }
    }

    public void setTemperature(int temperature) {
        if (temperature < 0 || temperature > 50) {
            System.out.println("Error: temperature out of range");
            return;
        }
        this.temperature = temperature;
    }
}
