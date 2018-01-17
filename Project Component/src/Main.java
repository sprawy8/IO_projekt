import Project_package.Project;
import Project_package.ProjectManager;
import ch.makery.shop.ITaskService;
import ch.makery.shop.TaskService;
import ch.makery.shop.model.Task;
import javafx.collections.ObservableList;

public class Main {
    public static void main(String[] args) {

        Project p = new Project("NASA", "Jest to super tajny projekt NASA.");
        ProjectManager manager = new ProjectManager();
        p.assignTask(0,2);
        p.assignTask(1,2);
        p.assignTask(2,3);
        p.assignTask(3,1);
        
        int wybor = -1;
        
        //p.assignAllTasks();
        p.showTasks();
        p.showTaskUser();
        
        manager.addProject(p);
        
    }
}