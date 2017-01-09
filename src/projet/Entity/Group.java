package projet.Entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by SMITHE on 13-Dec-16.
 */

@Entity(name = "GroupStudents")
public class Group implements Serializable {
	private static final Integer UNKNOWN_ID_GROUPE = -1;
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private final Integer id_Groupe;
	
	@Column( nullable = false )
	private final String name;
	
	@OneToMany( cascade = CascadeType.PERSIST, mappedBy = "group" )
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
	
	@Override
	public String toString() {
		return name;
	}
}
