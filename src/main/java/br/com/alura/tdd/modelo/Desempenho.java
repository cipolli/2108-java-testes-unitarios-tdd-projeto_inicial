package br.com.alura.tdd.modelo;

import java.math.BigDecimal;

public enum Desempenho {
	A_DESEJAR {
		@Override
		public BigDecimal percentualReajuste() {
			return BigDecimal.valueOf(1.03);
		}
	},
	BOM {
		@Override
		public BigDecimal percentualReajuste() {
			return BigDecimal.valueOf(1.10);
		}
	},
	OTIMO {
		@Override
		public BigDecimal percentualReajuste() {
			return BigDecimal.valueOf(1.15);
		}
	};

	public abstract BigDecimal percentualReajuste();

}
