package br.com.alura.tdd.teste.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.com.alura.tdd.modelo.Funcionario;
import br.com.alura.tdd.service.BonusService;

public class BonusServiceTest {

	BonusService bonusService = new BonusService(); 
	
	@Test
    @DisplayName("Testa se o valor do bonus é igual ao esperado")
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

}
