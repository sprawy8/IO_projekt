package Project_package;

import Project_package.Project;

import java.util.ArrayList;
import java.util.List;

public class ProjectManager {

    private List<Project> projectList;      /** Lista wszystkich projektów */

    /** Constructors */
    public ProjectManager(){
        projectList = new ArrayList<>();
    }

    /** Metoda odpowiedzialna za dodawanie projektu do managera */
    public void addProject(Project p){
        projectList.add(p);
    }

    public List<Project> getProjectList(){

        return this.projectList;
    }
    public Project getProjectByID(int ID){

        return projectList.get(ID);
    }
}
