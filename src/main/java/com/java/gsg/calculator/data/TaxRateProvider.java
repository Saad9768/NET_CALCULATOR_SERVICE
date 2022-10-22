package com.java.gsg.calculator.data;

public enum TaxRateProvider {
	// value against the country are in percentage; For example the tax in Germany is 19 % 
	DE(19.0), FR(20.0), IN(18.0);

	private Double value;

	TaxRateProvider(Double value) {
		this.value = value;
	}

	public Double getValue() {
		return value;
	}
}
