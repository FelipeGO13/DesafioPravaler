package br.com.sgie.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sgie.dao.InstituicaoDAO;
import br.com.sgie.model.Instituicao;

@Service
@Transactional
public class InstituicaoService {

	@Autowired
	private InstituicaoDAO dao;

	public InstituicaoService() {
		super();
	}

	// API

	public void create(final Instituicao instituicao) {
		dao.create(instituicao);
	}

	public Instituicao findOne(final long id) {
		return dao.findOne(id);
	}

	public List<Instituicao> findAll() {
		return dao.findAll();
	}
	
	public void delete(final Instituicao instituicao) {
		dao.delete(instituicao);
	}
	
	public void deleteById(final long id) {
		dao.deleteById(id);
	}

	public void update(final Instituicao instituicao) {
		dao.update(instituicao);
	}
	
	


}