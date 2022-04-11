package br.com.alura.tdd.service;

import java.math.BigDecimal;
import java.math.RoundingMode;

import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;

public class BonusService {

	public BigDecimal calcularBonus(Funcionario funcionario) {
		if (funcionario.getSalario().compareTo(BigDecimal.valueOf(10000)) > 0) {
			throw new IllegalArgumentException("Funcionário com salário maior que R$10000,00 não recebem bonus.");
		}
		return funcionario.getSalario().multiply(new BigDecimal("0.1")).setScale(2, RoundingMode.HALF_UP);
	}

	public void ajustarSalarioConformeDesempenho(Desempenho desempenho, Funcionario funcionario) {
		funcionario.setSalario(calcularAjusteSalario(funcionario.getSalario(), desempenho.percentualReajuste()));
	}

	public BigDecimal calcularAjusteSalario(BigDecimal percent, BigDecimal salario) {
		return salario.multiply(percent);
	}

}
