package Project_package;

import ch.makery.shop.ITaskService;
import ch.makery.shop.TaskService;
import ch.makery.shop.model.Task;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Set;

import JavaMasters.IO.User;
import JavaMasters.IO.UsersManager;



public class Project {

    private String projectName;         /** Nazwa projektu */
    private String projectDetails;      /** Szczegóły (opis, deadline itd. itp.) */
    private Map<Integer, Integer> taskUserMap;  /** Mapa przechowująca ID zadania i ID użytkownika odpowiedzialnego za to zadanie
                                                 * Task = key, zadania nie powtarzają się
                                                * User = value, użytkownicy mogą się powtarzać (jeden robi kilka zadań)
                                                  */
    private List<Usertest> userlist;
    /** TASK */
    ObservableList<Task> tasksList;
    ITaskService iTask;
    
    /** USER */
    ObservableList<User> usersList;
    UsersManager manager;
    User user;
    
    
    /** Constructors */
    public Project() {
        this.projectName = "emptyProject";
        this.projectDetails = "emptyProject";
        taskUserMap = new HashMap<>();

        
        iTask = new TaskService();
        tasksList = iTask.getTaskList();
        
        userlist = new ArrayList<>();
      //  usersList = (ObservableList<User>) manager.getAllUsers();
        
    }

    public Project(String projectName, String projectDetails) {
        this.projectName = projectName;
        this.projectDetails = projectDetails;
        taskUserMap = new HashMap<>();

        iTask = new TaskService();
        tasksList = iTask.getTaskList();
        
       // usersList = (ObservableList<User>) manager.getAllUsers();
        userlist = new ArrayList<>();
        userlist.add(new Usertest(0, "Kovalsky"));
        userlist.add(new Usertest(1, "Mak�owicz"));
        userlist.add(new Usertest(2, "Banach"));
        userlist.add(new Usertest(3, "Ive"));
        userlist.add(new Usertest(4, "Bastiat"));
        
    }

    /**
     * Metoda odpowiedzialna za dodawanie zadan i odpowiedzialnych za nie użytkowników do mapy
     * @param taskId Id zadania, przechowywane w klasie Zadania
     * @param userId Id użytkownika, przechowywane w klasie Użytkownicy
     */
    public void assignTask(Integer /*int?*/ taskId, Integer /*int?*/ userId ){
        taskUserMap.put(taskId, userId);
    }

    /**
     * Druga wersja powyższej metody, gdzie dostajemy tylko ID zadania, a użytkownik odpowiedzialny za rozwiązanie nie
     * został jeszcze przydzielony.
     */
    public void assignTask(Integer /*int?*/ taskId){
        taskUserMap.put(taskId, null);
    }

    /**
     * Dodaje wszystkie zadania do mapy
     */
    public void assignAllTasks(){
        for(Task t : tasksList){
            taskUserMap.put(t.getID(), null);
        }
    }

    /**
     * Metoda wypisująca ID zadań przypisanych do danego projektu
     */
    public void showTasks(){
        System.out.println("Projekt: " + projectName);
        System.out.println("Zadania:");

        Set<Integer> tasksSet = taskUserMap.keySet(); /** Pobieram z mapy projektu wszystkie ID zadań */
        Task t; /** pomocniczy task */

        System.out.println("ID \t Nazwa \t Opis \t Termin");

        for(Integer taskId : tasksSet){     /** Petla wykonuje sie dla wszystkich ID z naszej mapy */
            t = tasksList.get(taskId);      /** Pobieram task z listy tasków */
            System.out.println(t.getID() + "\t" + t.getTitle() + "\t" + t.getDescription() + "\t" + t.getDueDate()); /** Wypisuje co trzeba */
        }
    }

    /**
     * Metoda wypisująca ID zadań i ID użytkowników odpowiedzialnych za dane zadanie
     */
    public void showTaskUser(){
        System.out.println("tID \t uID \t Nazwisko");
        Set<Map.Entry<Integer,Integer>> entrySet = taskUserMap.entrySet();
        for(Map.Entry<Integer, Integer> entry: entrySet) {
            System.out.println(entry.getKey() + "\t " + entry.getValue() + "\t  " + userlist.get(entry.getValue()).getNazwisko());
        }
    }

    /** Getters and setters */
    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectDetails() {
        return projectDetails;
    }

    public void setProjectDetails(String projectDetails) {
        this.projectDetails = projectDetails;
    }
}
