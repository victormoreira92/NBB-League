package org.model;

import java.util.*;

public class DataNbb {
    private Set<Team> teams;
    private List<Game> games;

    public DataNbb() {
        this.teams = new LinkedHashSet<Team>();
        this.games = new ArrayList<Game>();
    }

    public void addTeam(Team team) {
        this.teams.add(team);
    }

    public void addGame( Game game) {
        this.games.add(game);
    }

    public Set<Team> getTeams() {
        return Collections.unmodifiableSet(teams);
    }

    public List<Game> getGames() {
        return Collections.unmodifiableList(games);
    }
}
