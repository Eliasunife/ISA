
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Choose an application to open:");
            System.out.println("1. Shopping List");
            System.out.println("2. Maintenance Activities");
            System.out.println("3. Reminder");
            System.out.println("4. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline

            switch (choice) {
                case 1:
                    my_shopinglist shoppingList = new my_shopinglist();
                    shoppingList.startShopping();
                    break;
                case 2:
                    maintenance maintenance = new maintenance();
                    maintenance.startMaintenance();
                    break;
                case 3:
                    reminder reminder = new reminder();
                    System.out.print("Enter the reminder message: ");
                    String message = scanner.nextLine();
                    System.out.print("Enter the delay in seconds: ");
                    int delay = scanner.nextInt();
                    reminder.addReminder(message, delay);
                    break;
                case 4:
                    System.out.println("Exiting the application.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
