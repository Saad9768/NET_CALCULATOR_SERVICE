package com.gsg.calculator.service;

import com.gsg.calculator.data.TaxRateProvider;

public interface NetCalculatorService {
	Double calculateNetPrice(Double grossPrice, TaxRateProvider countryIso);
}
