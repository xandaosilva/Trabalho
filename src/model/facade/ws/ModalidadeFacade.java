package model.facade.ws;

import java.util.List;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import model.domain.Modalidade;
import model.service.ModalidadeService;

@WebService(serviceName="ws/modalidade")
public class ModalidadeFacade {

	@Inject
	private ModalidadeService modalidadeService;
	
	@WebMethod
	public List<Modalidade> getModalidadesSemParametros(){
		return modalidadeService.getModalidades(new Modalidade());
	}
	
	@WebMethod
	public List<Modalidade> getModalidades(@WebParam(name="codigo") Integer codigo){
		Modalidade modalidade = new Modalidade();
		modalidade.setCodigo(codigo);
		return modalidadeService.getModalidades(modalidade);
	}
	
	@WebMethod
	public Modalidade salvar(@WebParam(name="modalidade") Modalidade modalidade){
		return modalidadeService.salvar(modalidade);
	}
	
	@WebMethod
	public void atualizar(@WebParam(name="modalidade") Modalidade modalidade){
		modalidadeService.atualizar(modalidade);
	}
	
	@WebMethod
	public void excluir(@WebParam(name="codigo") Integer codigo){
		Modalidade modalidade = new Modalidade();
		modalidade.setCodigo(codigo);
		modalidadeService.excluir(modalidade);
	}
}
