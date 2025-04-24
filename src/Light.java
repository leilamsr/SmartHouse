public class Light extends Device {
    private int light;

    public Light(String name, String protocol) {
        super(name, protocol);
        this.light = 0;
    }

    @Override
    public String getStatusInfo() {
        if (getStatus()) {
            return getName() + " " + "On" + " " + light + " % " + getProtocol();
        }
        else {
            return getName() + " " + "Off" + " " + light + " % " + getProtocol();
        }
    }

    public void setLight() {
        if (light < 0 || light > 100) {
            System.out.println("Error: light out of range");
            return;
        }

        this.light = light;
    }
}
