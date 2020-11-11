package br.usjt.academico.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Usuario {
	private int id;
	private String login;
	private String senha;
}
