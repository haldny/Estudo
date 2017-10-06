package com.haldny.estudo.mvvm.archcomponent.viewmodel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.haldny.estudo.mvvm.archcomponent.converter.Converter;
import com.haldny.estudo.mvvm.archcomponent.model.IScoreService;
import com.haldny.estudo.mvvm.archcomponent.viewmodel.Score;
import com.haldny.estudo.mvvm.archcomponent.model.ScoreService;

/**
 * Created by haldny on 10/5/17.
 */

public class ScoreViewModel extends ViewModel {

    private MutableLiveData<Score> scoreLiveData;
    private IScoreService scoreService;

    public ScoreViewModel() {
        scoreLiveData = new MutableLiveData<>();
        initScoreService();
    }

    public void updateTeamA() {
        scoreLiveData.setValue(Converter.convertToViewModelScore(scoreService.updateTeamA()));
    }

    public void updateTeamB() {
        scoreLiveData.setValue(Converter.convertToViewModelScore(scoreService.updateTeamB()));
    }

    public void resetData() {
        scoreLiveData.setValue(Converter.convertToViewModelScore(scoreService.reset()));
    }

    public MutableLiveData<Score> getScoreLiveData() {
        return scoreLiveData;
    }

    private void initScoreService() {
        scoreService = new ScoreService();
    }

}
