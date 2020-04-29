package com.gerenciadortarefas.resource;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.gerenciadortarefas.domain.Tarefa;
import com.gerenciadortarefas.service.TarefaService;

@RestController
@RequestMapping("/tarefas")
public class TarefaResource {

	@Autowired
	private TarefaService tarefaService;

	@GetMapping
	public ResponseEntity<List<Tarefa>> findAll() {
		return ResponseEntity.ok().body(tarefaService.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Tarefa> findById(@PathVariable Long id) {
		return ResponseEntity.ok().body(tarefaService.findById(id));
	}

	@PostMapping
	public ResponseEntity<Tarefa> insert(@RequestBody Tarefa tarefa) {
		tarefa = tarefaService.insert(tarefa);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(tarefa.getId()).toUri();
		return ResponseEntity.created(uri).body(tarefa);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Tarefa> update(@PathVariable Long id, @RequestBody Tarefa tarefa) {
		return ResponseEntity.ok().body(tarefaService.update(id, tarefa));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		tarefaService.delete(id);
		return ResponseEntity.noContent().build();
	}

}
