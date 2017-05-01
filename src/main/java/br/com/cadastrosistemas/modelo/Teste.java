package br.com.cadastrosistemas.modelo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import br.com.cadastrosistemas.enume.Status;

public class Teste {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("SistemaPU");
		EntityManager em = factory.createEntityManager();
		
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();
		
		Sistema sistema = new Sistema();
		sistema.setDescricao("descricao aqui, vamos descrever tudo o que temos epodemos e o que nao podemos e o que poderemos.");
		sistema.setEmail("goianinho@goianiense.com.br");
		sistema.setJustificativaNova("depois justifico novamente");
		sistema.setSigla("DD1234");
		sistema.setUrl("http://internet.com");
		sistema.setStatus(Status.ATIVO);
		
		em.persist(sistema);
		
		tx.commit();

	}

}
