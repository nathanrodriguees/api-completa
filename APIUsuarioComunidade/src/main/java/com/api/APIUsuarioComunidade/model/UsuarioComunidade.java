package com.api.APIUsuarioComunidade.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document(collection = "usuario_comunidade")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioComunidade {

	@Id
	private String id;
	
	private String idUsuario;
	private String idComunidade;
	
	@Override
	public String toString() {
	    return "UsuarioComunidade { " +
	           "id='" + id + '\'' +
	           ", idUsuario='" + idUsuario + '\'' +
	           ", idComunidade='" + idComunidade + '\'' +
	           " }";
	}

	
}
