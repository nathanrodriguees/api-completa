package com.api.APIUsuarioComunidade.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document(collection = "comunidade")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Comunidade {

	@Id
	private String id;
	
	@NotBlank(message = "O nome é obrigatório")
	private String nome;
	
	@Override
	public String toString() {
	    return "Comunidade { " +
	            "id='" + id + '\'' +
	            ", nome='" + nome + '\'' +
	            " }";
	}
}
