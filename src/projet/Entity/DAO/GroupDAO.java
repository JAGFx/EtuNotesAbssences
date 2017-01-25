package projet.Entity.DAO;

import projet.Component.BaseDAO;
import projet.Component.QueryBuilder;
import projet.Entity.Group;

import java.util.HashSet;

/**
 * Created by SMITHE on 09-Jan-17.
 */
public final class GroupDAO extends BaseDAO< Group > {
	@Override
	public Group findByPrimaryKey( Object pk ) {
		QueryBuilder qb = new QueryBuilder( "SELECT g FROM GroupStudents g WHERE g.id_Groupe = :id" );
		qb.addParam( "id", pk );
		
		return findOne( qb.getQuery(), qb.getParams() );
	}
	
	@Override
	public HashSet< Group > findAll() {
		QueryBuilder qb = new QueryBuilder( "SELECT g FROM GroupStudents g" );
		
		HashSet< Group > hashSet = new HashSet<>();
		for ( Object grp : findAll( qb.getQuery(), qb.getParams() ) )
			hashSet.add( ( Group ) grp );
		
		return hashSet;
	}
}
