package org.model;

import java.time.LocalDateTime;
import java.util.*;

public class Game {
    private LocalDateTime dateGame;
    private Map<Team, Integer> teamScore;



    public Game(LocalDateTime dateGame, Map<Team, Integer> teamScore) {
        this.dateGame = dateGame;
        this.teamScore = teamScore;

    }
    public Game(){}



    @Override
    public String toString() {
        return "Game{" +
                "dateGame=" + dateGame +
                ", teams=" + teamScore.keySet().toString()+" "+teamScore.values().toString()+
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
