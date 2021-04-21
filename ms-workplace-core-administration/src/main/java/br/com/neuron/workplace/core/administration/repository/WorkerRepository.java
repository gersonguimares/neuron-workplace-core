package br.com.neuron.workplace.core.administration.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.neuron.workplace.core.administration.entities.Worker;

public interface WorkerRepository extends JpaRepository<Worker, Long> {

}
