

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class maintenance {
    private List<String> activities = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void addActivity(String activity) {
        activities.add(activity);
        System.out.println(activity + " has been added to maintenance activities.");
    }

    public List<String> checkUncompletedActivities() {
        return activities; // Return the list of activities.
    }

    public void markActivityCompleted(String activity) {
        if (activities.contains(activity)) {
            activities.remove(activity);
            System.out.println(activity + " has been marked as completed.");
        } else {
            System.out.println(activity + " is not in the maintenance activities list.");
        }
    }

    public void startMaintenance() {
        while (true) {
            System.out.println("Maintenance Options:");
            System.out.println("1. Add maintenance activity");
            System.out.println("2. Check uncompleted activities");
            System.out.println("3. Mark activity as completed");
            System.out.println("4. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline

            switch (choice) {
                case 1:
                    System.out.print("Enter the maintenance activity: ");
                    addActivity(scanner.nextLine());
                    break;
                case 2:
                    checkUncompletedActivities();
                    break;
                case 3:
                    System.out.print("Enter the activity to mark as completed: ");
                    markActivityCompleted(scanner.nextLine());
                    break;
                case 4:
                    System.out.println("Exiting maintenance activities.");
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
