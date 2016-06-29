package model.facade.rs;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import model.domain.Curso;
import model.facade.CursoFacade;
import model.service.CursoService;

@Path("/curso")
@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
public class CursoFacadeImpl implements CursoFacade{

	@Inject
	private CursoService cursoService;
	
	@Override
	@GET
	public List<Curso> getCursosSemParametro(){
		return cursoService.getCursos(new Curso());
	}
	
	@Override
	@GET
	@Path("/{codigo}")
	public List<Curso> getCursos(@PathParam("codigo") Integer codigo){
		Curso curso = new Curso();
		curso.setCodigo(codigo);
		return cursoService.getCursos(curso);
	}
	
	@Override
	@POST
	public Curso salvar(Curso curso){
		return cursoService.salvar(curso);
	}
	
	@Override
	@PUT
	public void atualizar(Curso curso){
		cursoService.atualizar(curso);
	}
	
	@Override
	@DELETE
	@Path("/{codigo}")
	public void excluir(@PathParam("codigo") Integer codigo){
		Curso curso = new Curso();
		curso.setCodigo(codigo);
		cursoService.excluir(curso);
	}
}
