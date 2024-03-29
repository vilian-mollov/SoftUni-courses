package Encapsulation.lab.FirstAndReserveTeam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Team {
    private final String name;
    private final List<Person> firstTeam;
    private final List<Person> reserveTeam;

    public Team(String name) {
        this.name = name;
        firstTeam = new ArrayList<>();
        reserveTeam = new ArrayList<>();
    }

    public void addPlayer(Person player){
        if(player.getAge() < 40){
            this.firstTeam.add(player);
        }else {
            this.reserveTeam.add(player);
        }
    }

    public List<Person> getFirstTeam() {
        return Collections.unmodifiableList(firstTeam);
    }

    public List<Person> getReserveTeam() {
        return Collections.unmodifiableList(reserveTeam);
    }


}
