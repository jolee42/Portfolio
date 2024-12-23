import static org.junit.Assert.*;
import org.junit.Test;

public class ContactTest {
	@Test 
	public void testContactCreation() {
		Contact contact = new Contact("Billy T", "William", "Thomas", "2223334444", "6 Someplace blvd");
		assertEquals("William", contact.getFirstName());
		assertEquals("Thomas", contact.getLastName());
		assertEquals("2223334444", contact.getPhone());
		assertEquals("6 Someplace blvd", contact.getAddress());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testInvalidContactId() {
		new Contact(null, "William", "Thomas", "2223334444", "6 Someplace blvd");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testInvalidFirstName() {
		new Contact("Billy T", null, "Thomas", "2223334444", "6 Someplace blvd");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testInvalidLastName() {
		new Contact("Billy T", "William", null, "2223334444", "6 Someplace blvd");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testInvalidPhone() {
		new Contact("Billy T", "William", "Thomas", null, "6 Someplace blvd");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testInvalidAddress() {
		new Contact("Billy T", "William", "Thomas", "2223334444", null);
	}
}
