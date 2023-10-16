package br.pucminas.titas;

import java.util.ArrayList;

public class Estacionamento {

	private String nome;
	private Cliente[] id;
	private Vaga[] vagas;
	private int quantFileiras;
	private int vagasPorFileira;
	private Map<String, Vaga> veiculoVagaMap = new HashMap<>();

	public Estacionamento(String nome, int fileiras, int vagasPorFila) {
	        this.nome = nome;
	        this.id = new Cliente[100];
	        this.vagas = new Vaga[fileiras * vagasPorFila];
	        this.quantFileiras = fileiras;
	        this.vagasPorFileira = vagasPorFila;
		}

    public void addVeiculo(Veiculo veiculo, String idCli) {
        Cliente cliente = encontrarCliente(idCli);
        if (cliente != null) {
            cliente.addVeiculo(veiculo);
        }
    }

    private Cliente encontrarCliente(String idCli) {
		return null;
	}

	public void addCliente(Cliente cliente) {
        Cliente[] novosClientes = new Cliente[id.length + 1];
        System.arraycopy(id, 0, novosClientes, 0, id.length);
        novosClientes[id.length] = cliente;
        id = novosClientes;
    }

    private void gerarVagas() {
        int totalVagas = quantFileiras * vagasPorFileira;
        vagas = new Vaga[totalVagas];
        for (int i = 0; i < totalVagas; i++) {
            vagas[i] = new Vaga("Y" + (i / vagasPorFileira) + (i % vagasPorFileira));
        }
    }

    //Parte responsável pelo aluno Gabriel.

	public void estacionar(String placa) throws EstacionamentoLotadoException {
		boolean vagaEncontrada = false;
		for (Vaga vaga : vagas) {
        		if (vaga != null && vaga.disponivel()) {
            			vaga.estacionar();
            			veiculoVagaMap.put(placa, vaga);
				vagaEncontrada = true;
            			break;
        		}
    		}
		if (!vagaEncontrada) {
        		throw new EstacionamentoLotadoException("Não há vagas disponíveis para estacionar o veículo com placa " + placa);
    		}

	}

	public double sair(String placa) {
		Vaga vaga = veiculoVagaMap.get(placa);
    		if (vaga != null) {
        		vaga.sair();
        		veiculoVagaMap.remove(placa);
		}
	}

	public double totalArrecadado() {
		double total = 0;
        	for (Cliente cliente : id) {
            		total += cliente.arrecadadoTotal();
        	}
        	return total;
	}

	public double arrecadacaoNoMes(int mes) {
	        double total = 0;
        	for (Cliente cliente : id) {
            		total += cliente.arrecadadoNoMes(mes);
        	}
        	return total;
	}

	public double valorMedioPorUso() {
		
	}

	public String top5Clientes(int mes) {
		
	}

}
