package projet.Entity;

import projet.Controller.AbsenceController;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * Created by emsm on 05/02/2017.
 */

@Entity
public class Absence implements Serializable {
	public static final String FORMAT_DATE = "yyyy-MM-dd HH:mm";
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue( strategy = GenerationType.AUTO )
	private int id_absence;
	
	@Column( nullable = false )
	private long fromDate;
	
	@Column( nullable = false )
	private long toDate;
	
	@ManyToOne( cascade = { CascadeType.MERGE } )
	private Student student;
	
	public int getId_absence() {
		return id_absence;
	}
	
	public String getFromDate() {
		return parseLongToDate( fromDate );
	}
	
	public void setFromDate( String fromDate ) {
		this.fromDate = parseDateToLong( fromDate );
	}
	
	public String getToDate() {
		return parseLongToDate( toDate );
	}
	
	public void setToDate( String toDate ) {
		this.toDate = parseDateToLong( toDate );
	}
	
	public Student getStudent() {
		return student;
	}
	
	public void setStudent( Student student ) {
		this.student = student;
	}
	
	private DateTimeFormatter getFormatter() {
		return DateTimeFormatter.ofPattern( FORMAT_DATE );
	}
	
	private long parseDateToLong( String date ) {
		return Timestamp.valueOf( LocalDateTime.parse( date, getFormatter() ) ).getTime();
	}
	
	private String parseLongToDate( long timestamp ) {
		return Instant.ofEpochMilli( timestamp )
			.atZone( ZoneId.systemDefault() )
			.toLocalDateTime().format( getFormatter() );
	}
	
	@Override
	public String toString() {
		return "Depuis le " + getFromDate() + " jusqu'au " + getToDate();
	}
}
