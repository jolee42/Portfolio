import java.util.HashMap;
import java.util.Map;
public class AppointmentService {
	private final Map<String, Appointment> appointments;
	
	public AppointmentService() {
		appointments = new HashMap();
	}
	
	public void addAppointment(Appointment appointment) {
		if (appointments.containsKey(appointment.getAppointmentId())) {
			throw new IllegalArgumentException("Appointment ID must be unique.");
		}
		appointments.put(appointment.getAppointmentId(), appointment);
	}
	
	public void deleteAppointment(String appointmentId) {
		if (!appointments.containsKey(appointmentId)) {
			throw new IllegalArgumentException("Appointment ID does now exist.");
		}
		appointments.remove(appointmentId);
	}
	
	public Appointment getAppointment(String appointmentId) {
		return appointments.get(appointmentId);
	}
}
