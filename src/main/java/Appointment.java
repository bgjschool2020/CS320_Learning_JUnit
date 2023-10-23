// Used this instead of java.util.Date because util.Date is now deprecated.
import java.time.LocalDate;

public class Appointment {
    private final String _appointmentId;
    private final LocalDate _appointmentDate;
    private final String _description;

    /**
     * @param appointmentId the appointment ID is a unique identifier of each appointment in the list, it is set in the AppointmentServices Class.
     * @return whether the appointment id is greater than 10 characters or not OR if it is null (which is redundant as it cant ever be null without specifically setting it to be so, but it is included to be explicit).
     */
    private boolean apptIdValidation(String appointmentId) {
        return appointmentId.length() > 10 || appointmentId == null;
    }

    /**
     * @param appointmentDate is the date of an appointment
     * @return whether the appointment date is before the current date or not OR if it is null (which is redundant as it cant ever be null without specifically setting it to be so, but it is included to be explicit).
     */
    private boolean apptDateValidation(LocalDate appointmentDate) {
        return appointmentDate.isBefore(LocalDate.now()) || appointmentDate == null;
    }

    /**
     * @param description A description of the appointment
     * @return whether the description is greater than 50 characters or not OR if it is null (which is redundant as it cant ever be null without specifically setting it to be so, but it is included to be explicit).
     */
    private boolean descriptionValidation(String description) {
        return description.length() > 50 || description == null;
    }

    // Constructor
    public Appointment(String appointmentId,
                       String appointmentDate,
                       String description) {

        if (apptIdValidation(appointmentId)) {
            throw new IllegalArgumentException("Appointment ID is invalid!");
        }

        LocalDate LD_appointmentDate = LocalDate.parse(appointmentDate);
        if (apptDateValidation(LD_appointmentDate)) {
            throw new IllegalArgumentException("Appointment Date is invalid!");
        }

        if (descriptionValidation(description)) {
            throw new IllegalArgumentException("Description is invalid!");
        }


        // I put these here instead of setters because a Constructor is used to set the initial value of fields. Calling other functions within it may cause unwanted results.
        this._appointmentId = appointmentId;
        //System.out.println(LD_appointmentDate);
        this._appointmentDate = LD_appointmentDate;
        this._description = description;
    }


    // getters and setters
    public String get_appointmentId() {
        return _appointmentId;
    }
    /* No set_appointmentID as it should not ever be updated. */

    public LocalDate get_appointmentDate() {
        return _appointmentDate;
    }

    // not strictly necessary as it is not a requirement to change dates
    /*
    public void set_appointmentDate(String appointmentDate) {
        LocalDate LD_appointmentDate = LocalDate.parse(appointmentDate);
        if (apptDateValidation(LD_appointmentDate)) {
            throw new IllegalArgumentException("Appointment Date is invalid!");
        }

        this._appointmentDate = LD_appointmentDate;
    }
     */

    public String get_description() {
        return _description;
    }

    // not strictly necessary as it is not a requirement to change descriptions
    /*
    public void set_description(String description) {
        if (descriptionValidation(description)) {
            throw new IllegalArgumentException("Description is invalid!");
        }
        this._description = description;
    }
     */
}
