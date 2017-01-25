package projet.Entity.DAO;

import projet.Component.BaseDAO;
import projet.Component.QueryBuilder;
import projet.Entity.Note;

import java.util.Collection;

/**
 * Created by SMITHE on 25-Jan-17.
 */
public class NoteDAO extends BaseDAO< Note > {
	@Override
	public Note findByPrimaryKey( Object pk ) {
		QueryBuilder qb = new QueryBuilder( "SELECT n FROM Note n WHERE id_note = :idnote" );
		qb.addParam( "idnote", pk );
		
		return findOne( qb.getQuery(), qb.getParams() );
	}
	
	@Override
	public Collection findAll() {
		QueryBuilder qb = new QueryBuilder( "SELECT n FROM Note n" );
		return findAll( qb.getQuery(), qb.getParams() );
	}
}
