package org.model;

import java.util.*;

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

    public Set<Team> getTeams() {
        return Collections.unmodifiableSet(teams);
    }

    public List<Game> getGames() {
        return Collections.unmodifiableList(games);
    }
}
