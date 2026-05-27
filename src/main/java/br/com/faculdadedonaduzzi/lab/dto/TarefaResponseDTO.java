package br.com.faculdadedonaduzzi.lab.dto;

import br.com.faculdadedonaduzzi.lab.entity.Task;
import br.com.faculdadedonaduzzi.lab.entity.TaskStatus;

public record TarefaResponseDTO(
        Long id,
        String titulo,
        String descricao,
        TaskStatus status
) {
        public TarefaResponseDTO (Task task){
            this(task.getId(), task.getTitulo(), task.getDescricao(), task.getStatus());
        }
}
