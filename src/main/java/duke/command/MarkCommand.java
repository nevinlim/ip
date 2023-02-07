package duke.command;

import duke.main.DukeException;
import duke.main.Storage;
import duke.main.Tasklist;
import duke.main.Ui;
import java.io.IOException;

public class MarkCommand extends Command {
    private final int taskNum;

    public MarkCommand(int taskNum) {
        this.taskNum = taskNum;
    }

    public String execute(Tasklist tasklist, Ui ui, Storage storage) throws IOException, DukeException {
        try {
            tasklist.markDone(this.taskNum - 1);
            storage.update(tasklist);
            return ui.printMarkTaskMessage(tasklist.getTasks().get(this.taskNum - 1));
        } catch (IndexOutOfBoundsException e) {
        throw new DukeException("☹ OOPS!!! Task number to be unmarked is out of bounds of current list. " +
                "Please use a task number within current list.");
    }
    }
}