package br.usjt.academico.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Optional;

import br.usjt.academico.bd.ConnectionFactory;
import br.usjt.academico.model.Usuario;

public class UsuarioDAO {
	public Optional<Usuario> obterUsuario(String loginProcurado) {
		String sql = "select * from tb_usuario where login = ?";
		try (PreparedStatement ps = ConnectionFactory.obterConexao().prepareStatement(sql)) {
			ps.setString(1, loginProcurado);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String login = rs.getString("login");
				String senha = rs.getString("senha");
				return Optional.of(new Usuario(id, login, senha));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Optional.empty();
	}
}
