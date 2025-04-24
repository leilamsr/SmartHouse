import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        Home system = new Home();

        int q = Integer.parseInt(scn.nextLine());

        for (int i = 0; i < q; i++) {
            String line = scn.nextLine();
            String[] parts = line.split(" ");

            switch (parts[0]) {
                case "add_device":
                    System.out.println(system.addDevice(parts[1], parts[2], parts[3]));
                    break;

                case "remove_device":
                    System.out.println(system.removeDevice(parts[1]));
                    break;

                case "list_devices":
                    system.listDevices();
                    break;

                case "add_rule":
                    System.out.println(system.addRule(parts[1], parts[2], parts[3]));
                    break;

                case "check_rules":
                    System.out.println(system.checkRules(parts[1]));
                    break;

                case "list_rules":
                    system.listRules();
                    break;
            }
        }
    }
}