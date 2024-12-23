import org.junit.Test;
import java.util.Calendar;

import static org.junit.Assert.*;

public class AppointmentServiceTest {
	@Test
	public void testAddAppointment() {
		AppointmentService ap = new AppointmentService();
		
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, 1);
		Appointment appointment = new Appointment("12345", cal.getTime(), "Valid description.");
		
		ap.addAppointment(appointment);
		Appointment retrieved = ap.getAppointment("12345");
		
		assertNotNull(retrieved);
		assertEquals("12345", retrieved.getAppointmentId());
		assertEquals("Valid description.", retrieved.getDescription());
	}
	
	@Test
	public void testDeleteAppointment() {
		AppointmentService ap = new AppointmentService();
		
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, 1);
		Appointment appointment = new Appointment("12345", cal.getTime(), "Valid description.");
		
		ap.addAppointment(appointment);
		ap.deleteAppointment("12345");
		
		assertNull(ap.getAppointment("12345"));
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testDuplicateAppointment() {
		AppointmentService ap = new AppointmentService();
		
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, 1);
		Appointment appointment = new Appointment("12345", cal.getTime(), "Valid description.");
		
		ap.addAppointment(appointment);
		ap.addAppointment(new Appointment("12345", cal.getTime(), "A different valid description."));
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testDeleteNonexistentAppointment() { 
		AppointmentService ap = new AppointmentService();
		
		ap.deleteAppointment("12345");
	}
	
	
	
}
