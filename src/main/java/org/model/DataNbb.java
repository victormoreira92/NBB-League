package org.model;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class DataNbb {
    private final Set<Team> teams;
    private final List<Game> games;

    public DataNbb() {
        this.teams = new LinkedHashSet<>();
        this.games = new LinkedList<>();
    }

    public void addTeam(Team team) {
        this.teams.add(team);
    }

    public void addGame( Game game) {
        this.games.add(0,game);
    }

    public List<Game> gameBetween(LocalDate dateAfter, LocalDate dayBefore){
       /* ArrayList<Game> gamesBetween = new ArrayList<>();

        for(Game game : games) {
            if (game.getDateGame().isAfter(dateAfter.atStartOfDay()) && game.getDateGame().isBefore(dayBefore.atStartOfDay())) {
                gamesBetween.add(game);
            }
        }
        */

        return games.stream().filter(game -> game.getDateGame().isAfter(dateAfter.atStartOfDay())
                && game.getDateGame().isBefore(dayBefore.atStartOfDay())).collect(Collectors.toCollection(ArrayList::new));

    }

    public Set<Team> getTeams() {
        return Collections.unmodifiableSet(teams);
    }

    public List<Game> getGames() {
        return Collections.unmodifiableList(games);
    }

    public void addPointsWinner(Team teamWinner){
        teams.stream().forEach((t)->{
            if(t.getName().equals(teamWinner.getName())){
                t.addPoints();
            }
        });
    }
}
