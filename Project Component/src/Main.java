import java.util.Scanner;

import Project_package.Project;
import Project_package.ProjectManager;

public class Main {
    public static void main(String[] args) {

        Project p = new Project("NASA", "Jest to super tajny projekt NASA.");
        ProjectManager manager = new ProjectManager();
        Scanner sc = new Scanner(System.in);
        
        p.assignTask(0,2);
        p.assignTask(1,2);
        p.assignTask(2,3);
        p.assignTask(3);
        
        int wybor = -1;
        int wybor2 = -1;
        int tid = -1;
        int uid = -1;
        String login = "";
        
        //p.assignAllTasks();
        
        do{
        	System.out.println("Projekt: " + p.getProjectName() + "\n");
        	System.out.println("1. Zaloguj sie");
        	System.out.println("0. Wyjscie");
        	
        	wybor = sc.nextInt();
        	sc.nextLine();
        		
        	if(wybor == 1){
        		System.out.println("Podaj login: ");
        		login = sc.nextLine();
        		
        		do{
        			System.out.println("\nZalogowany jako: " + login);
        			System.out.println("*********************************");
	        		System.out.println("1. Pokaz moje zadania");
	        		System.out.println("2. Pokaz wszystkie zadania");
	        		System.out.println("3. Pokaz wszystkich uzytkownikow");
	        		
	        		if(login.equals("Kovalsky")){	
		        		System.out.println("4. Pokaz kto co robi");
		        		System.out.println("5. Przydziel zadania");
	        		}
	        		
	        		System.out.println("0. Wroc");
	        		System.out.println("*********************************");
	        		
	        		wybor2 = sc.nextInt();
	        		sc.nextLine();
	        		
	        		switch(wybor2){
	        		case 1:
	        			p.showTaskUser(login);
	        			continue;
	        			
	        		case 2:
	        			p.showTasks();
	        			continue;
	        			
	        		case 3:
	        			p.showUsers();
	        			continue;
	        		
	        		case 4:
	        			if(!login.equals("Kovalsky")) continue;
	        			
	        			p.showTaskUser();
	        			
	        			continue;
	        			
	        		case 5:
	        			if(!login.equals("Kovalsky")) continue;
	        			
	        			p.showTaskUser();
	        			System.out.println();
	        			p.showUsers();
	        			System.out.println();
	        			p.showTasks();
	        			System.out.println();
	        			
	        			System.out.println("Podaj ID zadania: ");
	        			tid = sc.nextInt();
	        			sc.nextLine();
	        			
	        			System.out.println("Podaj ID uzytkownika: ");
	        			uid = sc.nextInt();
	        			sc.nextLine();
	        			
	        			p.assignTask(tid, uid);
	        			
	        			continue;	
	        			
	        		default:	
	        			
	        		}
	        		
	        		
        		}while(wybor2 != 0);
        	}
        	
        	// p.showTasks();
             //p.showTaskUser();
             
             
        }while(wybor != 0);
       
        
        manager.addProject(p);
        
    }
}