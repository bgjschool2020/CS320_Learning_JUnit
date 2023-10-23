public class Task {
    private String _taskId;
    private String _name;
    private String _description;

    private boolean taskIdValidation(String taskId) {
        return taskId.length() > 10 || taskId == null;
    }

    private boolean nameValidation(String name) {
        return name.length() > 20 || name == null;
    }

    private boolean descriptionValidation(String description) {
        return description.length() > 50 || description == null;
    }


    public Task( String taskId,
                 String name,
                 String description ) {

        if ( taskIdValidation(taskId) ) {
            throw new IllegalArgumentException("Task ID is invalid!");
        }

        if ( nameValidation(name) ) {
            throw new IllegalArgumentException("Name is invalid");
        }

        if ( descriptionValidation(description) ) {
            throw new IllegalArgumentException("Description is invalid");
        }


        // I put these here instead of setters because a Constructor is used to set the initial value of fields. Calling other functions within it may cause unwanted results.
        this._taskId = taskId;
        this._name = name;
        this._description = description;
    }

    public String get_taskId() {
        return _taskId;
    }

    //commented out because it is not updatable
    /*
    public void set_taskId(String taskId) {
        // added exception here so that it is hit if anything is changed after construction
        if ( !taskIdValidation(taskId) ) {
            throw new IllegalArgumentException("Task ID is invalid!");
        }
        this._taskId = taskId;
    }
    */

    public String get_name() {
        return _name;
    }

    public void set_name(String name) {
        if ( nameValidation(name) ) {
            throw new IllegalArgumentException("Name is invalid");
        }
        this._name = name;
    }

    public String get_description() {
        return _description;
    }

    public void set_description(String description) {
        if ( descriptionValidation(description) ) {
            throw new IllegalArgumentException("Description is invalid");
        }
        this._description = description;
    }
}
