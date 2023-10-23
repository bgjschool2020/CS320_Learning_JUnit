import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskTest {

    Task defaultTask() {
        return new Task("98765",
                "Do a thing",
                "This is the thing you are supposed to do.");
    }

    @Test
    @DisplayName("Task Constructor Test")
    void test_Task() {
        Task task = defaultTask();

        assertAll(  () -> assertEquals("98765", task.get_taskId()),
                () -> assertEquals("Do a thing", task.get_name()),
                () -> assertEquals("This is the thing you are supposed to do.", task.get_description())
        );
    }

    @Test
    @DisplayName("Invalid Task Constructor Test")
    void test_InvalidContact() {
        assertThrows(IllegalArgumentException.class, () -> { new Task("98765",
                "This is not a task",
                "This task is a task that you are not supposed to do, if you do it you may die a painful and horrible death."); });
    }

    //////////////////
    /// Good Tests ///
    //////////////////
    @Test
    void test_set_name() {
        Task task = defaultTask();

        task.set_name("New Task");
        assertEquals("New Task", task.get_name());
    }

    @Test
    void test_set_description() {
        Task task = defaultTask();

        task.set_description("This is the new thing you are supposed to do.");
        assertEquals("This is the new thing you are supposed to do.", task.get_description());
    }


    //////////////////
    /// Null Tests ///
    //////////////////
    @Test
    void test_set_null_name() {
        Task task = defaultTask();

        assertThrows(NullPointerException.class, () -> task.set_name(null) );
    }

    @Test
    void test_set_null_description() {
        Task task = defaultTask();

        assertThrows(NullPointerException.class, () -> task.set_description(null) );
    }


    /////////////////
    /// Bad Tests ///
    /////////////////
    @Test
    void test_set_bad_name() {
        Task task = defaultTask();

        assertThrows(IllegalArgumentException.class, () -> {task.set_name("I don't like this task so I am going to purposefully throw this name"); });
    }

    @Test
    void test_set_bad_description() {
        Task task = defaultTask();

        assertThrows(IllegalArgumentException.class, () -> {task.set_name("In order to 'pass' this test I need to be longer than 50 characters."); });
    }
}