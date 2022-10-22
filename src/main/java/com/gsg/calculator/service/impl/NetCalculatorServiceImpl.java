package com.gsg.calculator.service.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.gsg.calculator.data.TaxRateProvider;
import com.gsg.calculator.service.NetCalculatorService;

@Service
public class NetCalculatorServiceImpl implements NetCalculatorService {
	Logger logger = LoggerFactory.getLogger(NetCalculatorServiceImpl.class);

	// calculate net price from the gross price according to country
	@Override
	public Double calculateNetPrice(Double grossPrice, TaxRateProvider countryIso) {
		logger.debug("Inside calculateNetPrice");
		if (grossPrice != null && grossPrice.equals(0.0)) {
			// This logic will return zero. Consumer will handled zero accordingly
			return 0.0;
		} else if (grossPrice != null) {
			Double result = grossPrice / (1 + countryIso.getValue() * 0.01);
			// precision is set to 2 because in the actual financial world we use upto 2
			int precision = 2;
			return BigDecimal.valueOf(result).setScale(precision, RoundingMode.HALF_UP).doubleValue();
		} else {
			return null;
		}
	}

}
