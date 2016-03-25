package model.service;

import java.util.List;

import model.domain.Modalidade;

public interface ModalidadeService {
	public List<Modalidade> getModalidades(Modalidade modalidade);
	public Modalidade salvar(Modalidade modalidade);
	public void atualizar(Modalidade modalidade);
	public void excluir(Modalidade modalidade);
}