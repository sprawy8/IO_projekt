package Project_package;

public class Usertest {
	int ID;
	String nazwisko;
	String stanowisko;
	
	public Usertest(int ID, String name, String st){
		this.ID = ID;
		this.nazwisko = name;
		this.stanowisko = st;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getNazwisko() {
		return nazwisko;
	}
	public void setNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}
	public String getStanowisko() {
		return stanowisko;
	}
	public void setStanowisko(String stanowisko) {
		this.stanowisko = stanowisko;
	}
	
	

}
