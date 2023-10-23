import java.util.ArrayList;
import java.util.List;

public class TaskService {
    public static List<Task> Tasks = new ArrayList<Task>();

    int currentUniqueId = 0;

    public void addTask(String name,
                        String description) {
        String currentUniqueIdString = Integer.toString(currentUniqueId);

        Task task = new Task(currentUniqueIdString, name, description);
        Tasks.add(task);

        ++currentUniqueId;
    }

    public void deleteTask (String taskId) {
        Tasks.removeIf(task -> taskId.equals(task.get_taskId()));
    }

    public void updateName (String taskId, String name) {
        for (Task task : Tasks) {
            if (taskId.equals(task.get_taskId())) {
                task.set_name(name);
            } else {
                throw new IllegalArgumentException("There is no such Task Name!");
            }
        }
    }

    public void updateDescription (String taskId, String description) {
        for (Task task : Tasks) {
            if (taskId.equals(task.get_taskId())) {
                task.set_description(description);
            } else {
                throw new IllegalArgumentException("There is no such Description!");
            }
        }
    }
}
