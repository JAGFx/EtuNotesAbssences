package projet.Entity.DAO;

import projet.Component.BaseDAO;
import projet.Component.QueryBuilder;
import projet.Entity.Student;

import java.util.Collection;
import java.util.LinkedHashMap;

/**
 * Created by emsm on 08/01/2017.
 */
public final class StudentDAO extends BaseDAO< Student > {
	
	public Student findByPrimaryKey( Object pk ) {
		QueryBuilder qb = new QueryBuilder( "SELECT s FROM Student s WHERE s.stud_id = :id" );
		qb.addParam( "id", pk );
		
		return findOne( qb.getQuery(), qb.getParams() );
	}
	
	@Override
	public Collection findAll() {
		QueryBuilder qb = new QueryBuilder( "SELECT s FROM Student s" );
		
		return findAll( qb.getQuery(), qb.getParams() );
	}
}
