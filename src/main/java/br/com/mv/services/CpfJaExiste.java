package br.com.mv.services;

public class CpfJaExiste extends Exception {
	public CpfJaExiste(String cpf) {
		super("CPF já exite: " + cpf);
	}

}
