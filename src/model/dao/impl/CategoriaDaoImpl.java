package model.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import model.dao.CategoriaDao;
import model.domain.Categoria;

public class CategoriaDaoImpl implements CategoriaDao {

	@PersistenceContext(name="TrabalhoPU")
	private EntityManager entityManager;
	
	@Override
	public Categoria salvar(Categoria categoria){
		entityManager.persist(categoria);
		return categoria;
	}
	
	@Override
	public void atualizar(Categoria categoria){
		salvar(entityManager.merge(categoria));
	}
	
	@Override
	public void excluir(Categoria categoria){
		entityManager.remove(entityManager.merge(categoria));
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Categoria> getCategorias(Categoria categoria){
		StringBuilder hql = new StringBuilder("from Categoria c where 1 = 1");
		
		if(categoria.getCodigo() != null)
			hql.append("and c.codigo = :codigo");
		
		Query query = entityManager.createQuery(hql.toString());
		
		if(categoria.getCodigo() != null)
			query.setParameter("categoria",categoria.getCodigo());
			
		return query.getResultList();
	}
}
