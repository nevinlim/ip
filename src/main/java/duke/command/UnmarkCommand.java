package duke.command;

import duke.main.DukeException;
import duke.main.Storage;
import duke.main.Ui;
import duke.main.Tasklist;
import java.io.IOException;

public class UnmarkCommand extends Command {
    private final int taskNum;

    public UnmarkCommand(int taskNum) {
        this.taskNum = taskNum;
    }

    public String execute(Tasklist tasklist, Ui ui, Storage storage) throws IOException, DukeException {
        try {
            int initialSize = tasklist.getTasksNum();
            assert taskNum > 0 && taskNum <= initialSize : "task number must be > 0 and <= to size of tasklist";
            tasklist.markUndone(this.taskNum - 1);
            storage.update(tasklist);
            return ui.printUnmarkTaskMessage(tasklist.getTasks().get(this.taskNum - 1));
        } catch (IndexOutOfBoundsException e) {
            throw new DukeException("☹ OOPS!!! Task number to be unmarked is out of bounds of current list. " +
                    "Please use a task number within current list.");
        }
    }
}