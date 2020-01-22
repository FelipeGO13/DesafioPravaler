package br.com.sgie.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.sgie.model.Aluno;
import br.com.sgie.model.Curso;
import br.com.sgie.service.AlunoService;
import br.com.sgie.service.CursoService;

@Controller
public class AlunoController {

	@Autowired
	AlunoService alunoService;

	@Autowired
	CursoService cursoService;

	@RequestMapping("/gestaoAlunos")
	public String gerenciarAluno(Model model) {

		List<Aluno> lista = alunoService.findAll();

		model.addAttribute("alunos", lista);

		return "gestaoAlunos.html";
	}

	@RequestMapping("/incluirAluno")
	public String incluirAluno(Model model) {

		model.addAttribute("aluno", new Aluno());

		// Remove cursos inativos
		List<Curso> lista = cursoService.findAll().stream().filter(curso -> !"inativo".equals(curso.getStatus()))
				.collect(Collectors.toList());

		model.addAttribute("cursos", lista);

		return "incluirAluno.html";
	}

	@RequestMapping("/cadastrarAluno")
	public String cadastrarAluno(Model model, Aluno aluno, long cursoId) {

		aluno.setStatus("ativo");
		aluno.setCurso(cursoService.findOne(cursoId));
		alunoService.create(aluno);

		List<Aluno> lista = alunoService.findAll();
		model.addAttribute("alunos", lista);
		model.addAttribute("mensagem", "Aluno " + aluno.getNome() + "cadastrado com sucesso!");

		return "gestaoAlunos.html";
	}

	@RequestMapping("/excluirAluno/{id}")
	public String excluirAluno(Model model, @PathVariable Long id) {
		alunoService.deleteById(id);
		List<Aluno> lista = alunoService.findAll();
		model.addAttribute("alunos", lista);
		model.addAttribute("mensagem", "Aluno excluído com sucesso!");
		return "gestaoAlunos.html";
	}

	@RequestMapping("/editarAluno/{id}")
	public String editarAluno(Model model, @PathVariable Long id) {
		Aluno aluno = alunoService.findOne(id);
		model.addAttribute("aluno", aluno);
		List<Curso> lista = cursoService.findAll().stream().filter(curso -> !"inativo".equals(curso.getStatus()))
				.collect(Collectors.toList());

		model.addAttribute("cursos", lista);
		model.addAttribute("mensagem", "Aluno editado com sucesso!");

		return "editarAluno.html";
	}
	
	@RequestMapping("/confirmarEdicaoAluno")
	public String confirmarEdicaoAluno(Model model, Aluno aluno, long cursoId) {

		aluno.setCurso(cursoService.findOne(cursoId));
		alunoService.update(aluno);

		List<Aluno> lista = alunoService.findAll();
		model.addAttribute("alunos", lista);
		model.addAttribute("mensagem", "Aluno " + aluno.getNome() + "cadastrado com sucesso!");


		return "gestaoAlunos.html";
	}

}
