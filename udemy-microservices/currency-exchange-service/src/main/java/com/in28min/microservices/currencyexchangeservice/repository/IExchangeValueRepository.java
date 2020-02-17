package com.in28min.microservices.currencyexchangeservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.in28min.microservices.currencyexchangeservice.bean.ExchangeValue;

/**
 * IExchangeRepository represents the database layer connection for 
 * model ExchangeValue with table: exchange_value in database
 *
 * @author Aniket Bharsakale
 */
@Repository
public interface IExchangeValueRepository extends JpaRepository<ExchangeValue, Long> {

	public ExchangeValue findByFromAndTo(String from, String to);
}
