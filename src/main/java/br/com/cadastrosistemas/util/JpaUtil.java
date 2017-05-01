package br.com.cadastrosistemas.util;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtil implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private static EntityManagerFactory factory;
	
	static {
		factory = Persistence.createEntityManagerFactory("SistemaPU");
	}

	public static EntityManager getEntityManager() {
		return factory.createEntityManager();
	}

}
