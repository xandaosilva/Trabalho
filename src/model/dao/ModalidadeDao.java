package model.dao;

import java.util.List;

import model.domain.Modalidade;

public interface ModalidadeDao {
	public Modalidade salvar(Modalidade modalidade);
	public void atualizar(Modalidade modalidade);
	public void excluir(Modalidade modalidade);
	public List<Modalidade> getModalidades(Modalidade modalidade);
}