

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class my_shopinglist {
    private List<String> items = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void addItem(String item) {
        items.add(item);
        System.out.println(item + " has been added to the shopping list.");
    }

    public void removeItem(String item) {
        if (items.contains(item)) {
            items.remove(item);
            System.out.println(item + " has been removed from the shopping list.");
        } else {
            System.out.println(item + " is not in the shopping list.");
        }
    }

    public List<String> viewItems() {
        return items; // Return the list of items.
    }
    

    public void startShopping() {
        while (true) {
            System.out.println("Options:");
            System.out.println("1. Add item to the shopping list");
            System.out.println("2. Remove item from the shopping list");
            System.out.println("3. View shopping list");
            System.out.println("4. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline

            switch (choice) {
                case 1:
                    System.out.print("Enter the item to add: ");
                    addItem(scanner.nextLine());
                    break;
                case 2:
                    System.out.print("Enter the item to remove: ");
                    removeItem(scanner.nextLine());
                    break;
                case 3:
                    viewItems();
                    break;
                case 4:
                    System.out.println("Exiting shopping list.");
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}

