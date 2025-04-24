import java.util.ArrayList;
import java.util.List;

public class Home {
    private List<Device> devices = new ArrayList<>();
    private List<AutomationRules> rules = new ArrayList<>();

    public String addDevice(String type, String name, String protocol) {
        for (Device device : devices) {
            if (device.getName().equals(name)) {
                return "duplicate device name";
            }
        }

        if (type.equals("light")) {
            devices.add(new Light(name, protocol));
        } else {
            devices.add(new Thermostat(name, protocol));
        }

        return "device added successfully";
    }

    public String removeDevice(String name) {
        Device device = findDeviceByName(name);
        if (device == null) return "device not found";

        devices.remove(device);

        List<AutomationRules> toRemove = new ArrayList<>();
        for (AutomationRules rule : rules) {
            if (rule.getName().equals(name)) {
                toRemove.add(rule);
            }
        }
        for (AutomationRules rule : toRemove) {
            rules.remove(rule);
        }
        return "device removed successfully";
    }

    public void listDevices() {
        if (devices.isEmpty()) {
            System.out.println();
            return;
        }

        for (Device device : devices) {
            System.out.println(device.getStatusInfo());
        }
    }

    public String addRule(String name, String time, String action) {
        Device device = findDeviceByName(name);
        if (device == null) return "device not found";

        if (!isValidTimeFormat(time)) return "invalid time";
        if (!(action.equals("on") || action.equals("off"))) return "invalid action";

        for (AutomationRules rule : rules) {
            if (rule.getName().equals(name) && rule.getTime().equals(time)) {
                return "duplicate rule";
            }
        }

        rules.add(new AutomationRules(name, time, action));
        return "rule added successfully";
    }

    public String checkRules(String time) {
        if (!isValidTimeFormat(time)) return "invalid time";

        for (AutomationRules rule : rules) {
            if (rule.getTime().equals(time)) {
                Device device = findDeviceByName(rule.getName());
                if (device != null) {
                    if (rule.getAction().equals("on")) device.turnOn();
                    else device.turnOff();
                }
            }
        }

        return "rules checked";
    }

    public void listRules() {
        if (rules.isEmpty()) {
            System.out.println();
            return;
        }

        for (AutomationRules r : rules) {
            System.out.println(r);
        }
    }

    private Device findDeviceByName(String name) {
        for (Device d : devices) {
            if (d.getName().equals(name)) return d;
        }
        return null;
    }
    private boolean isValidTimeFormat(String time) {
        String[] parts = time.split(":");
        if (parts.length != 2) return false;

        try {
            int h = Integer.parseInt(parts[0]);
            int m = Integer.parseInt(parts[1]);

            if (h < 0 || h > 23) return false;
            if (m < 0 || m > 59) return false;

            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
