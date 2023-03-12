package com.gamedata.task.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gamedata.task.models.Bet;
import com.gamedata.task.repositories.BetDataRepo;
import com.gamedata.task.service.BetService;

@Service
public class BetServiceImpl implements BetService {

	@Autowired
	private BetDataRepo dataRepo;
	
	@Autowired
	private  KafkaTemplate<String, String> kafkaTemplate;

	@Override
	public Bet saveBet(Bet bet) {
		ObjectMapper objectMapper = new ObjectMapper();
		Bet betReturned=dataRepo.save(bet);
		kafkaTemplate.send("bet_detail", "New bet detail record inserted into the database for Id"+betReturned.getId());
		try {
			kafkaTemplate.send("bet_data",objectMapper.writeValueAsString(betReturned));
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return betReturned;
	}

	@Override
	public List<Bet> getAllBets() {
		return dataRepo.findAll();
	}

	@Override
	public Bet getBet(Integer Id) {
		return dataRepo.findById(Id).orElse(null);
	}
}
