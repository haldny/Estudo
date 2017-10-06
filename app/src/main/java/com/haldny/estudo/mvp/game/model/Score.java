package com.haldny.estudo.mvp.game.model;

/**
 * Created by haldny on 10/4/17.
 */

public class Score {

    private int teamA;
    private int teamB;

    public void addPointToTeamA() {
        teamA++;
    }

    public void addPointToTeamB() {
        teamB++;
    }

    public void reset() {
        teamA = 0;
        teamB = 0;
    }

    public int getTeamA() {
        return teamA;
    }

    public int getTeamB() {
        return teamB;
    }

}
