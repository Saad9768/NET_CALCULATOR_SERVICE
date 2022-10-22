package com.java.gsg.calulator.service;

import com.java.gsg.calulator.data.TaxRateProvider;

public interface NetCalculatorService {
	Double calculateNetPrice(Double grossPrice, TaxRateProvider countryIso);
}
