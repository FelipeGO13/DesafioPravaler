package br.com.sgie.dao;

import org.springframework.stereotype.Repository;

import br.com.sgie.model.Curso;

@Repository
public class CursoDAO extends AbstractHibernateDAO<Curso> implements Operacoes<Curso> {

	public CursoDAO() {
		setClazz(Curso.class);
	}
	
}
	