package com.java.gsg.calculator.service;

import com.java.gsg.calculator.data.TaxRateProvider;

public interface NetCalculatorService {
	Double calculateNetPrice(Double grossPrice, TaxRateProvider countryIso);
}
