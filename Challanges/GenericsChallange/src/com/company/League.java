package com.company;
// Create a generic class to implement a league table for a sport.
// The class should allow teams to be added to the list, and store
// a list of teams that belong to the league.
//
// Your class should have a method to print out the teams in order,
// with the team at the top of the league printed first.
//
// Only teams of the same type should be added to any particular
// instance of the league class - the program should fail to compile
// if an attempt is made to add an incompatible team.

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class League<T extends Team> {

    private String name;
    private List<T> league = new ArrayList<>();

    public League(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean addTeam (T team) {
        if(league.contains(team)) {
            System.out.println(team.getName() + " is already exists");
            return false;
        } else {
            league.add(team);
            System.out.println(team.getName() + " picked for this league " + this.name);
            return true;
        }
    }

    public void showLeagueTable () {
        Collections.sort(league);
        for(T t : league) {
            System.out.println(t.getName() + ": " + t.ranking());
        }
    }
}
