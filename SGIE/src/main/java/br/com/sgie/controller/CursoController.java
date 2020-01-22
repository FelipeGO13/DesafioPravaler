package br.com.sgie.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.sgie.model.Aluno;
import br.com.sgie.model.Curso;
import br.com.sgie.model.Instituicao;
import br.com.sgie.service.CursoService;
import br.com.sgie.service.InstituicaoService;

@Controller
public class CursoController {
	
	@Autowired
	CursoService cursoService;
	
	@Autowired
	InstituicaoService instituicaoService;
	
	@RequestMapping("/gestaoCursos")
	public String home(Model model) {
		
		
		List<Curso> lista = cursoService.findAll();
		model.addAttribute("cursos", lista);

        return "gestaoCursos.html";
	}
	
	@RequestMapping("/incluirCurso")
	public String incluirCurso(Model model) {

		model.addAttribute("curso", new Curso());

		// Remove instituicoes inativas
		List<Instituicao> lista = instituicaoService.findAll().stream().filter(inst -> !"inativo".equals(inst.getStatus()))
				.collect(Collectors.toList());

		model.addAttribute("instituicoes", lista);

		return "incluirCurso.html";
	}
	
	@RequestMapping("/cadastrarCurso")
	public String cadastrarCurso(Model model, Curso curso, long instituicaoId) {

		curso.setStatus("ativo");
		curso.setInstituicao(instituicaoService.findOne(instituicaoId));
		cursoService.create(curso);

		List<Curso> lista = cursoService.findAll();
		model.addAttribute("cursos", lista);
		model.addAttribute("mensagem", "Curso " + curso.getNome() + "cadastrado com sucesso!");

		return "gestaoCursos.html";
	}
	
	@RequestMapping("/excluirCurso/{id}")
	public String excluirCurso(Model model, @PathVariable Long id) {
		Curso curso = cursoService.findOne(id);
		if(curso.getAlunos().isEmpty()) {
			cursoService.deleteById(id);
		} else {
			curso.setStatus("inativo");
			cursoService.update(curso);
		}
		
		List<Curso> lista = cursoService.findAll();
		model.addAttribute("cursos", lista);
		model.addAttribute("mensagem", "Curso excluído com sucesso!");
		return "gestaoCursos.html";
	}

	@RequestMapping("/editarCurso/{id}")
	public String editarCurso(Model model, @PathVariable Long id) {
		
		Curso curso = cursoService.findOne(id);
		List<Instituicao> lista = instituicaoService.findAll().stream().filter(inst -> !"inativo".equals(inst.getStatus()))
				.collect(Collectors.toList());

		model.addAttribute("instituicoes", lista);
		model.addAttribute("curso", curso);
		return "editarCurso.html";
	}
	
	@RequestMapping("/confirmarEdicaoCurso")
	public String confirmarEdicaoCurso(Model model, Curso curso, long instituicaoId) {

		curso.setInstituicao(instituicaoService.findOne(instituicaoId));

		curso.setStatus("ativo");
		cursoService.update(curso);

		List<Curso> lista = cursoService.findAll();
		model.addAttribute("cursos", lista);
		model.addAttribute("mensagem", "Curso editado com sucesso!");
		return "gestaoCursos.html";
	}

	
}
