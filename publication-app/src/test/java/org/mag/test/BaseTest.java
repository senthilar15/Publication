package org.mag.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import junit.framework.TestCase;

public class BaseTest extends TestCase{
	
	private EntityManagerFactory emf;
	private EntityManager em;
	private String persistentUnit;
	
	public BaseTest(String persistentUnit){
		this.persistentUnit = persistentUnit;
	}
	
	
	@Override
	protected final void setUp() throws Exception {
	      emf = Persistence.createEntityManagerFactory(persistentUnit);
	      em = emf.createEntityManager();	      
	}
	
	protected void beginTransaction(){
		em.getTransaction().begin();
	}
	
	protected void commit(){
		em.getTransaction().commit();
	}
	
	
	protected EntityManager entityManager(){
		return em;
	}
	
	@Override
	protected final void tearDown() throws Exception {
		em.clear();
		em.close();
		emf.close();
	}
	

}
