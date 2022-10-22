package com.java.gsg.calculator.data;

public enum TaxRateProvider {

	DE(0.19), FR(0.20), IN(0.18);

	private Double value;

	TaxRateProvider(Double value) {
		this.value = value;
	}

	public Double getValue() {
		return value;
	}
}
