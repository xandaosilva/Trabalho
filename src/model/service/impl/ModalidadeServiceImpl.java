package model.service.impl;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import model.dao.ModalidadeDao;
import model.domain.Modalidade;
import model.service.ModalidadeService;

public class ModalidadeServiceImpl implements ModalidadeService {

	@Inject
	private ModalidadeDao modalidadeDao;
	
	@Override
	@Transactional
	public List<Modalidade> getModalidades(Modalidade modalidade){
		return modalidadeDao.getModalidades(modalidade);
	}
	
	@Override
	@Transactional
	public Modalidade salvar(Modalidade modalidade){
		return modalidadeDao.salvar(modalidade);
	}
	
	@Override
	@Transactional
	public void atualizar(Modalidade modalidade){
		modalidadeDao.atualizar(modalidade);
	}
	
	@Override
	@Transactional
	public void excluir(Modalidade modalidade){
		modalidadeDao.excluir(modalidade);
	}
}