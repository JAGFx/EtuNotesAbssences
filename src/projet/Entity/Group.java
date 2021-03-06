package projet.Entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by SMITHE on 13-Dec-16.
 */

@Entity( name = "GroupStudents" )
public class Group implements Serializable {
	private static final Integer UNKNOWN_ID_GROUPE = -1;
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue( strategy = GenerationType.AUTO )
	private final Integer id_Groupe;
	
	@Column( nullable = false )
	private String name;
	
	@OneToMany( cascade = CascadeType.PERSIST, mappedBy = "group" )
	private Set< Student > students;
	
	public Group() {
		this.name = "No name";
		this.id_Groupe = UNKNOWN_ID_GROUPE;
		this.students = new HashSet<>();
	}
	
	public Group( Integer id, String name ) {
		this.id_Groupe = id;
		this.name = name;
		this.students = new HashSet<>();
	}
	
	public Group( Integer id, String name, HashSet< Student > students ) {
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
	
	public void setName( String name ) {
		this.name = name;
	}
	
	public Set< Student > getStudents() {
		return students;
	}
	
	public void setStudents( HashSet< Student > students ) {
		this.students = students;
	}
	
	public void addStudent( Student student ) {
		students.add( student );
	}
	
	@Override
	public String toString() {
		return name;
	}
}
