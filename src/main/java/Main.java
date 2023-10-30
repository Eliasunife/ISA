import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean exitRequested = false;

        while (!exitRequested) {
            System.out.println("Benvenuto! Scegli quale applicazione eseguire:");
            System.out.println("1. Gestione Lista della Spesa");
            System.out.println("2. Applicazione di Notifiche e Promemoria");
            System.out.println("3. Gestione Attività di Manutenzione");
            System.out.println("4. Esci dall'applicazione");
            System.out.print("Scelta: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    ShoppingList shoppingListApp = new ShoppingList();
                    shoppingListApp.run();
                    break;
                case 2:
                    Reminder reminderApp = new Reminder();
                    reminderApp.run(args);
                    break;
                case 3:
                    Maintenance maintenanceApp = new Maintenance();
                    maintenanceApp.run();
                    break;
                case 4:
                    exitRequested = true;
                    System.out.println("Uscita dall'applicazione.");
                    break;
                default:
                    System.out.println("Scelta non valida. Riprova.");
            }
        }

        scanner.close();
    }
}
