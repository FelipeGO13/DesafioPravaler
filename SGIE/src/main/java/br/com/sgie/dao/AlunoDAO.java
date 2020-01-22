package br.com.sgie.dao;

import org.springframework.stereotype.Repository;

import br.com.sgie.model.Aluno;

@Repository
public class AlunoDAO extends AbstractHibernateDAO<Aluno> implements Operacoes<Aluno> {

	public AlunoDAO() {
		setClazz(Aluno.class);
	}
	
}
