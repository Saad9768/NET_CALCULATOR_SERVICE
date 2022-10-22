package com.java.gsg.calulator.service.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.springframework.stereotype.Service;

import com.java.gsg.calulator.data.TaxRateProvider;
import com.java.gsg.calulator.service.NetCalculatorService;

@Service
public class NetCalculatorServiceImpl implements NetCalculatorService {

	@Override
	public Double calculateNetPrice(Double grossPrice, TaxRateProvider countryIso) {
		if (grossPrice != null && grossPrice.equals(0.0)) {
			// This logic will return zero. Consumer will handled zero accordingly
			return 0.0;
		} else if (grossPrice != null) {
			Double result = grossPrice / (1 + countryIso.getValue());
			return BigDecimal.valueOf(result).setScale(2, RoundingMode.HALF_UP).doubleValue();
		} else {
			return null;
		}
	}

}
