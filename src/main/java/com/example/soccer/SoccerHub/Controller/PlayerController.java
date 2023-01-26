package com.example.soccer.SoccerHub.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;

import com.example.soccer.SoccerHub.Model.Player;
import com.example.soccer.SoccerHub.Service.PlayerService;

@RestController
@RequestMapping("/soccerhub/players")
public class PlayerController {

	@Autowired
	private PlayerService playerService;
	
	@GetMapping("/get")
	public List<Player> getAllPlayers(){
		return playerService.getPlayers();
	}
	
	@GetMapping("/get/{id}")
	public Optional<Player> getPlayer(@PathVariable("id") String playerId){
		return playerService.getPlayer(playerId);
		
	}
	
	@PostMapping(value="/add",consumes= {MediaType.MULTIPART_FORM_DATA_VALUE})
	public ResponseEntity<String> addPlayer(@RequestPart("playerId") String playerId,@RequestPart("playerName") String playerName,@RequestPart("position") String position,@RequestPart("club") String club, @RequestPart("country") String country) {
		Player player=new Player();
		player.setPlayerId(playerId);
		player.setPlayerName(playerName);
		player.setPosition(position);
		player.setClub(club);
		player.setCountry(country);
		try {
			playerService.addPlayers(player);
			System.out.println("Player is successfully added");
		}catch(Exception e) {
			return ResponseEntity.ok("Error during saving player "+playerId);
		}
		
		return ResponseEntity.ok("Player "+playerId+" is succesfully added");
	}
}
