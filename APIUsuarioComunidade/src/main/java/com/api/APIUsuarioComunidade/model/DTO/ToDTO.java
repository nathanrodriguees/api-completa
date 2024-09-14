package com.api.APIUsuarioComunidade.model.DTO;

import com.api.APIUsuarioComunidade.model.Usuario;

public class ToDTO {

	public class UsuarioConverter {
		public static UsuarioDTO toDTO(Usuario usuario) {
			return new UsuarioDTO(usuario.getId(), usuario.getNome(), usuario.getEmail(), usuario.getIdImage());
		}
	}
	
}
