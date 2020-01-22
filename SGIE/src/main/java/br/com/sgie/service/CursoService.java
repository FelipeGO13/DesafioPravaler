package br.com.sgie.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sgie.dao.CursoDAO;
import br.com.sgie.model.Curso;

@Service
@Transactional
public class CursoService {

	@Autowired
	private CursoDAO dao;

	public CursoService() {
		super();
	}

	// API
	public void create(final Curso curso) {
		dao.create(curso);
	}

	public Curso findOne(final long id) {
		return dao.findOne(id);
	}

	public List<Curso> findAll() {
		return dao.findAll();
	}
	
	public void delete(final Curso curso) {
		dao.delete(curso);
	}
	
	public void deleteById(final long id) {
		dao.deleteById(id);
	}

	public void update(final Curso curso) {
		dao.update(curso);
	}

}