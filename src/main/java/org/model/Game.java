package org.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Game {
    private LocalDateTime dateGame;
    private Map<Team, Integer> teamScore;



    public Game(LocalDateTime dateGame, Map<Team, Integer> teamScore) {
        this.dateGame = dateGame;
        this.teamScore = teamScore;

    }
    public Game(){}

    public LocalDateTime getDateGame(){
        return dateGame;
    }


    @Override
    public String toString() {
        return "Game{" +
                "dateGame=" + dateGame.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")) +
                ", teams=" + teamScore.keySet()+" "+teamScore.values()+
                '}';
    }

    public Team winnerTeam(){
        Integer valueMax = Collections.max(teamScore.values());
        Team teamWinner = null;
        for(Team t : teamScore.keySet()){
            if(teamScore.get(t).equals(valueMax)){
                teamWinner = t;
            }
        }
        return teamWinner;
    }


}
