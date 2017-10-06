package com.haldny.estudo.mvvm.databinding.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.haldny.estudo.BR;

/**
 * Created by haldny on 10/4/17.
 */

public class Score extends BaseObservable{

    private int teamA;
    private int teamB;

    public void addPointToTeamA() {
        teamA++;
        notifyPropertyChanged(BR.teamA);
    }

    public void addPointToTeamB() {
        teamB++;
        notifyPropertyChanged(BR.teamB);
    }

    public void reset() {
        teamA = 0;
        teamB = 0;
        notifyPropertyChanged(BR._all);
    }

    @Bindable
    public int getTeamA() {
        return teamA;
    }

    @Bindable
    public int getTeamB() {
        return teamB;
    }

}
