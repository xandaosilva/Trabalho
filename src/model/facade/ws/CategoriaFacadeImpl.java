package model.facade.ws;

import java.util.List;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import model.domain.Categoria;
import model.facade.CategoriaFacede;
import model.service.CategoriaService;

@WebService(serviceName="ws/categoria")
public class CategoriaFacadeImpl implements CategoriaFacede{

	@Inject
	private CategoriaService categoriaService;
	
	@Override
	@WebMethod
	public List<Categoria> getCategoriasSemParametro(){
		return categoriaService.getCategorias(new Categoria());
	}
	
	@Override
	@WebMethod
	public List<Categoria> getCategorias(@WebParam(name="codigo") Integer codigo){
		Categoria categoria = new Categoria();
		categoria.setCodigo(codigo);
		return categoriaService.getCategorias(categoria);
	}
	
	@Override
	@WebMethod
	public Categoria salvar(@WebParam(name="categoria") Categoria categoria){
		return categoriaService.salvar(categoria);
	}
	
	@Override
	@WebMethod
	public void atualizar(@WebParam(name="categoria") Categoria categoria){
		categoriaService.atualizar(categoria);
	}
	
	@Override
	@WebMethod
	public void excluir(@WebParam(name="codigo") Integer codigo){
		Categoria categoria = new Categoria();
		categoria.setCodigo(codigo);
		categoriaService.excluir(categoria);
	}
}