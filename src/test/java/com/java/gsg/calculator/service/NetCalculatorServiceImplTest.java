package com.java.gsg.calculator.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.java.gsg.calculator.data.TaxRateProvider;
import com.java.gsg.calculator.service.NetCalculatorService;

@SpringBootTest
public class NetCalculatorServiceImplTest {

	@Autowired
	private NetCalculatorService netCalculatorService;

	@Test
	public void calculateNetPriceDE() {

		Double result = netCalculatorService.calculateNetPrice(100.0, TaxRateProvider.DE);
		Assertions.assertEquals(result, 84.03);

	}
	
	@Test
	public void calculateNetPriceFR() {

		Double result = netCalculatorService.calculateNetPrice(120.0, TaxRateProvider.FR);
		Assertions.assertEquals(result, 100);

	}
	@Test
	public void calculateNetPriceIN() {

		Double result = netCalculatorService.calculateNetPrice(118.0, TaxRateProvider.IN);
		Assertions.assertEquals(result, 100);

	}

	@Test
	public void calculateNetPriceWithNull() {

		Double result = netCalculatorService.calculateNetPrice(null, TaxRateProvider.DE);
		Assertions.assertEquals(result, null);

	}

	@Test
	public void calculateNetPriceWithZero() {

		Double result = netCalculatorService.calculateNetPrice(0.0, TaxRateProvider.DE);
		Assertions.assertEquals(result, 0.0);

	}

}
