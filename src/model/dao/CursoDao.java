package model.dao;

import java.util.List;

import model.domain.Curso;

public interface CursoDao {
	public Curso salvar(Curso curso);
	public void atualizar(Curso curso);
	public void excluir(Curso curso);
	public List<Curso> getCursos(Curso curso);
}