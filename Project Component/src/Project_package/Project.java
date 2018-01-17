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
        userlist.add(new Usertest(0, "Kovalsky", "Kierownik Projektu"));
        userlist.add(new Usertest(1, "Maklowicz", "Programista"));
        userlist.add(new Usertest(2, "Kalafior", "Programista"));
        userlist.add(new Usertest(3, "Renekton", "Programista"));
        userlist.add(new Usertest(4, "Bastiat", "Tester"));
        
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

        Set<Integer> tasksSet = taskUserMap.keySet(); /** Pobieram z mapy projektu wszystkie ID zadań */
        Task t; /** pomocniczy task */

        System.out.println("ID \t Nazwa \t Opis \t Termin");
        System.out.println("--------------------------------------");

        for(Integer taskId : tasksSet){     /** Petla wykonuje sie dla wszystkich ID z naszej mapy */
            t = tasksList.get(taskId);      /** Pobieram task z listy tasków */
            System.out.println(t.getID() + "\t " + t.getTitle() + "\t " + t.getDescription() + "\t " + t.getDueDate()); /** Wypisuje co trzeba */
        }
    }

    /**
     * Metoda wypisująca ID zadań i ID użytkowników odpowiedzialnych za dane zadanie
     */
    public void showTaskUser(){
        System.out.println("ID zadania \t Uzytkownik");
        System.out.println("--------------------------------------");
        Set<Map.Entry<Integer,Integer>> entrySet = taskUserMap.entrySet();
        for(Map.Entry<Integer, Integer> entry: entrySet) {
        	if(entry.getValue() != null)
            System.out.println(entry.getKey() + " \t\t " + userlist.get(entry.getValue()).getNazwisko());
        	else
        	System.out.println(entry.getKey() + " \t\t " + "NIE PRZYDZIELONO!");	
        }
    }
    
    public void showTaskUser(String login){
    	int licznik = 0;
    	System.out.println("ID \t Nazwa \t Opis \t Termin");
    	 System.out.println("--------------------------------------");
        Set<Map.Entry<Integer,Integer>> entrySet = taskUserMap.entrySet();
        for(Map.Entry<Integer, Integer> entry: entrySet) {
        	if(entry.getValue() != null && userlist.get(entry.getValue()).getNazwisko().equals(login)){
        		System.out.println(tasksList.get(entry.getKey()).getID() + "\t " + tasksList.get(entry.getKey()).getTitle() + "\t " + tasksList.get(entry.getKey()).getDescription() + "\t " + tasksList.get(entry.getKey()).getDueDate());
        		licznik++;
        	}
        }
        if(licznik == 0) System.out.println("Brak zadan!");
    }
    
    public void showUsers(){
    	System.out.println("ID \t Nazwisko \t Stanowisko");
    	 System.out.println("--------------------------------------");
    	for(Usertest t : userlist){
    		System.out.println(t.getID()+ "\t " + t.getNazwisko() + "\t " + t.getStanowisko());;
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
