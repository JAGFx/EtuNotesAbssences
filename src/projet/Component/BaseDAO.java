package projet.Component;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.*;
import java.util.Map.Entry;

/**
 * Created by emsm on 08/01/2017.
 */

// TODO Gestion erreur EM
public abstract class BaseDAO< T > {
	private EntityManager em;
	private Class< T > entityBeanType;
	
	public BaseDAO() {
		em = GestionFactory.factory.createEntityManager();
	}
	
	public void addEntity( T entity ) {
		try {
			em.getTransaction().begin();
			em.persist( entity );
			em.getTransaction().commit();
			//em.close();
		} catch ( Exception e ) {
			//throw new DAOException( e );
			System.out.println( e.getMessage() );
		}
	}
	
	public void updateEntity( T entity ) {
		try {
			em.getTransaction().begin();
			em.merge( entity );
			em.getTransaction().commit();
			//em.close();
		} catch ( Exception e ) {
			//throw new DAOException( e );
			System.out.println( e.getMessage() );
		}
	}
	
	public void removeEntity( T entity ) {
		try {
			em.getTransaction().begin();
			em.remove( entity );
			em.getTransaction().commit();
			//em.close();
		} catch ( Exception e ) {
			//throw new DAOException( e );
			System.out.println( e.getMessage() );
		}
	}
	
	public T findOne( String query, LinkedHashMap< String, Object > params ) {
		Query q = execQuery( query, params );
		
		return ( T ) q.getSingleResult();
	}
	// -------------------------------------------------------------------------------------------------------- Liste notes Student
	public abstract T findByPrimaryKey( Object pk );
	
	public T findOne( String param ) {
		return em.find( getEntityBeanType(), param );
	}
	
	public Collection findAll( String query, LinkedHashMap< String, Object > params ) {
		Query q = execQuery( query, params );
		
		return q.getResultList();
	}
	
	public abstract Collection findAll();
	
	protected final Query execQuery( String query, LinkedHashMap< String, Object > params ) {
		Query q = em.createQuery( query );
		
		if ( !params.isEmpty() ) {
			Set< Entry< String, Object > > setLhm = params.entrySet();
			Iterator< Entry< String, Object > > it2 = setLhm.iterator();
			while ( it2.hasNext() ) {
				Entry< String, Object > e = it2.next();
				
				q
					.setParameter( e.getKey(), e.getValue() );
					//.executeUpdate();
			}
		}
		
		return q;
	}
	
	protected final Class< T > getEntityBeanType() {
		return entityBeanType;
	}
}
