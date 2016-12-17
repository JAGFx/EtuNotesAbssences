package projet.Model;

import java.util.ArrayList;

public class Etudiant {
	
	private Integer id;
	private String prenom;
	private String nom;
	
	private ArrayList< Float > noteEtudiant;
	
	public Etudiant() {
		super();
		noteEtudiant = new ArrayList<>();
	}
	
	public Etudiant( Integer id, String prenom, String nom ) {
		super();
		this.id = id;
		this.prenom = prenom;
		this.nom = nom;
		noteEtudiant = new ArrayList<>();
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId( Integer id ) {
		this.id = id;
	}
	
	public String getPrenom() {
		return prenom;
	}
	
	public void setPrenom( String prenom ) {
		this.prenom = prenom;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void setNom( String nom ) {
		this.nom = nom;
	}
	
	public ArrayList< Float > getNoteEtudiant() {
		return noteEtudiant;
	}
	
	public void setNoteEtudiant( ArrayList< Float > noteEtudiant ) {
		this.noteEtudiant = noteEtudiant;
	}
}
