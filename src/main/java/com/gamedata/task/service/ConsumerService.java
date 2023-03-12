package com.gamedata.task.service;


import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gamedata.task.models.Bet;

@Service
public class ConsumerService {
	@KafkaListener(topics = "bet_detail", groupId = "group_id")
	public void consume(String message) {
		System.out.println("Consumed the message" + message);	
	}
	@KafkaListener(topics = "bet_data", groupId = "group")
	public void compareamount(String message) throws JsonMappingException, JsonProcessingException
	{
		ObjectMapper objectMapper = new ObjectMapper();
	    Bet betDetail = objectMapper.readValue(message, Bet.class);
	    if (betDetail.getReturns()>= 1500.00) 
	    {
	      System.out.println("Notification: Returns amount is >= 1500.00 for bet detail ID " + betDetail.getId());
	    }
	}
}
