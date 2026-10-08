import java.util.*;

public class ARPRARP {

    static String[] ip = {
        "172.16.5.200",
        "172.16.5.201",
        "172.16.5.202",
        "172.16.5.203",
        "172.16.5.204"
    };

    static String[] mac = {
        "12.13.24.0.0.1",
        "12.13.24.0.0.2",
        "12.13.24.0.0.3",
        "12.13.24.0.0.4",
        "12.13.24.0.0.5"
    };

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("1. ARP");
        System.out.println("2. RARP");
        System.out.print("Enter choice: ");

        int choice = sc.nextInt();
        sc.nextLine();

        if (choice == 1) {

            System.out.print("Enter the IP address: ");
            String x = sc.nextLine();

            for (int i = 0; i < ip.length; i++) {
                if (x.equals(ip[i])) {
                    System.out.println(
                        "The corresponding MAC address: "
                        + mac[i]);
                    return;
                }
            }

            System.out.println("IP address not found.");
        }

        else if (choice == 2) {

            System.out.print("Enter the MAC address: ");
            String x = sc.nextLine();

            for (int i = 0; i < mac.length; i++) {
                if (x.equals(mac[i])) {
                    System.out.println(
                        "The corresponding IP address: "
                        + ip[i]);
                    return;
                }
            }

            System.out.println("MAC address not found.");
        }

        else {
            System.out.println("Invalid choice.");
        }

        sc.close();
    }
}