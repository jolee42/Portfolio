import static org.junit.Assert.*;
import org.junit.Test;

public class TaskTest {
	@Test
	public void testValidTaskCreation() {
		Task task = new Task("11111", "Test Task", "Makeshift Description");
		assertEquals("11111", task.getTaskId());
		assertEquals("Test Task", task.getName());
		assertEquals("Makeshift Description", task.getDescription());
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testInvalidID() {
		new Task(null, "Proper", "Task Description" );
		new Task("Too Long For TaskID", "Proper", "Task Description" );
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testInvalidName() {
		new Task("11111", null, "Task Description" );
		new Task("11111", "Too long to be Proper", "Task Description" );
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testInvalidDescription() {
		new Task("11111", "Proper", null );
		new Task("11111", "Proper", "Task Description is far too long to fit the under 50 character mark." );
	}
}
