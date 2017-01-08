package projet.Component;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Set;

/**
 * Created by emsm on 08/01/2017.
 */
public abstract class BaseDAO< T > {
	private EntityManager em;
	private Class< T > entityBeanType;
	
	public BaseDAO() {
		em = GestionFactory.factory.createEntityManager();
	}
	
	public void addEntity( T entity ) {
		try {
			em.persist( entity );
		} catch ( Exception e ) {
			//throw new DAOException( e );
			System.out.println( e.getMessage() );
		}
	}
	
	public void updateEntity( T entity ) {
		try {
			em.merge( entity );
		} catch ( Exception e ) {
			//throw new DAOException( e );
			System.out.println( e.getMessage() );
		}
	}
	
	public void removeEntity( T entity ) {
		try {
			em.remove( entity );
		} catch ( Exception e ) {
			//throw new DAOException( e );
			System.out.println( e.getMessage() );
		}
	}
	
	public T findOne( String query, LinkedHashMap< String, String > params ) {
		Query q = execQuery( query, params );
		
		return ( T ) q.getSingleResult();
	}
	
	public T findOne( String param ) {
		return em.find( getEntityBeanType(), param );
	}
	
	public Collection findAll( String query, LinkedHashMap< String, String > params ) {
		Query q = execQuery( query, params );
		
		return q.getResultList();
	}
	
	public abstract Collection findAll();
	
	protected Query execQuery( String query, LinkedHashMap< String, String > params ) {
		Query q = em.createQuery( query );
		
		if ( !params.isEmpty() ) {
			Set< Entry< String, String > > setLhm = params.entrySet();
			Iterator< Entry< String, String > > it2 = setLhm.iterator();
			while ( it2.hasNext() ) {
				Entry< String, String > e = it2.next();
				
				q
					.setParameter( e.getKey(), e.getValue() )
					.executeUpdate();
			}
		}
		
		return q;
	}
	
	protected final Class< T > getEntityBeanType() {
		return entityBeanType;
	}
}
