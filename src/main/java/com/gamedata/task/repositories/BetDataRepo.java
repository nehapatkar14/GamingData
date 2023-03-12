package com.gamedata.task.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gamedata.task.models.Bet;


public interface BetDataRepo extends JpaRepository<Bet,Integer> {

}
