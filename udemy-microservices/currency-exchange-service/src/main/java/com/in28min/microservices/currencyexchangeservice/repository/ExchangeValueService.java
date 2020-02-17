package com.in28min.microservices.currencyexchangeservice.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.in28min.microservices.currencyexchangeservice.bean.ExchangeValue;

/**
 * Service layer which connects with the repository layer
 *
 * @author Aniket Bharsakale
 */
@Service
public class ExchangeValueService {

	@Autowired
	private IExchangeValueRepository exchangeValueRepo;

	public ExchangeValue retrieveExchangeValue(String from, String to) {
		ExchangeValue exchangeValue = null;
		if ((null != from && !from.isEmpty()) && (null != to && !to.isEmpty()))
			exchangeValue = exchangeValueRepo.findByFromAndTo(from, to);
		// TODO: else Throw customized exception
		return exchangeValue;
	}
}
