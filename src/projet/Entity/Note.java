package projet.Entity;

import projet.Entity.PK.NotePK;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by emsm on 08/01/2017.
 */

@Entity
//@IdClass(NotePK.class)
//@Table
public class Note implements Serializable {
	private static final long serialVersionUID = 1L;
	@Column( nullable = false )
	float value;
	@Id
	@GeneratedValue( strategy = GenerationType.AUTO )
	private int id_note;
	@ManyToOne( cascade = { CascadeType.MERGE, CascadeType.PERSIST }, optional = false )
	private Student student;
	
	public float getValue() {
		return value;
	}
	
	public void setValue( float value ) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return Float.toString( value );
	}
	
	public Student getStudent() {
		return student;
	}
	
	public void setStudent( Student student ) {
		this.student = student;
	}
	
	public int getId_note() {
		return id_note;
	}
	
	public void setId_note( int id_note ) {
		this.id_note = id_note;
	}
}
