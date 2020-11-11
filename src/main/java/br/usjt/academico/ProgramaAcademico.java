package br.usjt.academico;

import javax.swing.SwingUtilities;

import br.usjt.academico.ui.LoginTela;

public class ProgramaAcademico {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			LoginTela lt = new LoginTela();
			lt.criarTela();
		});
	}
}
