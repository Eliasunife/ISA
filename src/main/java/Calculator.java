import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

    public void run() {
        boolean exit = false;

        while (!exit) {
            System.out.println("Menu:");
            System.out.println("1. Crea nuova lista della spesa");
            System.out.println("2. Aggiungi articolo a una lista");
            System.out.println("3. Visualizza lista della spesa");
            System.out.println("4. Esci");
            System.out.print("Scelta: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    createShoppingList();
                    break;
                case 2:
                    addItemToShoppingList();
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

    private void createShoppingList() {
        scanner.nextLine(); // Consumes the newline character
        System.out.print("Nome della lista: ");
        String listName = scanner.nextLine();
        ShoppingList shoppingList = new ShoppingList(listName);
        shoppingLists.add(shoppingList);
        System.out.println("Lista della spesa creata: " + listName);
    }

    private void addItemToShoppingList() {
        if (shoppingLists.isEmpty()) {
            System.out.println("Nessuna lista della spesa disponibile. Crea una lista prima di aggiungere articoli.");
            return;
        }

        System.out.println("Liste della spesa disponibili:");
        for (int i = 0; i < shoppingLists.size(); i++) {
            System.out.println(i + ". " + shoppingLists.get(i).getName());
        }
        System.out.print("Seleziona la lista (inserisci il numero): ");
        int listIndex = scanner.nextInt();

        if (listIndex < 0 || listIndex >= shoppingLists.size()) {
            System.out.println("Indice non valido.");
            return;
        }

        scanner.nextLine(); // Consumes the newline character
        System.out.print("Nome dell'articolo: ");
        String itemName = scanner.nextLine();
        shoppingLists.get(listIndex).addItem(itemName);
        System.out.println("Articolo aggiunto alla lista: " + itemName);
    }

    private void viewShoppingList() {
        if (shoppingLists.isEmpty()) {
            System.out.println("Nessuna lista della spesa disponibile.");
            return;
        }

        System.out.println("Liste della spesa disponibili:");
        for (int i = 0; i < shoppingLists.size(); i++) {
            System.out.println(i + ". " + shoppingLists.get(i).getName());
        }
        System.out.print("Seleziona la lista da visualizzare (inserisci il numero): ");
        int listIndex = scanner.nextInt();

        if (listIndex < 0 || listIndex >= shoppingLists.size()) {
            System.out.println("Indice non valido.");
            return;
        }

        ShoppingList selectedList = shoppingLists.get(listIndex);
        System.out.println("Lista della spesa: " + selectedList.getName());
        List<String> items = selectedList.getItems();
        if (items.isEmpty()) {
            System.out.println("Nessun articolo nella lista.");
        } else {
            System.out.println("Articoli nella lista:");
            for (String item : items) {
                System.out.println(item);
            }
        }
    }

    public static void main(String[] args) {
        ShoppingListApp app = new ShoppingListApp();
        app.run();
    }
}
