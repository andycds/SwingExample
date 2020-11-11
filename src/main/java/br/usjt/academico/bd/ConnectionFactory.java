package br.usjt.academico.bd;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
	private static final String USUARIO = "alunos";
	private static final String SENHA = "alunos";
	private static final String HOST = "localhost";
	private static final String PORTA = "3306";
	private static final String BD = "db_pessoas";

	public static Connection obterConexao() {
		try {
			Connection c = DriverManager.getConnection("jdbc:mysql://" + HOST + ":" + PORTA + "/" + BD, USUARIO, SENHA);
			return c;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
