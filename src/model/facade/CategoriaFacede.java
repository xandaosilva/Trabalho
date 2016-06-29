package model.facade;

import java.util.List;

import javax.validation.Valid;
import javax.validation.executable.ValidateOnExecution;

import model.domain.Categoria;

public interface CategoriaFacede {

	List<Categoria> getCategoriasSemParametro();
	List<Categoria> getCategorias(Integer codigo);

	@ValidateOnExecution
	Categoria salvar(@Valid Categoria categoria);

	@ValidateOnExecution
	void atualizar(@Valid Categoria categoria);
	void excluir(Integer codigo);
}
