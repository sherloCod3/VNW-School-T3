package br.com.vnwschoolt3.AlunoService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.vnwschoolt3.AlunoRepository.AlunoRepository;
import br.com.vnwschoolt3.dto.DadosAluno;
import br.com.vnwschoolt3.model.AlunoModel;

// Esta classe é responsável por fornecer serviços relacionados aos alunos.
@Service
public class AlunoService {

	@Autowired
	private AlunoRepository repository;
	
	// Método para cadastrar um novo aluno com base nos dados fornecidos.
	public String cadastrarAluno(DadosAluno dados) {

		// Verifica se já existe um aluno com o CPF fornecido.
		var aluno = repository.findByCpf(dados.cpf());
		
		if (aluno.isPresent()) {
			return "Aluno já existe.";
		} else {
			// Se o aluno não existir, salva os dados do novo aluno.
			repository.save(new AlunoModel(dados));
			return "Cadastro efetuado com sucesso!";
		}
	}
	
	// Método para encontrar todos os alunos cadastrados.
	public List<AlunoModel> encontrarAlunos() {
		return repository.findAll();
	}
	
	// Método para encontrar um aluno por seu ID.
	public Optional<AlunoModel> encontrarUmAlunoPorId(Long id) {
		return repository.findById(id);
	}
	
	// Método para atualizar os dados de um aluno.
	public void atualizarAluno(AlunoModel aluno) {
		repository.save(aluno);
	}
	
	// Método para deletar um aluno por seu ID.
	public void deletarAlunoPorId(Long id) {
        repository.deleteById(id);
    }

}
