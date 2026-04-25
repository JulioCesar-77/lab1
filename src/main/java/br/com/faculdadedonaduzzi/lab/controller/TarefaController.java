package br.com.faculdadedonaduzzi.lab.controller;

import br.com.faculdadedonaduzzi.lab.dto.TarefaDTO;
import br.com.faculdadedonaduzzi.lab.dto.TarefaResponseDTO;
import br.com.faculdadedonaduzzi.lab.entity.Task;
import br.com.faculdadedonaduzzi.lab.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {

    @Autowired
    private TaskRepository taskRepository;

    @GetMapping("/version")
    public String getVersion() {
        return "v1.0.0";
    }

    @GetMapping
    public List<TarefaResponseDTO> getTasks() {
        return taskRepository.findAll().stream().map(TarefaResponseDTO::new).toList();
    }

    @PostMapping
    public TarefaResponseDTO save(@RequestBody TarefaDTO task) {
        Task newTask = new Task();
        newTask.setTitulo(task.titulo());
        newTask.setDescricao(task.descricao());
        newTask.setStatus(task.status());
        Task savedTask = taskRepository.save(newTask);
        return new TarefaResponseDTO(savedTask);
    }

    @PutMapping("/{id}")
    public TarefaResponseDTO update(@PathVariable Long id, @RequestBody TarefaDTO task) {
        Task newTask = taskRepository.findById(id).orElseThrow();
        newTask.setTitulo(task.titulo());
        newTask.setDescricao(task.descricao());
        newTask.setStatus(task.status());
        Task savedTask = taskRepository.save(newTask);
        return new TarefaResponseDTO(savedTask);
    }

    //Saúde
    @GetMapping("/health2")
    public String health() {
        return "OK";
    }

}
