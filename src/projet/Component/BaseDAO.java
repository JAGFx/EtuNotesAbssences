package projet.Component;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
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
	
	// -------------------------------------------------------------------------- CRUD
	
	/**
	 * Ajoute une entité en base de donnée
	 *
	 * @param entity Entité à ajouter
	 */
	public void addEntity( T entity ) {
		generateEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		try {
			tx.begin();
			em.persist( entity );
			tx.commit();
		} catch ( Exception e ) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			em.close();
		}
	}
	
	/**
	 * Met à jour une entité en base de données
	 *
	 * @param entity Entité à mettre à jour
	 */
	public void updateEntity( T entity ) {
		generateEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		try {
			tx.begin();
			em.merge( entity );
			tx.commit();
		} catch ( Exception e ) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			em.close();
		}
	}
	
	/**
	 * Supprime une entité de la base de données
	 *
	 * @param entity Entité à supprimer
	 */
	public void removeEntity( T entity ) {
		generateEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		try {
			tx.begin();
			em.remove( em.merge( entity ) );
			tx.commit();
		} catch ( Exception e ) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			em.close();
		}
	}
	
	
	// -------------------------------------------------------------------------- Liste d'entitées
	
	/**
	 * Retourne une entité grâce à sa clé primaire
	 *
	 * @param pk Clé primaire
	 * @return Entitée trouvé
	 */
	public abstract T findByPrimaryKey( Object pk );
	
	/**
	 * Retrouve toutes les entités d'une même classe
	 *
	 * @return Collection d'entités
	 */
	public abstract Collection findAll();
	
	/**
	 * Retrouve une entité avec la combinaison de requête <> paramètres
	 *
	 * @param query Requête SQL
	 * @param params Paramètres
	 * @return Entitée correspondante
	 */
	public T findOne( String query, LinkedHashMap< String, Object > params ) {
		Query q = prepareQuery( query, params );
		
		return ( T ) q.getSingleResult();
	}
	
	/**
	 * Retrouve une entité avec une liste de paramètres
	 *
	 * @param param Paramètres
	 * @return Entitée correspondante
	 */
	public T findOne( String param ) {
		return em.find( getEntityBeanType(), param );
	}
	
	/**
	 * Retrouve toutes entités avec la combinaison de requête <> paramètres
	 *
	 * @param query Requête SQL
	 * @param params Paramètres
	 * @return Liste d'entitées correspondantes
	 */
	public Collection findAll( String query, LinkedHashMap< String, Object > params ) {
		Query q = prepareQuery( query, params );
		
		return q.getResultList();
	}
	
	
	// -------------------------------------------------------------------------- Méthodes d'actions
	
	/**
	 * Prépare une requête auprès de la base de données
	 *
	 * @param query  Requête SQL
	 * @param params Paramètres
	 * @return Requête préparée
	 */
	protected final Query prepareQuery( String query, LinkedHashMap< String, Object > params ) {
		generateEntityManager();
		
		Query q = em.createQuery( query );
		
		if ( !params.isEmpty() ) {
			Set< Entry< String, Object > > setLhm = params.entrySet();
			Iterator< Entry< String, Object > > it2 = setLhm.iterator();
			while ( it2.hasNext() ) {
				Entry< String, Object > e = it2.next();
				
				q
					.setParameter( e.getKey(), e.getValue() );
			}
		}
		
		return q;
	}
	
	/**
	 * Retourne le type de la classe instancié
	 * @return Type de la classe instancié
	 */
	protected final Class< T > getEntityBeanType() {
		return entityBeanType;
	}
	
	/**
	 * Regénère le gestionnaire d'entitées
	 */
	private void generateEntityManager(){
		em = GestionFactory.factory.createEntityManager();
	}
}
