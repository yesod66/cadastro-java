package br.com.cadastrosistemas.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.com.cadastrosistemas.modelo.Sistema;
import br.com.cadastrosistemas.util.Filtro;
import br.com.cadastrosistemas.util.JpaUtil;

public class SistemaDaoImpl implements SistemaDao, Serializable{

	private static final long serialVersionUID = 1L;


	@Override
	public Sistema salvar(Sistema sistema) {
		EntityManager manager = JpaUtil.getEntityManager();
		EntityTransaction trx = manager.getTransaction();
		
		trx.begin();
		manager.persist(sistema);
		trx.commit();
		return sistema;
	}

	@Override
	public void alterar(Sistema sistema) {
		EntityManager manager = JpaUtil.getEntityManager();
		EntityTransaction trx = manager.getTransaction();
		
		trx.begin();
		manager.merge(sistema);
		trx.commit();
		
	}

	@Override
	public void excluir(Sistema sistema) {
		EntityManager manager = JpaUtil.getEntityManager();
		EntityTransaction trx = manager.getTransaction();
		
		trx.begin();
		manager.remove(sistema);
		trx.commit();
		
	}

	@Override
	public Sistema porId(Long id) {
		EntityManager manager = JpaUtil.getEntityManager();
		return manager.find(Sistema.class, id);
		
	}

	@Override
	public List<Sistema> listarTodos(Sistema sistema) {
		EntityManager manager = JpaUtil.getEntityManager();
		List<Sistema> lista = manager.createQuery("from Sistema", Sistema.class).getResultList();
		return lista;
		
	}
	
	
	@SuppressWarnings("unchecked")
	public List<Sistema> filtrados(Filtro filtro){
		EntityManager manager = JpaUtil.getEntityManager();
		Session session =  manager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(Sistema.class);
		
		if (StringUtils.isNotBlank(filtro.getDescricao())) {
			criteria.add(Restrictions.ilike("descricao", filtro.getDescricao(), MatchMode.ANYWHERE));
		}
		if (StringUtils.isNotBlank(filtro.getSigla())) {
			criteria.add(Restrictions.eq("sigla", filtro.getSigla()));
		}
		if (StringUtils.isNotBlank(filtro.getEmail())) {
			criteria.add(Restrictions.ilike("email", filtro.getEmail(), MatchMode.ANYWHERE));
		}
		return criteria.addOrder(Order.asc("descricao")).list();
	}
	
}
