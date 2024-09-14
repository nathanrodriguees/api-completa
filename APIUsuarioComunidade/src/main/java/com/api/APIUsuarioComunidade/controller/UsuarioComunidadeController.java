package com.api.APIUsuarioComunidade.controller;

import java.util.List;
import java.util.Optional;

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

import com.api.APIUsuarioComunidade.model.UsuarioComunidade;
import com.api.APIUsuarioComunidade.repository.UsuarioComunidadeRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/usuario_comunidade")
public class UsuarioComunidadeController {

	@Autowired
	UsuarioComunidadeRepository repository;
	
	@GetMapping
    public ResponseEntity<List<UsuarioComunidade>> getUsuarioComunidades() {
        List<UsuarioComunidade> usuarioComunidades = repository.findAll();
        System.out.println("Get UsuarioComunidades: "+ usuarioComunidades.toString());
        return ResponseEntity.ok(usuarioComunidades);
    }
	
	@GetMapping("/{id}")
    public ResponseEntity<UsuarioComunidade> getUsuarioComunidadeById(@PathVariable String id) {
        Optional<UsuarioComunidade> usuarioComunidade = repository.findById(id);

        if (usuarioComunidade.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            System.out.println("Get UsuarioComunidade:"+ usuarioComunidade.get().toString());
            return ResponseEntity.ok(usuarioComunidade.get());
        }
    }
	
	@PostMapping
    public ResponseEntity<UsuarioComunidade> insert(@RequestBody @Valid UsuarioComunidade usuarioComunidade) {
        UsuarioComunidade savedUsuarioComunidade = repository.save(usuarioComunidade);

        System.out.println("Inseriu:" + savedUsuarioComunidade.toString());

        return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedUsuarioComunidade.getId()).toUri()).body(savedUsuarioComunidade);
    }
	
	 @PutMapping("/{id}")
	    public ResponseEntity<UsuarioComunidade> update(@PathVariable String id, @RequestBody @Valid UsuarioComunidade usuarioComunidade) {

	        Optional<UsuarioComunidade> usuarioComunidadeExistente = repository.findById(id);
	        if (usuarioComunidadeExistente.isEmpty()) {
	            return ResponseEntity.notFound().build();
	        }

	        UsuarioComunidade usuarioComunidadeAtualizado = usuarioComunidadeExistente.get();
	        usuarioComunidadeAtualizado.setIdUsuario(usuarioComunidade.getIdUsuario());
	        usuarioComunidadeAtualizado.setIdComunidade(usuarioComunidade.getIdComunidade());

	        try {
	            repository.save(usuarioComunidadeAtualizado);
	            System.out.println("Alterou: " + usuarioComunidadeAtualizado.toString());
	            return ResponseEntity.ok(usuarioComunidadeAtualizado);
	        } catch (Exception error) {
	            System.out.println("Erro ao atualizar UsuarioComunidade com id:" + id + "; " + error.getMessage());
	            return ResponseEntity.status(500).build();
	        }
	    }
	 
	 @DeleteMapping("/{id}")
	    public ResponseEntity<Void> delete(@PathVariable String id) {

	        Optional<UsuarioComunidade> usuarioComunidadeExistente = repository.findById(id);
	        if (usuarioComunidadeExistente.isEmpty()) {
	            return ResponseEntity.notFound().build();
	        }

	        System.out.println("Deletou: " + usuarioComunidadeExistente.toString());

	        repository.deleteById(id);
	        return ResponseEntity.noContent().build();
	    }
}
