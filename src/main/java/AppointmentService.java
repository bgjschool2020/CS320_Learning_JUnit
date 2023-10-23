import java.util.ArrayList;
import java.util.List;


public class AppointmentService {
    public static List<Appointment> Appointments = new ArrayList<Appointment>();

    int currentUniqueId = 0;

    /**
     * Adds an appointment to the Appointments list
     * @param aptDate appointment Date
     * @param description description of the appointment
     */
    public void addAppointment(String aptDate,
                               String description) {
        String currentUniqueIdString = Integer.toString(currentUniqueId);

        Appointment appointment = new Appointment(currentUniqueIdString, aptDate, description);
        Appointments.add(appointment);

        ++currentUniqueId;
    }

    /**
     * Deletes an appointment from the Appointments list.
     * @param appointmentId the appointment ID is a unique identifier of each appointment in the list
     */
    public void deleteAppointment(String appointmentId) {
        Appointments.removeIf(appointment -> appointmentId.equals(appointment.get_appointmentId()));
    }
}
