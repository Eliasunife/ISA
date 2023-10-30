
	import java.util.ArrayList;
	import java.util.List;
	import java.util.Scanner;

	public class Maintenance{
	    private List<MaintenanceTask> maintenanceTasks;
	    private Scanner scanner;

	    public Maintenance() {
	        maintenanceTasks = new ArrayList<>();
	        scanner = new Scanner(System.in);
	    }

	    public void run() {
	        boolean exit = false;

	        while (!exit) {
	            System.out.println("Menu:");
	            System.out.println("1. Aggiungi attività di manutenzione");
	            System.out.println("2. Visualizza attività di manutenzione");
	            System.out.println("3. Completamento attività di manutenzione");
	            System.out.println("4. Esci");
	            System.out.print("Scelta: ");
	            int choice = scanner.nextInt();

	            switch (choice) {
	                case 1:
	                    addMaintenanceTask();
	                    break;
	                case 2:
	                    viewMaintenanceTasks();
	                    break;
	                case 3:
	                    completeMaintenanceTask();
	                    break;
	                case 4:
	                    exit = true;
	                    break;
	                default:
	                    System.out.println("Scelta non valida. Riprova.");
	            }
	        }
	    }

	    private void addMaintenanceTask() {
	        scanner.nextLine(); // Consumes the newline character
	        System.out.print("Descrizione dell'attività: ");
	        String description = scanner.nextLine();
	        MaintenanceTask task = new MaintenanceTask(description);
	        maintenanceTasks.add(task);
	        System.out.println("Attività di manutenzione aggiunta: " + description);
	    }

	    private void viewMaintenanceTasks() {
	        if (maintenanceTasks.isEmpty()) {
	            System.out.println("Nessuna attività di manutenzione registrata.");
	            return;
	        }

	        System.out.println("Elenco delle attività di manutenzione:");
	        for (int i = 0; i < maintenanceTasks.size(); i++) {
	            MaintenanceTask task = maintenanceTasks.get(i);
	            String status = task.isCompleted() ? "Completata" : "In corso";
	            System.out.println(i + ". Descrizione: " + task.getDescription() + " - Stato: " + status);
	        }
	    }

	    private void completeMaintenanceTask() {
	        if (maintenanceTasks.isEmpty()) {
	            System.out.println("Nessuna attività di manutenzione registrata.");
	            return;
	        }

	        System.out.print("Inserisci il numero dell'attività da segnare come completata: ");
	        int taskIndex = scanner.nextInt();

	        if (taskIndex < 0 || taskIndex >= maintenanceTasks.size()) {
	            System.out.println("Indice non valido.");
	            return;
	        }

	        MaintenanceTask task = maintenanceTasks.get(taskIndex);
	        task.setCompleted(true);
	        System.out.println("Attività di manutenzione completata: " + task.getDescription());
	    }

	    public static void main(String[] args) {
	        Maintenance app = new Maintenance();
	        app.run();
	    }
	}

	class MaintenanceTask {
	    private String description;
	    private boolean completed;

	    public MaintenanceTask(String description) {
	        this.description = description;
	        this.completed = false;
	    }

	    public String getDescription() {
	        return description;
	    }

	    public boolean isCompleted() {
	        return completed;
	    }

	    public void setCompleted(boolean completed) {
	        this.completed = completed;
	    }
	}

