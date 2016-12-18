package projet.Model;

import java.util.ArrayList;

public class Student {
	
	private Integer id;
	private String firstname;
	private String lastname;
	
	private ArrayList< Float > noteEtudiant;
	
	public Student() {
		super();
		noteEtudiant = new ArrayList<>();
	}
	
	public Student( Integer id, String firstname, String lastname ) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		noteEtudiant = new ArrayList<>();
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId( Integer id ) {
		this.id = id;
	}
	
	public String getFirstname() {
		return firstname;
	}
	
	public void setFirstname( String firstname ) {
		this.firstname = firstname;
	}
	
	public String getLastname() {
		return lastname;
	}
	
	public void setLastname( String lastname ) {
		this.lastname = lastname;
	}
	
	public ArrayList< Float > getNoteEtudiant() {
		return noteEtudiant;
	}
	
	public void setNoteEtudiant( ArrayList< Float > noteEtudiant ) {
		this.noteEtudiant = noteEtudiant;
	}
}
