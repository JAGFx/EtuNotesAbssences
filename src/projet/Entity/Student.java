package projet.Entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
public class Student implements Serializable {
	private static final Integer UNKNOWN_ID_STUDENT = -1;
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue( strategy = GenerationType.AUTO )
	private final Integer stud_id;
	
	@Column( nullable = false )
	private String firstname;
	
	@Column( nullable = false )
	private String lastname;
	
	@ManyToOne( cascade = { CascadeType.MERGE } )
	private Group group;
	
	@OneToMany( cascade = CascadeType.ALL, mappedBy = "student" )
	private Collection< Note > notes;
	
	@OneToMany( cascade = CascadeType.ALL, mappedBy = "student" )
	private Collection< Absence > absences;
	
	public Student() {
		super();
		stud_id = UNKNOWN_ID_STUDENT;
		notes = new ArrayList<>();
		absences = new ArrayList<>();
	}
	
	public Student( Integer stud_id, String firstname, String lastname ) {
		super();
		this.stud_id = stud_id;
		this.firstname = firstname;
		this.lastname = lastname;
	}
	
	public Integer getId() {
		return stud_id;
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
	
	public Group getGroup() {
		return group;
	}
	
	public void setGroup( Group group ) {
		this.group = group;
	}
	
	public Collection< Note > getNotes() {
		return notes;
	}
	
	public void setNotes( Collection< Note > notes ) {
		this.notes = notes;
	}
	
	public void addNote( Note note ) {
		notes.add( note );
	}
	
	public Collection< Absence > getAbsences() {
		return absences;
	}
	
	public void setAbsences( Collection< Absence > absences ) {
		this.absences = absences;
	}
	
	public String getAverage() {
		float totalNote = 0.0f;
		int totalGradingScale = 0;
		
		for ( Note note : notes ) {
			totalNote += note.getValue() * note.getCoef();
			totalGradingScale += note.getGraddingScale() * note.getCoef();
		}
		
		return ( float ) Math.round( ( totalNote / totalGradingScale ) * 20 * 100 ) / 100 + " / 20";
	}
	
	@Override
	public String toString() {
		return firstname + " " + lastname + " < " + group + " >";
	}
}
