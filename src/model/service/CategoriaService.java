package model.service;

import java.util.List;

import model.domain.Categoria;

public interface CategoriaService {
	public List<Categoria> getCategorias(Categoria categoria);
	public Categoria salvar(Categoria categoria);
	public void atualizar(Categoria categoria);
	public void excluir(Categoria categoria);
}