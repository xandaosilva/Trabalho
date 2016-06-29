package model.service;

import java.util.List;

import javax.validation.Valid;
import javax.validation.executable.ValidateOnExecution;

import model.domain.Curso;

public interface CursoService {
	public List<Curso> getCursos(Curso curso);
	@ValidateOnExecution
	public Curso salvar(@Valid Curso curso);
	public void atualizar(Curso curso);
	public void excluir(Curso curso);
}