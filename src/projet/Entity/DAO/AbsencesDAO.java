package projet.Entity.DAO;

import projet.Component.BaseDAO;
import projet.Component.QueryBuilder;
import projet.Entity.Absence;

import java.util.Collection;

/**
 * Created by emsm on 05/02/2017.
 */
public class AbsencesDAO extends BaseDAO< Absence > {
	
	@Override
	public Absence findByPrimaryKey( Object pk ) {
		QueryBuilder qb = new QueryBuilder( "SELECT a FROM Absence a WHERE a.id_absence = :idabsence" );
		qb.addParam( "idabsence", pk );
		
		return findOne( qb.getQuery(), qb.getParams() );
	}
	
	@Override
	public Collection findAll() {
		QueryBuilder qb = new QueryBuilder( "SELECT a FROM Absence a" );
		return findAll( qb.getQuery(), qb.getParams() );
	}
}
