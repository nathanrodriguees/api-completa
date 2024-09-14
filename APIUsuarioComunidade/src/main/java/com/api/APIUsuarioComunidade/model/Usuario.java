package com.api.APIUsuarioComunidade.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document(collection = "usuario")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {

	@Id
	private String id;
	
	@NotBlank(message = "O nome é obrigatório")
	@Size(min = 3, max = 50, message = "O nome deve ter entre 3 e 50 caracteres")
	private String nome;
	
	@NotBlank(message = "O email é Obrigatório")
	@Email(message = "Email deve ser válido")
	private String email;
	
	@NotBlank(message = "A senha é obrigatória")
	@Size(min = 6, message = "A senha deve ter no mínimo 6 caracteres")
	private String senha;

	private int idImage;
	
	@Override
    public String toString() {
        return "Usuario { " +
                "id='" + id + '\'' +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", image='" + idImage + '\'' +
                " }";
    }
	
}
