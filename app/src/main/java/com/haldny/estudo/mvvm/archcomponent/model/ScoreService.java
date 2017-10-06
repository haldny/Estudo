package com.haldny.estudo.mvvm.archcomponent.model;

/**
 * Created by haldny on 10/5/17.
 */

public class ScoreService implements IScoreService {

    private Score score;

    public ScoreService() {
        score = new Score();
    }

    @Override
    public Score updateTeamA() {
        score.addPointToTeamA();
        return score;
    }

    @Override
    public Score updateTeamB() {
        score.addPointToTeamB();
        return score;
    }

    @Override
    public Score reset() {
        score.reset();
        return score;
    }
}
