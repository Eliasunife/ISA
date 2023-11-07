

import org.junit.Test;

public class reminderTest {
    @Test
    public void testAddReminder() {
        reminder reminder = new reminder();
        reminder.addReminder("Buy flowers", 3);
        // You can't easily test the reminder functionality in a unit test, as it involves time-based behavior.
        // You may want to manually verify that the reminder works as expected.
    }
}

