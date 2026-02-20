package br.com.faculdadedonaduzzi.lab.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String descricao;
    private String prazo;

    @Enumerated(EnumType.STRING)
    private TaskStatus status;

}
