package br.com.vnwschoolt3.model;

import br.com.vnwschoolt3.dto.DadosAluno;
import br.com.vnwschoolt3.enums.Curso;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data // Utiliza os getters e setters
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "alunos")
public class AlunoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Column(name = "cpf", unique = true, nullable = false)
    private String cpf;

    @Enumerated(EnumType.STRING)
    @Column(name = "curso", nullable = false)
    private Curso curso;

    @Column(name = "telefone", nullable = false)
    private String telefone;

    @Embedded
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco", nullable = false)
    private Endereco endereco;

    public AlunoModel(DadosAluno dados) {
        this.nome = dados.nome();
        this.email = dados.email();
        this.cpf = dados.cpf();
        this.curso = dados.curso();
        this.telefone = dados.telefone();
        this.endereco = dados.endereco();
    }

    // Getters e setters
    // Métodos getters e setters já estão definidos automaticamente pelo Lombok @Data
}
