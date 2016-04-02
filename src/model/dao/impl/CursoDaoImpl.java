package model.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import model.dao.CursoDao;
import model.domain.Curso;

public class CursoDaoImpl implements CursoDao{

	@PersistenceContext(name="TrabalhoPU")
	private EntityManager entityManager;
	
	@Override
	public Curso salvar(Curso curso){
		entityManager.persist(curso);
		return curso;
	}
	
	@Override
	public void atualizar(Curso curso){
		salvar(entityManager.merge(curso));
	}
	
	@Override
	public void excluir(Curso curso){
		entityManager.remove(entityManager.merge(curso));
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Curso> getCursos(Curso curso){
		StringBuilder hql = new StringBuilder("from Curso curso where 1 = 1");
		
		if(curso.getCodigo() != null)
			hql.append("and curso.codigo = :codigo");
		
		Query query = entityManager.createQuery(hql.toString());
		
		if(curso.getCodigo() != null)
			query.setParameter("codigo",curso.getCodigo());
			
		return query.getResultList();
	}
}
