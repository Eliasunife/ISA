import java.util.Timer;
import java.util.TimerTask;
import java.util.Scanner;

public class Reminder {
    private Timer timer;
    private int remindersRemaining;
    private Scanner scanner;

    public Reminder() {
        timer = new Timer();
        remindersRemaining = 0;
        scanner = new Scanner(System.in);
    }

    public void scheduleReminder(String message, long delay) {
        ReminderTask task = new ReminderTask(message);
        timer.schedule(task, delay);
        remindersRemaining++;
    }

    public void run() {
        if (remindersRemaining == 0) {
            System.out.println("Nessun promemoria da mostrare. Uscita.");
            return;
        }

        System.out.println("L'applicazione di promemoria è in esecuzione.");
        while (remindersRemaining > 0) {
            // Wait for reminders to be displayed
        }

        System.out.println("L'ultimo promemoria è stato mostrato. Uscita.");
    }

    public void addReminder() {
        System.out.print("Inserisci il messaggio del promemoria: ");
        String message = scanner.nextLine();
        System.out.print("Inserisci il ritardo in millisecondi: ");
        long delay = scanner.nextLong();
        scanner.nextLine(); // Consume the newline character

        scheduleReminder(message, delay);
        System.out.println("Promemoria programmato: " + message);
    }

    private class ReminderTask extends TimerTask {
        private String message;

        public ReminderTask(String message) {
            this.message = message;
        }

        @Override
        public void run() {
            System.out.println("Notifica: " + message);
            remindersRemaining--;
        }
    }

    public static void main(String[] args) {
        Reminder app = new Reminder();

        app.run();

        // Allow adding a reminder during execution
        app.addReminder();
        app.run(); // Continue running after adding a reminder

        app.scanner.close();
        app.timer.cancel();
    }
}

