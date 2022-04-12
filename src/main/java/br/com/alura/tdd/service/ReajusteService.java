package br.com.alura.tdd.service;

import java.math.BigDecimal;

import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;

public class ReajusteService {
	
	public void ajustarSalarioConformeDesempenho(Desempenho desempenho, Funcionario funcionario) {
		funcionario.setSalario(calcularAjusteSalario(funcionario.getSalario(), desempenho.percentualReajuste()));
	}

	public BigDecimal calcularAjusteSalario(BigDecimal percent, BigDecimal salario) {
		return salario.multiply(percent);
	}
}
