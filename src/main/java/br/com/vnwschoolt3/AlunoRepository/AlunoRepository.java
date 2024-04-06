package br.com.vnwschoolt3.AlunoRepository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.vnwschoolt3.model.AlunoModel;

// Esta anotação marca esta interface como um componente gerenciado pelo Spring, indicando que é um repositório de dados.
@Repository
public interface AlunoRepository extends JpaRepository<AlunoModel, Long> {

    // Este método procura um aluno por CPF.
    // Retorna um Optional, que pode conter um AlunoModel se encontrado, ou estar vazio se não encontrado.
    Optional<AlunoModel> findByCpf(String cpf);
}
