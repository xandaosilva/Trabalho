package model.dao;

import java.util.List;

import model.domain.Categoria;

public interface CategoriaDao {
	public Categoria salvar(Categoria categoria);
	public void atualizar(Categoria categoria);
	public void excluir(Categoria categoria);
	public List<Categoria> getCategorias(Categoria categoria);
}