package com.java.gsg.calculator.service.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.springframework.stereotype.Service;

import com.java.gsg.calculator.data.TaxRateProvider;
import com.java.gsg.calculator.service.NetCalculatorService;

@Service
public class NetCalculatorServiceImpl implements NetCalculatorService {

	// calculate net price from the gross price according to country
	@Override
	public Double calculateNetPrice(Double grossPrice, TaxRateProvider countryIso) {
		if (grossPrice != null && grossPrice.equals(0.0)) {
			// This logic will return zero. Consumer will handled zero accordingly
			return 0.0;
		} else if (grossPrice != null) {
			Double result = grossPrice / (1 + countryIso.getValue());
			// precision is set to 2 because in the actual financial world we use upto 2
			int precision = 2;
			return BigDecimal.valueOf(result).setScale(precision, RoundingMode.HALF_UP).doubleValue();
		} else {
			return null;
		}
	}

}
