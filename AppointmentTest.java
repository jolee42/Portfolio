import org.junit.Test;
import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.*;


public class AppointmentTest {
	
	@Test
	public void testValidAppointment() {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, 1);
		
		Appointment appointment = new Appointment("12345", cal.getTime(), "Normal description.");
		
		assertEquals("12345", appointment.getAppointmentId());
		assertNotNull(appointment.getAppointmentDate());
		assertEquals("Normal description.", appointment.getDescription());
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testInvalidAppointmentId_null() {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, 1);
		
		new Appointment(null, cal.getTime(), "Invalid ID.");
	}
	@Test (expected = IllegalArgumentException.class)
	public void testInvalidAppointmentId_TooLong() {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, 1);
		
		new Appointment("12345645674568765", cal.getTime(), "Invalid ID.");
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testInvalidAppointmentDate_null() {
		new Appointment("12345", null, "Invalid date.");
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testInvalidAppointmentDate_PastDate() {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -1);
		
		new Appointment("12345", cal.getTime(), "Invalid ID.");
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testInvalidDescription_null() {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, 1);
		
		new Appointment("12345", cal.getTime(), null);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testInvalidDescription_TooLong() {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, 1);
		
		new Appointment("12345", cal.getTime(), "This description does not fit the criteria for a description because it includes more than fifty characters... I'm not sure if I hit the threshold yet.");
	}
	
}
