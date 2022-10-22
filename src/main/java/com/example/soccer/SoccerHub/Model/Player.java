package com.example.soccer.SoccerHub.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Player {

	
	private String playerId;
	private String playerName;
	private String position;
	private String club;
	private String country;
	

}
