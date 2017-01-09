package projet.Entity.DAO;

import projet.Component.BaseDAO;
import projet.Entity.Group;

import java.util.Collection;
import java.util.LinkedHashMap;

/**
 * Created by SMITHE on 09-Jan-17.
 */
public final class GroupDAO extends BaseDAO<Group> {
	@Override
	public Group findByPrimaryKey( Object id ) {
		String query = "SELECT g FROM GroupStudents g WHERE g.id_Groupe = :id";
		LinkedHashMap< String, Object > params = new LinkedHashMap<>();
		params.put( "id", id );
		
		return findOne( query, params );
	}
	
	@Override
	public Collection findAll() {
		String query = "SELECT g FROM GroupStudents g";
		LinkedHashMap< String, Object > param = new LinkedHashMap<>();
		return findAll( query, param );
	}
}
