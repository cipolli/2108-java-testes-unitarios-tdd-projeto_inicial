package br.com.alura.tdd.teste.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;
import br.com.alura.tdd.service.ReajusteService;

public class ReajusteServiceTest {
	
	ReajusteService reajusteService = new ReajusteService();
	Funcionario funcionario;
	@BeforeEach
	private void init() {
		funcionario = new Funcionario("Teste ", LocalDate.of(1999, 8, 14), BigDecimal.valueOf(1000));
	}
	

	@Test
	@DisplayName("deve receber ajuste 3%")
	public void deveriaReceberReajuste3PorCentoQuandoDesempenhoADesejar() {
		reajusteService.ajustarSalarioConformeDesempenho(Desempenho.A_DESEJAR, funcionario);
		assertEquals(BigDecimal.valueOf(1030.00).setScale(2, RoundingMode.HALF_UP), funcionario.getSalario());
	}
	
	@Test
	@DisplayName("deve receber ajuste 10%")
	public void deveriaReceberReajuste10PorCentoQuandoDesempenhoADesejar() {
		reajusteService.ajustarSalarioConformeDesempenho(Desempenho.BOM, funcionario);
		assertEquals(BigDecimal.valueOf(1100.00).setScale(2, RoundingMode.HALF_UP), funcionario.getSalario());
	}
	
	@Test
	@DisplayName("deve receber ajuste 15%")
	public void deveriaReceberReajuste15PorCentoQuandoDesempenhoADesejar() {
		reajusteService.ajustarSalarioConformeDesempenho(Desempenho.OTIMO, funcionario);
		assertEquals(BigDecimal.valueOf(1150.00).setScale(2, RoundingMode.HALF_UP), funcionario.getSalario());
	}
}
