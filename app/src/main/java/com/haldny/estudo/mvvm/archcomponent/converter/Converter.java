package com.haldny.estudo.mvvm.archcomponent.converter;

import com.haldny.estudo.mvvm.archcomponent.viewmodel.Score;

/**
 * Created by haldny on 10/5/17.
 */

public class Converter {

    public static Score convertToViewModelScore(
            com.haldny.estudo.mvvm.archcomponent.model.Score modelScore) {
        Score vmScore = new Score();
        vmScore.setTeamA(String.valueOf(modelScore.getTeamA()));
        vmScore.setTeamB(String.valueOf(modelScore.getTeamB()));
        return vmScore;
    }

}
