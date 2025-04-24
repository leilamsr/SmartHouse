public class AutomationRules {
    private String name;
    private String time;
    private String action;

    public AutomationRules(String name, String time, String action) {
        this.name = name;
        this.time = time;
        this.action = action;
    }

    public String getName() {
        return name;
    }

    public String getTime() {
        return time;
    }

    public String getAction() {
        return action;
    }
}
