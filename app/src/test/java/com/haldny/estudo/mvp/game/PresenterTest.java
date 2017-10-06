package com.haldny.estudo.mvp.game;

import com.haldny.estudo.mvp.game.presenter.GamePresenter;
import com.haldny.estudo.mvp.game.presenter.IGamePresenter;
import com.haldny.estudo.mvp.game.view.IGameActivity;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Created by haldny on 10/5/17.
 */

@RunWith(JUnit4.class)
public class PresenterTest {

    private IGamePresenter presenter;
    private MyGameActivity activity;

    private class MyGameActivity implements IGameActivity {

        public int scoreTeamA;
        public int scoreTeamB;

        @Override
        public void updateScore(String teamA, String teamB) {
            scoreTeamA = Integer.parseInt(teamA);
            scoreTeamB = Integer.parseInt(teamB);
        }

    }

    @Before
    public void before() {
        activity = new MyGameActivity();
        presenter = new GamePresenter(activity);
    }

    @After
    public void after() {
        presenter = null;
        activity = null;
    }

    @Test
    public void addScoreToTeamA() {
        presenter.teamAClick();
        Assert.assertEquals(1, activity.scoreTeamA);
        Assert.assertEquals(0, activity.scoreTeamB);
    }

    @Test
    public void addScoreToTeamB() {
        presenter.teamBClick();
        Assert.assertEquals(1, activity.scoreTeamB);
        Assert.assertEquals(0, activity.scoreTeamA);
    }

    @Test
    public void resetScore() {
        presenter.teamAClick();
        Assert.assertEquals(1, activity.scoreTeamA);
        Assert.assertEquals(0, activity.scoreTeamB);
        presenter.teamBClick();
        Assert.assertEquals(1, activity.scoreTeamB);
        Assert.assertEquals(1, activity.scoreTeamA);
        presenter.resetClick();
        Assert.assertEquals(0, activity.scoreTeamA);
        Assert.assertEquals(0, activity.scoreTeamB);
    }

}
