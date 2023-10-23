import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class AppointmentServiceTest {
    @AfterEach
    void clearAll() {
        AppointmentService.Appointments.clear();
    }

    private final String _appointmentDate = "2023-12-31";
    private final String _description = "New Years Eve Party @ Jessica's, bring cake";
    @Test
    @DisplayName("Adding an appointment test")
    void test_addAppointment() {
        AppointmentService appointmentTest = new AppointmentService();
        appointmentTest.addAppointment(_appointmentDate, _description);
        LocalDate LD_appointmentDate = LocalDate.parse(_appointmentDate);


        assertAll(
                () -> assertEquals(LD_appointmentDate, AppointmentService.Appointments.get(0).get_appointmentDate()),
                () -> assertEquals("New Years Eve Party @ Jessica's, bring cake", AppointmentService.Appointments.get(0).get_description())
        );
    }

    @Test
    @DisplayName("Deleting an appointment test")
    void test_deleteAppointment() {
        AppointmentService appointmentTest = new AppointmentService();
        appointmentTest.addAppointment(_appointmentDate, _description);

        appointmentTest.deleteAppointment("0");

        assertTrue(AppointmentService.Appointments.isEmpty());
    }
}