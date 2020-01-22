package br.com.sgie.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.sgie.dao.AlunoDAO;
import br.com.sgie.model.Aluno;

@Service
@Transactional
public class AlunoService {

	@Autowired
	private AlunoDAO dao;

	public AlunoService() {
		super();
	}

	// API

	public void create(final Aluno aluno) {
		dao.create(aluno);
	}

	public Aluno findOne(final long id) {
		return dao.findOne(id);
	}

	public List<Aluno> findAll() {
		return dao.findAll();
	}
	
	public void delete(final Aluno aluno) {
		dao.delete(aluno);
	}
	
	public void deleteById(final long id) {
		dao.deleteById(id);
	}

	public void update(final Aluno aluno) {
		dao.update(aluno);
	}

}