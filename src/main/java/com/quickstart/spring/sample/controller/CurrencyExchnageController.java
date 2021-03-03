package com.quickstart.spring.sample.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.quickstart.spring.sample.bean.CurrencyExchange;

@RestController
public class CurrencyExchnageController {
	
	@Autowired
	private Environment environment;
	
	@GetMapping("/currency-exchange/from/{from}/to/{to}")                   
	public CurrencyExchange getCurrencyValue(@PathVariable String from,@PathVariable String to)
	{
		String port = environment.getProperty("local.server.port");
		CurrencyExchange currencyExchange = new CurrencyExchange(1001L,from,to,BigDecimal.valueOf(65));
		currencyExchange.setEnvironment(port);
		return currencyExchange;
	}

}
