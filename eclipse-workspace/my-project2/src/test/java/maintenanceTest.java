
import org.junit.Test;

import static org.junit.Assert.*;

public class maintenanceTest {
    @Test
    public void testAddActivity() {
        maintenance maintenanceClass = new maintenance();
        maintenanceClass.addActivity("Oil Change");
        assertTrue(maintenanceClass.checkUncompletedActivities().contains("Oil Change"));
    }

    @Test
    public void testMarkActivityCompleted() {
        maintenance maintenanceClass = new maintenance();
        maintenanceClass.addActivity("Fix Leak");
        maintenanceClass.markActivityCompleted("Fix Leak");
        assertFalse(maintenanceClass.checkUncompletedActivities().contains("Fix Leak"));
    }
}
