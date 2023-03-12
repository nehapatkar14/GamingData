package com.gamedata.task.models;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Bet {
    
	@Id
	int id;
	int numbets ;
	String game;
	Float stake;
	Float returns;
	int clientid;
	Date date;

}
