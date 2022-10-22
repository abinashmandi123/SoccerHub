package com.example.soccer.SoccerHub.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.soccer.SoccerHub.Model.Player;
import com.example.soccer.SoccerHub.Repository.PlayerRepository;

@Service
public class PlayerService {

	@Autowired
	private PlayerRepository playerRepository;
	
	public List<Player> getPlayers(){
		return playerRepository.findAll();
	}
	
	public Optional<Player> getPlayer(String playerId){
		return playerRepository.findById(playerId);
	}
	
	public Player addPlayers(Player player){
		return playerRepository.save(player);
	}
}
