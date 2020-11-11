package br.usjt.academico.ui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import br.usjt.academico.service.UsuarioService;

public class LoginTela {
	JFrame tela = new JFrame("Sistema Acadêmico");
	JTextField loginTF = new JTextField(10);
	JPasswordField senhaPF = new JPasswordField(10);
	JButton sairBT = new JButton("Sair");
	JButton loginBT = new JButton("Login");

	private Container criarInput() {
		Container input = new Container();
		loginTF.setSize(270, 54);
		loginTF.setBorder(BorderFactory.createTitledBorder("Digite seu login"));
		senhaPF.setBorder(BorderFactory.createTitledBorder("Digite sua senha"));
		sairBT.addActionListener((e) -> {
			tela.dispose();
		});
		input.setLayout(new GridLayout(2, 1, 20, 0));
		input.add(loginTF);
		input.add(senhaPF);
		return input;
	}

	private Container criarAcoes() {
		Container acoes = new Container();
		acoes.setLayout(new GridLayout(1, 2, 0, 20));
		acoes.add(sairBT);
		acoes.add(loginBT);
		loginBT.addActionListener((e) -> {
			UsuarioService usuarioService = new UsuarioService();
			if (usuarioService.temUsuario(loginTF.getText(), new String(senhaPF.getPassword()))) {
				JOptionPane.showMessageDialog(null, "Bem vindo!");
			} else {
				JOptionPane.showMessageDialog(null, "Usuário inválido");
			}
		});
		return acoes;
	}

	public void criarTela() {
		tela.getContentPane().setLayout(new BorderLayout());
		tela.getContentPane().add(criarInput(), BorderLayout.CENTER);
		tela.getContentPane().add(criarAcoes(), BorderLayout.SOUTH);
		tela.pack();
		tela.setLocationRelativeTo(null);
		tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tela.setVisible(true);
	}
}
