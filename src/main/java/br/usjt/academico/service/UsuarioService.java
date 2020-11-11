package br.usjt.academico.service;

import java.util.Optional;

import br.usjt.academico.dao.UsuarioDAO;
import br.usjt.academico.model.Usuario;

public class UsuarioService {
	UsuarioDAO usuarioDAO = new UsuarioDAO();

	public boolean temUsuario(String login, String senha) {
		Optional<Usuario> opUsuario = usuarioDAO.obterUsuario(login);
		return opUsuario.isPresent() && opUsuario.get().getSenha().equals(senha);
	}
}
