package com.gsg.calculator.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.gsg.calculator.data.TaxRateProvider;

@SpringBootTest
public class NetCalculatorServiceImplTest {

	Logger logger = LoggerFactory.getLogger(NetCalculatorServiceImplTest.class);

	@Autowired
	private NetCalculatorService netCalculatorService;

	@Test
	public void calculateNetPriceDE() {
		logger.debug("Running Test case calculateNetPriceDE");
		Double result = netCalculatorService.calculateNetPrice(100.0, TaxRateProvider.DE);
		Assertions.assertEquals(result, 84.03);
	}

	@Test
	public void calculateNetPriceFR() {
		logger.debug("Running Test case calculateNetPriceFR");
		Double result = netCalculatorService.calculateNetPrice(120.0, TaxRateProvider.FR);
		Assertions.assertEquals(result, 100);
	}

	@Test
	public void calculateNetPriceIN() {
		logger.debug("Running Test case calculateNetPriceIN");
		Double result = netCalculatorService.calculateNetPrice(118.0, TaxRateProvider.IN);
		Assertions.assertEquals(result, 100);
	}

	@Test
	public void calculateNetPriceWithNull() {
		logger.debug("Running Test case calculateNetPriceWithNull");
		Double result = netCalculatorService.calculateNetPrice(null, TaxRateProvider.DE);
		Assertions.assertEquals(result, null);
	}

	@Test
	public void calculateNetPriceWithZero() {
		logger.debug("Running Test case calculateNetPriceWithZero");
		Double result = netCalculatorService.calculateNetPrice(0.0, TaxRateProvider.DE);
		Assertions.assertEquals(result, 0.0);
	}

}
