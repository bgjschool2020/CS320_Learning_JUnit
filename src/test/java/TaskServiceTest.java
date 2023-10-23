import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskServiceTest {
    @AfterEach
    void clearAll() {
        TaskService.Tasks.clear();
    }

    private final String _name = "Do a thing";
    private final String _description = "This is the thing you are supposed to do.";

    @Test
    @DisplayName("Add a new task test")
    void test_addTask() {
        TaskService taskTest = new TaskService();
        taskTest.addTask(_name, _description);

        assertAll(
                () -> assertEquals("0", TaskService.Tasks.get(0).get_taskId()),
                () -> assertEquals("Do a thing", TaskService.Tasks.get(0).get_name()),
                () -> assertEquals("This is the thing you are supposed to do.", TaskService.Tasks.get(0).get_description())
        );
    }

    @Test
    void test_deleteTask() {
        TaskService taskTest = new TaskService();
        taskTest.addTask(_name, _description);

        taskTest.deleteTask("0");

        assertTrue(TaskService.Tasks.isEmpty());
    }

    @Test
    void test_updateName() {
        TaskService taskTest = new TaskService();
        taskTest.addTask(_name, _description);

        // Before change check
        assertEquals(_name, TaskService.Tasks.get(0).get_name());

        String name = "New thing";
        taskTest.updateName("0", name);

        // After change check
        assertEquals(name, TaskService.Tasks.get(0).get_name());
    }

    @Test
    void test_updateDescription() {
        TaskService taskTest = new TaskService();
        taskTest.addTask(_name, _description);

        // Before change check
        assertEquals(_description, TaskService.Tasks.get(0).get_description());

        String description = "This is a new description";
        taskTest.updateDescription("0", description);

        // After change check
        assertEquals(description, TaskService.Tasks.get(0).get_description());
    }
}