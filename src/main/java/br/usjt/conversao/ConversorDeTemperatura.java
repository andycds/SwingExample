package br.usjt.conversao;

import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class ConversorDeTemperatura {
	public static void criarTela() {
		JFrame tela = new JFrame("Conversor");
		JTextField celsiusTF = new JTextField(10);
		JLabel celsiusLB = new JLabel("\u00B0C");
		JButton converterBT = new JButton("Converter");
		JLabel valorConvertidoLB = new JLabel("");
		Container painelContainer = tela.getContentPane();
		painelContainer.setLayout(new GridLayout(2, 4, 2, 4));
		painelContainer.add(celsiusTF);
		painelContainer.add(celsiusLB);
		painelContainer.add(converterBT);
		painelContainer.add(valorConvertidoLB);

		converterBT.addActionListener((e) -> {
			double celsius = Double.parseDouble(celsiusTF.getText());
			double fahrenheit = celsius / 5 * 9 + 32;
			valorConvertidoLB.setText(String.format("%.2f\u00B0F", fahrenheit));
		});

		tela.pack();
		tela.setLocationRelativeTo(null);
		tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tela.setVisible(true);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> criarTela());
	}
}
