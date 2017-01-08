package projet.Entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

@Entity
@Table
public class Student implements Serializable {
	private static final Integer UNKNOWN_ID_STUDENT = -1;
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private final Integer stud_id;
	
	@Column( nullable = false )
	private String firstname;
	
	@Column( nullable = false )
	private String lastname;
	
	@ManyToOne( cascade = { CascadeType.MERGE, CascadeType.PERSIST }, optional = false )
	private Group group;
	
	@OneToMany( cascade = CascadeType.ALL, mappedBy = "student" )
	private Collection< Note > notes;
	
	public Student() {
		super();
		stud_id = UNKNOWN_ID_STUDENT;
		notes = new List< Note >() {
			@Override
			public int size() {
				return 0;
			}
			
			@Override
			public boolean isEmpty() {
				return false;
			}
			
			@Override
			public boolean contains( Object o ) {
				return false;
			}
			
			@Override
			public Iterator< Note > iterator() {
				return null;
			}
			
			@Override
			public Object[] toArray() {
				return new Object[ 0 ];
			}
			
			@Override
			public < T > T[] toArray( T[] a ) {
				return null;
			}
			
			@Override
			public boolean add( Note note ) {
				return false;
			}
			
			@Override
			public boolean remove( Object o ) {
				return false;
			}
			
			@Override
			public boolean containsAll( Collection< ? > c ) {
				return false;
			}
			
			@Override
			public boolean addAll( Collection< ? extends Note > c ) {
				return false;
			}
			
			@Override
			public boolean addAll( int index, Collection< ? extends Note > c ) {
				return false;
			}
			
			@Override
			public boolean removeAll( Collection< ? > c ) {
				return false;
			}
			
			@Override
			public boolean retainAll( Collection< ? > c ) {
				return false;
			}
			
			@Override
			public void clear() {
				
			}
			
			@Override
			public Note get( int index ) {
				return null;
			}
			
			@Override
			public Note set( int index, Note element ) {
				return null;
			}
			
			@Override
			public void add( int index, Note element ) {
				
			}
			
			@Override
			public Note remove( int index ) {
				return null;
			}
			
			@Override
			public int indexOf( Object o ) {
				return 0;
			}
			
			@Override
			public int lastIndexOf( Object o ) {
				return 0;
			}
			
			@Override
			public ListIterator< Note > listIterator() {
				return null;
			}
			
			@Override
			public ListIterator< Note > listIterator( int index ) {
				return null;
			}
			
			@Override
			public List< Note > subList( int fromIndex, int toIndex ) {
				return null;
			}
		};
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
}
