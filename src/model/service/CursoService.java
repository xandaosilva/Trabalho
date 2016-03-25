package model.service;

import java.util.List;

import model.domain.Curso;

public interface CursoService {
	public List<Curso> getCursos(Curso curso);
	public Curso salvar(Curso curso);
	public void atualizar(Curso curso);
	public void excluir(Curso curso);
}