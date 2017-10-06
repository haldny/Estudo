package com.haldny.estudo.mvp.gamepersisted;

import com.haldny.estudo.mvp.game.model.Score;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Created by haldny on 10/5/17.
 */

@RunWith(JUnit4.class)
public class ModelTest {
    private Score score;

    @Before
    public void before() {
        score = new Score();
    }

    @After
    public void after() {
        score = null;
    }

    @Test
    public void testAddValueTeamA() {
        score.addPointToTeamA();
        Assert.assertEquals(1, score.getTeamA());
        Assert.assertEquals(0, score.getTeamB());
    }

    @Test
    public void testAddValueTeamB() {
        score.addPointToTeamB();
        Assert.assertEquals(1, score.getTeamB());
        Assert.assertEquals(0, score.getTeamA());
    }

    @Test
    public void testResetValues() {
        score.addPointToTeamA();
        Assert.assertEquals(1, score.getTeamA());
        Assert.assertEquals(0, score.getTeamB());
        score.addPointToTeamB();
        Assert.assertEquals(1, score.getTeamB());
        Assert.assertEquals(1, score.getTeamA());
        score.reset();
        Assert.assertEquals(0, score.getTeamA());
        Assert.assertEquals(0, score.getTeamB());
    }



}
