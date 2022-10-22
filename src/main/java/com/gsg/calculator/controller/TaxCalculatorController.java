package com.gsg.calculator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gsg.calculator.data.TaxRateProvider;
import com.gsg.calculator.model.ResponseObject;
import com.gsg.calculator.service.NetCalculatorService;

@RestController
@RequestMapping("/v1/api")
public class TaxCalculatorController {
	@Autowired

	private NetCalculatorService netCalculatorService;

	@GetMapping("/calculate/netamount")
	public ResponseEntity<ResponseObject> calculateNetAmount(@RequestParam Double grossPrice,
			@RequestParam TaxRateProvider countryIso) {
		ResponseObject responseObject = new ResponseObject();
		try {
			if (grossPrice.equals(0.0)) {
				responseObject.setStatus("Bad Reuest");
				responseObject.setError("Value should greater than zero");
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseObject);
			}
			Double result = netCalculatorService.calculateNetPrice(grossPrice, countryIso);
			if (result != null) {
				responseObject.setStatus("Success");
				responseObject.setResult(result);
				return ResponseEntity.status(HttpStatus.OK).body(responseObject);
			} else {
				responseObject.setStatus("Bad Reuest");
				responseObject.setError("Value should not be null");
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseObject);
			}
		} catch (Exception e) {
			responseObject.setStatus("Failure");
			responseObject.setError(e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseObject);
		}

	}

}
