package projet.Model;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by SMITHE on 13-Dec-16.
 */
public class Groupe {
	private static final Integer UNKNOWN_ID_GROUPE = -1;
	
	private final Integer id_Groupe;
	private final String name;
	private Collection< Etudiant > etudiants;
	
	public Groupe() {
		this.name = "No name";
		this.id_Groupe = UNKNOWN_ID_GROUPE;
		this.etudiants = new ArrayList<>();
	}
	
	public Groupe( Integer id, String name ) {
		this.id_Groupe = id;
		this.name = name;
		this.etudiants = new ArrayList<>();
	}
	
	public Groupe( Integer id, String name, Collection< Etudiant > etudiants ) {
		this.id_Groupe = id;
		this.name = name;
		this.etudiants = etudiants;
	}
	
	public Integer getId() {
		return id_Groupe;
	}
	
	public String getName() {
		return name;
	}
	
	public Collection< Etudiant > getEtudiants() {
		return etudiants;
	}
	
	public void setEtudiants( Collection< Etudiant > etudiants ) {
		this.etudiants = etudiants;
	}
}
