import java.util.HashMap;
import java.util.Map;

public class TaskService {
	private final Map<String, Task> tasks;
	
	public TaskService() {
		this.tasks = new HashMap<String, Task>();
	}
	
	public void addTask(Task task) {
		if (tasks.containsKey(task.getTaskId())) {
			throw new IllegalArgumentException("Task ID must be unique.");
		}
		tasks.put(task.getTaskId(), task);
	}
	
	public void deleteTask(String taskId) {
		if (!tasks.containsKey(taskId)) {
			throw new IllegalArgumentException("Task ID not found.");
		}
		
		tasks.remove(taskId);
	}
	
	public void updateTaskName(String taskId, String newName) {
		if (!tasks.containsKey(taskId)) {
			throw new IllegalArgumentException("Task ID not found.");
		}
		tasks.get(taskId).setName(newName);
	}
	
	public void updateTaskDescription(String taskId, String newDescription) {
		if (!tasks.containsKey(taskId)) {
			throw new IllegalArgumentException("Task ID not found.");
		}
		tasks.get(taskId).setDescription(newDescription);
	}
	
	public Task getTask(String taskId) {
		return tasks.get(taskId);
	}
}
