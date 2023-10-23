import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class AppointmentTest {
    Appointment defaultAppointment() {
        return new Appointment("123454321",
                "2023-10-31",
                "Halloween, get treats for Bryce." );
    }

    @Test
    @DisplayName("Appointment Constructor Test")
    void test_Appointment(){
        Appointment appointment = defaultAppointment();

        LocalDate LD_appointmentDate = LocalDate.parse("2023-10-31");
        assertAll(
                () -> assertEquals("123454321", appointment.get_appointmentId()),
                () -> assertEquals(LD_appointmentDate, appointment.get_appointmentDate()),
                () -> assertEquals("Halloween, get treats for Bryce.", appointment.get_description())
        );
    }


}