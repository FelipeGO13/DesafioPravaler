package br.com.sgie.dao;

import org.springframework.stereotype.Repository;

import br.com.sgie.model.Instituicao;

@Repository
public class InstituicaoDAO extends AbstractHibernateDAO<Instituicao> implements Operacoes<Instituicao> {

	public InstituicaoDAO() {
		setClazz(Instituicao.class);
	}
	
}
