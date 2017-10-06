package com.haldny.estudo.mvp.game.presenter;

import com.haldny.estudo.mvp.game.model.Score;
import com.haldny.estudo.mvp.game.view.IGameActivity;

/**
 * Created by haldny on 10/4/17.
 */

public class GamePresenter implements IGamePresenter {

    private Score score;
    private IGameActivity gameActivity;

    public GamePresenter(IGameActivity gameInterface) {
        score = new Score();
        gameActivity = gameInterface;
    }

    @Override
    public void teamAClick() {
        score.addPointToTeamA();
        notifyActivity();
    }

    @Override
    public void teamBClick() {
        score.addPointToTeamB();
        notifyActivity();
    }

    @Override
    public void resetClick() {
        score.reset();
        notifyActivity();
    }

    private void notifyActivity() {
        gameActivity.updateScore(
                String.valueOf(score.getTeamA()),
                String.valueOf(score.getTeamB()));
    }

}
