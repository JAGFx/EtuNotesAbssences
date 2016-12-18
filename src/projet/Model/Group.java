package projet.Model;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by SMITHE on 13-Dec-16.
 */
public class Group {
	private static final Integer UNKNOWN_ID_GROUPE = -1;
	
	private final Integer id_Groupe;
	private final String name;
	private Collection< Student > students;
	
	public Group() {
		this.name = "No name";
		this.id_Groupe = UNKNOWN_ID_GROUPE;
		this.students = new ArrayList<>();
	}
	
	public Group( Integer id, String name ) {
		this.id_Groupe = id;
		this.name = name;
		this.students = new ArrayList<>();
	}
	
	public Group( Integer id, String name, Collection< Student > students ) {
		this.id_Groupe = id;
		this.name = name;
		this.students = students;
	}
	
	public Integer getId() {
		return id_Groupe;
	}
	
	public String getName() {
		return name;
	}
	
	public Collection< Student > getStudents() {
		return students;
	}
	
	public void setStudents( Collection< Student > students ) {
		this.students = students;
	}
}
