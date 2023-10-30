import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ShoppingList {
    private List<String> shoppingList;
    private Scanner scanner;

    public ShoppingList() {
        shoppingList = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void run() {
        boolean exit = false;

        while (!exit) {
            System.out.println("Menu:");
            System.out.println("1. Aggiungi articolo alla lista");
            System.out.println("2. Rimuovi articolo dalla lista");
            System.out.println("3. Visualizza lista della spesa");
            System.out.println("4. Esci");
            System.out.print("Scelta: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addItemToShoppingList();
                    break;
                case 2:
                    removeItemFromShoppingList();
                    break;
                case 3:
                    viewShoppingList();
                    break;
                case 4:
                    exit = true;
                    break;
                default:
                    System.out.println("Scelta non valida. Riprova.");
            }
        }
    }

    private void addItemToShoppingList() {
        scanner.nextLine(); // Consumes the newline character
        System.out.print("Inserisci l'articolo da aggiungere: ");
        String item = scanner.nextLine();
        shoppingList.add(item);
        System.out.println("Articolo aggiunto alla lista: " + item);
    }

    private void removeItemFromShoppingList() {
        if (shoppingList.isEmpty()) {
            System.out.println("Nessun articolo nella lista della spesa da rimuovere.");
            return;
        }

        System.out.print("Inserisci l'indice dell'articolo da rimuovere: ");
        int index = scanner.nextInt();

        if (index >= 0 && index < shoppingList.size()) {
            String removedItem = shoppingList.remove(index);
            System.out.println("Articolo rimosso dalla lista: " + removedItem);
        } else {
            System.out.println("Indice non valido. Riprova.");
        }
    }

    private void viewShoppingList() {
        if (shoppingList.isEmpty()) {
            System.out.println("Nessun articolo nella lista della spesa.");
        } else {
            System.out.println("Lista della spesa:");
            for (int i = 0; i < shoppingList.size(); i++) {
                System.out.println(i + ". " + shoppingList.get(i));
            }
        }
    }

    public static void main(String[] args) {
        ShoppingList app = new ShoppingList();
        app.run();
    }
}
