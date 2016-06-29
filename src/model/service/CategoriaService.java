package model.service;

import java.util.List;

import javax.validation.Valid;
import javax.validation.executable.ValidateOnExecution;

import model.domain.Categoria;

public interface CategoriaService {
	public List<Categoria> getCategorias(Categoria categoria);
	@ValidateOnExecution
	public Categoria salvar(@Valid Categoria categoria);
	public void atualizar(Categoria categoria);
	public void excluir(Categoria categoria);
}