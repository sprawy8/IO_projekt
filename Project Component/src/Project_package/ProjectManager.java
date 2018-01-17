package Project_package;
import java.util.ArrayList;
import java.util.List;

import Project_package.Project;

public class ProjectManager {
	
	//singleton
	private static ProjectManager instance = new ProjectManager();

    private List<Project> projectList;      /** Lista wszystkich projektów */

    /** Constructors */
    public ProjectManager(){
        projectList = new ArrayList<>();
    }
    
    //zwrot instance z singleon
    public static ProjectManager getInstance() {
    	return instance;
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
