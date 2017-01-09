package projet.Entity.DAO;

import projet.Component.BaseDAO;
import projet.Entity.Student;

import java.util.Collection;
import java.util.LinkedHashMap;

/**
 * Created by emsm on 08/01/2017.
 */
public final class StudentDAO extends BaseDAO< Student > {
	
	public Student findByPrimaryKey( int id ) {
		String query = "SELECT s FROM Student s WHERE s.stud_id = :id";
		LinkedHashMap< String, Object > params = new LinkedHashMap<>();
		params.put( "id",  id );
		
		return findOne( query, params );
	}
	
	@Override
	public Collection findAll() {
		String query = "SELECT s FROM Student s";
		LinkedHashMap< String, Object > param = new LinkedHashMap<>();
		return findAll( query, param );
	}
}
