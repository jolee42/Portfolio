import java.util.Date;
public class Appointment {
	private final String appointmentId;
	private final Date appointmentDate;
	private final String description;
	
	public Appointment(String appointmentId, Date appointmentDate, String description) {
		if (appointmentId == null || appointmentId.length() > 10) {
			throw new IllegalArgumentException("Appointment ID must be 10 characters or fewer and non-null");
		}
		if (appointmentDate == null || appointmentDate.before(new Date())) {
			throw new IllegalArgumentException("Appointment date must be non-null and in the future");
		}
		if (description == null || description.length() > 50) {
			throw new IllegalArgumentException("Appiontment description must be non-null and under 50 characters.");
		}
		
		this.appointmentId = appointmentId;
		this.appointmentDate = appointmentDate;
		this.description = description;
	}
	
	public String getAppointmentId() {
		return appointmentId;
	}
	
	public Date getAppointmentDate() {
		return appointmentDate;
	}
	
	public String getDescription() {
		return description;
	}
}
