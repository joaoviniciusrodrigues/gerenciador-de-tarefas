package com.gerenciadortarefas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gerenciadortarefas.domain.Tarefa;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {

}
