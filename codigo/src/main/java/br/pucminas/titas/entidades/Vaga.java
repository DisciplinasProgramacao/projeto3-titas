package br.pucminas.titas.entidades;

import java.io.Serializable;

public class Vaga implements Serializable {

	private String id;
	private boolean disponivel;

	public Vaga(int fila, int numero) {
		this.id = (char) ('A' + (fila - 1)) + String.format("%02d", numero);
		this.disponivel = true;
	}

	/**
	 * Tenta utilizar a vaga
	 * @return true se foi possível | false se não
	 */
	public boolean estacionar() {
		if (disponivel) {
			disponivel = false;
			return true;
		}
		return false;
	}

	/**
	 * Tenta liberar a vaga
	 * @return true se foi possível | false se não
	 */
	public boolean sair() {
		if (!disponivel) {
			disponivel = true;
			return true;
		}
		return false;
	}

	/**
	 * Retorna se a vaga está disponível
	 * @return
	 */
	public boolean disponivel() {
		return disponivel;
	}

	/**
	 * Confere se uma vaga é igual a outra baseado no seu id.
	 *
	 * @param vaga vaga a ser comparada
	 * @return se vaga for igual retorna true, se não, false
	 */
	public boolean equals(Vaga vaga) {
		return this.id.equals(vaga.id);
	}

	@Override
	public String toString() {
		return this.id + " " + (disponivel ? "(Disponível)" : "(Indisponível)");
	}

}
