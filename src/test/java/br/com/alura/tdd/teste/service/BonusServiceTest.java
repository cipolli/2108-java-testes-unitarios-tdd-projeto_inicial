package br.com.alura.tdd.teste.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;
import br.com.alura.tdd.service.BonusService;

public class BonusServiceTest {

	BonusService bonusService = new BonusService(); 
	
	@Test
    @DisplayName("Should be equal")
	public void DeveriaCalcularBonus() {
		Funcionario funcionario = new Funcionario("Teste", LocalDate.now(), BigDecimal.valueOf(10000L));
		BigDecimal bonus = bonusService.calcularBonus(funcionario);
		assertEquals(BigDecimal.valueOf(1000).setScale(2), bonus);	
	}
	
	@Test
	@DisplayName("Should be equal]")
	public void bonusDeveriaSerZEROQuandoMaiorQue10Mil() {
		
		Funcionario funcionario = new Funcionario("Teste ", LocalDate.of(2020, 8, 14), BigDecimal.valueOf(10001L));
		assertThrows(IllegalArgumentException.class, () -> bonusService.calcularBonus(funcionario));
		
		
	}

	@Test
	@DisplayName("deve receber ajuste 3%")
	public void deveriaReceberReajuste3PorCentoQuandoDesempenhoADesejar() {
		Funcionario funcionario = new Funcionario("Teste ", LocalDate.of(2020, 8, 14), BigDecimal.valueOf(1000));
		bonusService.ajustarSalarioConformeDesempenho(Desempenho.A_DESEJAR, funcionario);
		
		assertEquals(BigDecimal.valueOf(1030.00).setScale(2, RoundingMode.HALF_UP), funcionario.getSalario());
	}
	
	@Test
	@DisplayName("deve receber ajuste 10%")
	public void deveriaReceberReajuste10PorCentoQuandoDesempenhoADesejar() {
		Funcionario funcionario = new Funcionario("Teste ", LocalDate.of(2020, 8, 14), BigDecimal.valueOf(1000));
		bonusService.ajustarSalarioConformeDesempenho(Desempenho.BOM, funcionario);
		
		assertEquals(BigDecimal.valueOf(1100.00).setScale(2, RoundingMode.HALF_UP), funcionario.getSalario());
	}
	
	@Test
	@DisplayName("deve receber ajuste 15%")
	public void deveriaReceberReajuste15PorCentoQuandoDesempenhoADesejar() {
		Funcionario funcionario = new Funcionario("Teste ", LocalDate.of(2020, 8, 14), BigDecimal.valueOf(1000));
		bonusService.ajustarSalarioConformeDesempenho(Desempenho.OTIMO, funcionario);
		
		assertEquals(BigDecimal.valueOf(1150.00).setScale(2, RoundingMode.HALF_UP), funcionario.getSalario());
	}
}
