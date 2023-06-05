package org.model;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

public class NBB {
   private final DataNbb dataChampionship;

   public NBB(){
       dataChampionship = new DataNbb();
   }
    public void createChampionship(String[] lineEdit) {
       Map<Team, Integer> teamsScore = new HashMap<>();

        Team team1 = new Team(lineEdit[1]);
        Team team2 = new Team(lineEdit[2]);

        teamsScore.put(team1, Integer.valueOf(lineEdit[3]));
        teamsScore.put(team2, Integer.valueOf(lineEdit[4]));


        createGame(new Game(LocalDateTime.now(), teamsScore));
        registerTeam(team1);
        registerTeam(team2);
    }
   public void createGame(Game game){
       dataChampionship.addGame(game);
   }

   public void registerTeam(Team team){
       dataChampionship.addTeam(team);
   }


    public void playGames(){

        for(Game game : dataChampionship.getGames()){
            Team teamWinner = game.winnerTeam();

            for (Team teamCurrent : dataChampionship.getTeams()) {
                if (teamCurrent.getName().equals(teamWinner.getName())) {
                    teamCurrent.addPoints();
                }
            }


       }

    }
    public void leagueTable(){
       dataChampionship.getTeams().stream()
               .sorted(Comparator.comparing(Team::getPoints).reversed())
               .forEach(System.out::println);
   }

   public Set<Team> teamsInNBB(){
       return dataChampionship.getTeams();
   }

    public List<Game> gamesInNBB(){
        return dataChampionship.getGames();
    }

}
