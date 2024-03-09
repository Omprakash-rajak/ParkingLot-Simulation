package MultiParkingLot;

import java.util.ArrayList;
import java.util.LinkedHashSet;

public class Admin {

	private String email=null;
	private String password=null;
	
	ArrayList a = new ArrayList();
	
	public Admin(String email, String password) {
		
		this.email = email;
		this.password = password;
		a.add(email);
	a.add(password);
	}
	
	public Admin() {
		// TODO Auto-generated constructor stub
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public ArrayList getA() {
		return a;
	}

	public void setA(ArrayList a) {
		this.a = a;
	}

	
	
	
	
}
