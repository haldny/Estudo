package com.haldny.estudo.mvvm.databinding.viewmodel;

import android.arch.lifecycle.ViewModel;

import com.haldny.estudo.mvvm.databinding.model.Score;

/**
 * Created by haldny on 10/5/17.
 */

public class ScoreViewModel extends ViewModel {

    private Score score;

    public ScoreViewModel() {
        score = new Score();
    }

    public void updateTeamA() {
        score.addPointToTeamA();
    }

    public void updateTeamB() {
        score.addPointToTeamB();
    }

    public void resetData() {
        score.reset();
    }

    public Score getScore() {
        return score;
    }

}
