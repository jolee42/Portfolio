import static org.junit.Assert.*;
import org.junit.Test;

public class TaskServiceTest {
	
	@Test
	public void testAddTask() {
		TaskService ts = new TaskService();
		Task task = new Task("11111", "Name", "Description");
		
		ts.addTask(task);
		assertEquals(task, ts.getTask("11111"));
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testAddDuplicateTask() {
		TaskService ts = new TaskService();
		Task task = new Task("11111", "Name", "Description");
		
		ts.addTask(task);
		ts.addTask(task);
	}
	
	@Test
	public void testDeleteTask() {
		TaskService ts = new TaskService();
		Task task = new Task("11111", "Name", "Description");
		
		ts.addTask(task);
		ts.deleteTask("11111");
		assertNull(ts.getTask("11111"));
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testDeleteNonExistentTask() {
		TaskService ts = new TaskService();
		ts.deleteTask("11111");
	}
	
	@Test
	public void testUpdateTaskName() {
		TaskService ts = new TaskService();
		Task task = new Task("11111", "Name", "Description");
		
		ts.addTask(task);
		ts.updateTaskName("11111", "New Task Name");
		assertEquals("New Task Name", ts.getTask("11111").getName());
	}
	
	
	@Test
	public void testUpdateTaskDescription() {
		TaskService ts = new TaskService();
		Task task = new Task("11111", "Name", "Description");
		
		ts.addTask(task);
		ts.updateTaskDescription("11111", "New Task Description");
		assertEquals("New Task Description", ts.getTask("11111").getDescription());
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testUpdateNonExistentTask() {
		TaskService ts = new TaskService();
		
		ts.updateTaskName("11111", "anything");
		ts.updateTaskDescription("12345", "Also anything");
	}
}
