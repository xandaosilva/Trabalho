package model.service;

import java.util.List;

import javax.validation.Valid;
import javax.validation.executable.ValidateOnExecution;

import model.domain.Modalidade;

public interface ModalidadeService {
	public List<Modalidade> getModalidades(Modalidade modalidade);
	@ValidateOnExecution
	public Modalidade salvar(@Valid Modalidade modalidade);
	public void atualizar(Modalidade modalidade);
	public void excluir(Modalidade modalidade);
}