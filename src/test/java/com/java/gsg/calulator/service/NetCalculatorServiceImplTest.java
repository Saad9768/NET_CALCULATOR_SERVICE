package com.java.gsg.calulator.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.java.gsg.calulator.data.TaxRateProvider;
import org.junit.jupiter.api.Assertions;

@SpringBootTest
public class NetCalculatorServiceImplTest {

	@Autowired
	private NetCalculatorService netCalculatorService;

	@Test
	public void calculateNetPrice() {

		Double result = netCalculatorService.calculateNetPrice(100.0, TaxRateProvider.DE);
		Assertions.assertEquals(result, 84.03);

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
