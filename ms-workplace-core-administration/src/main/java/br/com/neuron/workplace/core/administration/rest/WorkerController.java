package br.com.neuron.workplace.core.administration.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.neuron.workplace.core.administration.entities.Worker;
import br.com.neuron.workplace.core.administration.repository.WorkerRepository;

@RestController
@RequestMapping("/worker")
public class WorkerController {

	private WorkerRepository workerRepository;
	
	public WorkerController(@Autowired WorkerRepository workerRepository) {
		this.workerRepository = workerRepository;
	}
	
	@GetMapping
	public ResponseEntity<List<Worker>> findAll(){
		List<Worker> workers = workerRepository.findAll();
		return ResponseEntity.ok(workers);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable Long id) {
		Optional<Worker> result = this.workerRepository.findById(id);
		if(result.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(result.get());	
	}
}
