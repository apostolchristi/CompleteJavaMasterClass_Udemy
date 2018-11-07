package com.company;
/*
<> - this is Diamond

            How works <T>
When we instantiate a class the <T> will be replaced automatically by java with the actual class we're using with the real type, in other words
when we are actually instantiating the class

            <T extends Player>
We told to java that type parameter we'll accept for this class when using generics is gonna be any type that extends from player or subclass
of player. In other words: by typing it like this with this extneds Player, Player is set to be the upper bound of T, and of course T
is a bounded type parameter. So if we attempt to use any class in other words that is not derived from Player we gona get an eror

            <T extends Class & Interface & Interface> - is the syntax for adding multiple interface in this Diamond
 */

import java.util.ArrayList;

public class Team<T extends Player>  {

    private String name;
    int played = 0;
    int won = 0;
    int lost = 0;
    int tied = 0;

    private ArrayList<T> members = new ArrayList<>();

    public Team(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean addPlayer (T player) {
        if(members.contains(player)) {
            System.out.println(player.getName() + " is already on this team");
            return false;
        } else {
            members.add(player);
            System.out.println(player.getName() + " picked for team " + this.name);
            return true;
        }
    }

    public int numPlayers () {
        return this.members.size();
    }

    public void matchResult(Team<T> opponent, int ourScore, int theirScore) {
        if(ourScore > theirScore) {
            won++;
        } else if (ourScore == theirScore) {
            tied++;
        } else {
            lost++;
        }
        played++;
        if(opponent != null) {
            opponent.matchResult(null, theirScore, ourScore); //now we can update the opponent's score
        }
    }

    public int ranking() {
        return (won * 2 ) + tied;
    }

}
