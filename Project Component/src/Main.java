import Project_package.Project;
import ch.makery.shop.ITaskService;
import ch.makery.shop.TaskService;
import ch.makery.shop.model.Task;
import javafx.collections.ObservableList;

public class Main {
    public static void main(String[] args) {

        Project p = new Project("NASA", "Jest to super tajny projekt NASA.");

        p.assignAllTasks();
        p.showTasks();


    }
}
