package duke.command;

import duke.DukeException;
import duke.task.Task;

/**
 * The command to remove a task from the task list.
 */
public class RemoveTaskCommand extends Command {
    private final int index;

    public RemoveTaskCommand(int index) {
        this.index = index;
    }

    @Override
    public String execute() throws DukeException {
        if (index >= taskList.getSize()) {
            throw new DukeException("Task number is out of range!");
        }
        Task removedTask = taskList.deleteTask(index);
        return ui.printTaskDeleted(removedTask, taskList.getSize());
    }

    @Override
    public String toString() {
        return String.format("RemoveTaskCommand{index=%d}", index);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof RemoveTaskCommand) {
            return index == ((RemoveTaskCommand) obj).index;
        }
        return false;
    }

}
