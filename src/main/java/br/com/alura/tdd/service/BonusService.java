package br.com.alura.tdd.service;

import java.math.BigDecimal;
import java.math.RoundingMode;

import br.com.alura.tdd.modelo.Funcionario;

public class BonusService {

	public BigDecimal calcularBonus(Funcionario funcionario) {
		if (funcionario.getSalario().compareTo(BigDecimal.valueOf(10000)) > 0) {
			throw new IllegalArgumentException("Funcion�rio com sal�rio maior que R$10000,00 n�o recebem bonus.");
		}
		return funcionario.getSalario().multiply(new BigDecimal("0.1")).setScale(2, RoundingMode.HALF_UP);
	}
}
