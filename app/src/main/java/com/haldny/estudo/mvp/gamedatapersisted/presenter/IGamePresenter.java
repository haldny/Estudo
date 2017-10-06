package com.haldny.estudo.mvp.gamedatapersisted.presenter;

/**
 * Created by haldny on 10/4/17.
 */

public interface IGamePresenter {

    void teamAClick();
    void teamBClick();
    void resetClick();
    void updateModel(String teamA, String teamB);

}
