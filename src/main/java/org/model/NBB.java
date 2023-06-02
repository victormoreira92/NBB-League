package org.model;

import java.util.*;
import java.util.stream.Collectors;

public class NBB {
   private Set<Team> teams;
   private List<Game> games;

   public NBB(){
       teams =  new HashSet<>();
       games = new ArrayList<>();
   }

   public void addGames(Game game){
       games.add(game);
   }

   public void addTeams(Team team){
       teams.add(team);
   }

    public Set<Team> getTeams() {
        return teams;
    }

    public List<Game> getGames() {
        return games;
    }

    public void playGames(){
        List<Team> teamsTemp = new ArrayList<>();

        for(Game game : games){
            Team teamWinner = game.winnerTeam();
            Iterator<Team> it = teams.iterator();

            while (it.hasNext()){
                Team teamCurrent = it.next();
                if(teamCurrent.getName().equals(teamWinner.getName())){
                    teamCurrent.addPoints();
                }
            }


       }

    }
    public void leagueTable(){
       teams.stream()
               .sorted(Comparator.comparing(Team::getPoints).reversed())
               .forEach(System.out::println);
   }
}
