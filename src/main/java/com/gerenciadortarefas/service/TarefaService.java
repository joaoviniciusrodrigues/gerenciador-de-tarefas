package com.gerenciadortarefas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gerenciadortarefas.domain.Tarefa;
import com.gerenciadortarefas.repository.TarefaRepository;

@Service
public class TarefaService {

	@Autowired
	private TarefaRepository tarefaRepository;

	public List<Tarefa> findAll() {
		return tarefaRepository.findAll();
	}

	public Tarefa insert(Tarefa tarefa) {
		return tarefaRepository.save(tarefa);
	}

	public void delete(Long id) {
		tarefaRepository.deleteById(id);
	}
	
	public Tarefa update(Long id, Tarefa tarefa) {
		tarefa.setId(id);
		return tarefaRepository.save(tarefa);
	}
	
	public Tarefa findById(Long id) {
		return tarefaRepository.findById(id).get();
	}

}
