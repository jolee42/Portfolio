import static org.junit.Assert.*;
import org.junit.Test;

public class ContactServiceTest {
	
	@Test
	public void testAddContact() {
		ContactService service = new ContactService();
		Contact contact = new Contact("Billy T", "Bill", "Thompson", "1112223333", "5 Somewhere rd");
		service.addContact(contact);
		assertEquals(contact, service.getContact("Billy T"));
	}
	
	@Test
	public void testDeleteContact() {
		ContactService service = new ContactService();
		Contact contact = new Contact("Billy T", "Bill", "Thompson", "1112223333", "5 Somewhere rd");
		service.addContact(contact);
		service.deleteContact("Billy T");
		assertNull(service.getContact("Billy T"));
	}
	
	@Test
	public void testUpdateContact() {
		ContactService service = new ContactService();
		Contact contact = new Contact("Billy T", "Bill", "Thompson", "1112223333", "5 Somewhere rd");
		service.addContact(contact);
		service.updateContact("Billy T", "William", "Thomas", "2223334444", "6 Someplace blvd");
		Contact updated = service.getContact("Billy T");
		assertEquals("William", updated.getFirstName());
		assertEquals("Thomas", updated.getLastName());
		assertEquals("2223334444", updated.getPhone());
		assertEquals("6 Someplace blvd", updated.getAddress());
	}
	
}

	