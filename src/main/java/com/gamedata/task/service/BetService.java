package com.gamedata.task.service;

import java.util.List;

import com.gamedata.task.models.Bet;

public interface BetService {

	    Bet saveBet(Bet bet);

	    //get all user
	    List<Bet> getAllBets();

	    //get single user of given userId

	    Bet getBet(Integer Id);
}
