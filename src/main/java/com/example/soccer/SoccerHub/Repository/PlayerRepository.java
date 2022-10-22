package com.example.soccer.SoccerHub.Repository;


import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.soccer.SoccerHub.Model.Player;


@Repository
public interface PlayerRepository extends MongoRepository<Player,String> {

	List<Player> save(String player);

	
}
