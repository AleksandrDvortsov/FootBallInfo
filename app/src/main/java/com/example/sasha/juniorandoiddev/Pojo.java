package com.example.sasha.juniorandoiddev;

import java.util.List;

public class Pojo {

    private Integer count;
    private Filters filters;
    public List<Competitions> competitions = null;
    private List<Team> teams = null;
    private List<Squad> squad = null;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Filters getFilters() {
        return filters;
    }

    public void setFilters(Filters filters) {
        this.filters = filters;
    }

    public List<Competitions> getCompetitions() {
        return competitions;
    }

    public void setCompetitions(List<Competitions> competitions) {
        this.competitions = competitions;
    }

    public List<Team> getTeams() {
        return teams;
    }

    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }

    public List<Squad> getSquad() {
        return squad;
    }

    public void setSquad(List<Squad> squad) {
        this.squad = squad;
    }

    @Override
    public String toString()
    {
        return "ClassAllLeag [count = "+count+", competitions = "+competitions+", teams = " + teams +", squad = " + squad + "]";
    }
}
