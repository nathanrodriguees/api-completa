package com.api.APIUsuarioComunidade.model.msg;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document(collection = "chat")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Msg {
	
	@Id
	private String id;
	
	private String conteudo;
	private String idUsuario;
	private String idComunidade;

	@Override
	public String toString() {
	    return "Chat { " +
	           "id='" + id + '\'' +
	           ", conteudo='" + conteudo + '\'' +
	           ", idUsuario='" + idUsuario + '\'' +
	           ", idComunidade='" + idComunidade + '\'' +
	           " }";
	}

	
}
