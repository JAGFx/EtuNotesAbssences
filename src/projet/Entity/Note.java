package projet.Entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by emsm on 08/01/2017.
 */

@Entity
public class Note implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final int GRADING_SCALE = 20;
	private static final int COEF = 1;
	
	@Column( nullable = false )
	private float value;
	
	@Column( nullable = false )
	private int coef = COEF;
	
	@Column( nullable = false )
	private String name;
	
	@Column(nullable = false)
	private int graddingScale = GRADING_SCALE;
	
	@Id
	@GeneratedValue( strategy = GenerationType.AUTO )
	private int id_note;
	
	@ManyToOne( cascade = { CascadeType.MERGE } )
	private Student student;
	
	public float getValue() {
		return value;
	}
	
	public void setValue( float value ) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return getValue() + " / " + getGraddingScale() + " (Coef. " + getCoef() + ")";
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
	
	public int getCoef() {
		return coef;
	}
	
	public void setCoef( int coef ) {
		this.coef = coef;
	}
	
	public int getGraddingScale() {
		return graddingScale;
	}
	
	public void setGraddingScale( int graddingScale ) {
		this.graddingScale = graddingScale;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName( String name ) {
		this.name = name;
	}
}
