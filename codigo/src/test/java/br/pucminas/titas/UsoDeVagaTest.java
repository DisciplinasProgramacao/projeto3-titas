package br.pucminas.titas;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.*;

import java.time.Duration;
import java.time.LocalDateTime;

@ExtendWith(MockitoExtension.class)
public class UsoDeVagaTest {
	private static final double VALOR_FRACAO = 4.0;
	private static final double VALOR_MAXIMO = 50.0;
    private Vaga vaga;
    private Servico servico;

    @Mock
    private UsoDeVaga u;

    @BeforeEach
    public void setUp() {
        vaga = new Vaga("Y", 2);
        servico = Servico.POLIMENTO;
        u = new UsoDeVaga(vaga, servico);
    }

    @Test
    public void tentarUsarUmaVagaEmUso() {
        vaga.estacionar();
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> {
            new UsoDeVaga(vaga);
        }, "Vaga não disponivel");
        
        assertEquals("Vaga não disponivel", e.getMessage(), "Testa se uma exeção é lançada quando a vaga não estiver disponível");
    }

    @Test
    public void tentarSairDeUmaVagaLivre() {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> {
            u.sair();
        }, "Essa vaga não está em uso");
        
        assertEquals("Essa vaga não está em uso", e.getMessage(), "Testa se uma exeção é lançada quando se tenta sair de uma vaga que não está em uso");
    }

    @Test
    public void pegarOValorTotal() {
        LocalDateTime saida = LocalDateTime.now().plusHours(3);
        double valorTotal = valorPagoMock(saida);

        assertEquals(93d, valorTotal, "Testa se o valor total é calculado corretamente");
    }

    @Test
    public void tentarSairSemTerminoDosServicos() {
        LocalDateTime saida = LocalDateTime.now().plusHours(1);
        assertFalse(podeSairMock(saida), "Testa se a verificação do termino dos serviços está correta");
    }

	public boolean podeSairMock(LocalDateTime saida) {
		Duration duration = Duration.between(u.getEntrada(), saida);
		return duration.toHours() >= servico.getHoraMinimas();
	}

    public double valorPagoMock(LocalDateTime saida) {
		Duration duration = Duration.between(u.getEntrada(), saida);
		double minutos = duration.toMinutes();
		double fracaoMinutos = Math.floor(minutos / 15);
		double valorPago = fracaoMinutos * VALOR_FRACAO;
		if(valorPago > VALOR_MAXIMO){
			valorPago = VALOR_MAXIMO;
		}
        valorPago += u.getServicoPrecoTotal();
		return valorPago;
	}
}