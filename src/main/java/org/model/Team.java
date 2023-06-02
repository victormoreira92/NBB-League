package org.model;

import java.util.Objects;

public class Team {
    private String name;
    private Integer points;

    public Team(String name) {
        this.name = name;
        points = 0;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPoints() {
        return points;
    }

    public void addPoints() {
        this.points++;
    }

    @Override
    public String toString() {
        return name+" - "+points;
    }

    @Override
    public boolean equals(Object obj){
       if (obj == this)
           return false;

       if(!(obj instanceof Team))
           return false;

       Team team = (Team) obj;
       return team.getName().equals(getName());

    }

    @Override
    public int hashCode() {
        return Objects.hash(name, points);
    }


}
