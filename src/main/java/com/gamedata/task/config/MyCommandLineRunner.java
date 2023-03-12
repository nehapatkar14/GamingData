package com.gamedata.task.config;

import java.io.InputStream;
import java.util.List;

import javax.management.loading.PrivateClassLoader;

import org.aspectj.weaver.ast.And;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gamedata.task.models.Bet;
import com.gamedata.task.serviceImpl.BetServiceImpl;

@Configuration
public class MyCommandLineRunner implements CommandLineRunner{

	@Autowired
	BetServiceImpl  service;
	@Override
	public void run(String... args) throws Exception {
		final String Data_JSON ="/data/BetData.json";
		if(service.getAllBets().size()==0)
		{ 
			try {
			TypeReference<List<Bet>> typeReference= new TypeReference<List<Bet>>() {};
			InputStream inputStream =TypeReference.class.getResourceAsStream(Data_JSON);
			List<Bet> bets= new ObjectMapper().readValue(inputStream, typeReference);
			if(bets!=null && !bets.isEmpty())
			{
				for(Bet bet: bets)
				{
					service.saveBet(bet);
				}
			}
			}
			catch (Exception e) {
				System.out.println("Unable to save data"+e);
			}
		}
		} 
			
}

