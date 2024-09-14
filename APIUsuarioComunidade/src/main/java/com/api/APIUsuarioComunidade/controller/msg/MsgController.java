package com.api.APIUsuarioComunidade.controller.msg;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.api.APIUsuarioComunidade.model.msg.Msg;
import com.api.APIUsuarioComunidade.repository.msg.MsgRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/msg")
@CrossOrigin(origins = "*")
public class MsgController {

	@Autowired
	MsgRepository repository;
	
	@GetMapping
    public ResponseEntity<List<Msg>> getMensagens() {
        List<Msg> mensagens = repository.findAll();
        System.out.println("Get Mensagens: " + mensagens.toString());
        return ResponseEntity.ok(mensagens);
    }
	
	@GetMapping("/{id}")
    public ResponseEntity<Msg> getMensagemById(@PathVariable String id) {
        Optional<Msg> mensagem = repository.findById(id);

        if (mensagem.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            System.out.println("Get Mensagem: " + mensagem.get().toString());
            return ResponseEntity.ok(mensagem.get());
        }
    }
	
	@PostMapping
    public ResponseEntity<Msg> insert(@RequestBody @Valid Msg mensagem) {
        Msg savedMsg = repository.save(mensagem);
        System.out.println("Inseriu: " + savedMsg.toString());

        return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedMsg.getId()).toUri()).body(savedMsg);
    }
	
	@PutMapping("/{id}")
	public ResponseEntity<Msg> update(@PathVariable String id, @RequestBody @Valid Msg mensagem) {

        Optional<Msg> mensagemExistente = repository.findById(id);
        if (mensagemExistente.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Msg mensagemAtualizada = mensagemExistente.get();
        mensagemAtualizada.setConteudo(mensagem.getConteudo());
        mensagemAtualizada.setIdUsuario(mensagem.getIdUsuario());
        mensagemAtualizada.setIdComunidade(mensagem.getIdComunidade());

        try {
            repository.save(mensagemAtualizada);
            System.out.println("Alterou: " + mensagemAtualizada.toString());
            return ResponseEntity.ok(mensagemAtualizada);
        } catch (Exception error) {
            System.out.println("Erro ao atualizar Msg com id:" + id + "; " + error.getMessage());
            return ResponseEntity.status(500).build();
        }
    }
	
	@DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {

        Optional<Msg> mensagemExistente = repository.findById(id);
        if (mensagemExistente.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        System.out.println("Deletou: " + mensagemExistente.toString());

        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
	
}
