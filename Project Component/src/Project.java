import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Project {

    private String projectName;         /** Nazwa projektu */
    private String projectDetails;      /** Szczegóły (opis, deadline itd. itp.) */
    private Map<Integer, Integer> taskUserMap;  /** Mapa przechowująca ID zadania i ID użytkownika odpowiedzialnego za to zadanie
                                                 * Task = key, zadania nie powtarzają się
                                                 * User = value, użytkownicy mogą się powtarzać (jeden robi kilka zadań)
                                                 */
    /** Constructors */
    public Project() {
        this.projectName = "emptyProject";
        this.projectDetails = "emptyProject";
        taskUserMap = new HashMap<>();
    }

    public Project(String projectName, String projectDetails) {
        this.projectName = projectName;
        this.projectDetails = projectDetails;
        taskUserMap = new HashMap<>();
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
     * Metoda wypisująca ID zadań przypisanych do danego projektu
     */
    public void showTasks(){
        System.out.println("tID");
        Set<Integer> tasksSet = taskUserMap.keySet();
        for(Integer taskId : tasksSet){
            System.out.println(taskId);
        }
    }

    /**
     * Metoda wypisująca ID zadań i ID użytkowników odpowiedzialnych za dane zadanie
     */
    public void showTaskUser(){
        System.out.println("tID \t uID");
        Set<Map.Entry<Integer,Integer>> entrySet = taskUserMap.entrySet();
        for(Map.Entry<Integer, Integer> entry: entrySet) {
            System.out.println(entry.getKey() + "\t : \t " + entry.getValue());
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
