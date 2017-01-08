package projet.Entity.DAO;

import projet.Component.BaseDAO;
import projet.Entity.Student;

import java.util.Collection;
import java.util.LinkedHashMap;

/**
 * Created by emsm on 08/01/2017.
 */
public final class StudentDAO extends BaseDAO< Student > {
	
	public Student findByPrimaryKey( Integer id ) {
		String query = "SELECT * FROM Student s WHERE s.id = :id";
		LinkedHashMap< String, String > params = new LinkedHashMap<>();
		params.put( "id", Integer.toString( id ) );
		
		return findOne( query, params );
	}
	
	@Override
	public Collection findAll() {
		String query = "SELECT * FROM Student";
		LinkedHashMap< String, String > param = new LinkedHashMap<>();
		return findAll( query, param );
	}
}
