package com.haldny.estudo.mvp.game;

import android.widget.Button;
import android.widget.TextView;

import com.haldny.estudo.R;
import com.haldny.estudo.mvp.game.view.GameActivity;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;

/**
 * Created by haldny on 10/5/17.
 */

@RunWith(RobolectricTestRunner.class)
public class GameActivityTest {

    private GameActivity activity;

    @Before
    public void before() {
        activity = Robolectric.buildActivity(GameActivity.class).create().resume().get();
    }

    @After
    public void after() {
        activity = null;
    }

    @Test
    public void shouldNotBeNull() {
        Assert.assertNotNull(activity);
    }

    @Test
    public void clickOnTeamAButton() {
        Button button = activity.findViewById(R.id.buttonTeamA);
        button.performClick();
        TextView teamAValue = activity.findViewById(R.id.textTeamA);
        TextView teamBValue = activity.findViewById(R.id.textTeamB);
        Assert.assertEquals("1", teamAValue.getText().toString());
        Assert.assertEquals("0", teamBValue.getText().toString());
    }

    @Test
    public void clickOnTeamBButton() {
        Button button = activity.findViewById(R.id.buttonTeamB);
        button.performClick();
        TextView teamAValue = activity.findViewById(R.id.textTeamA);
        TextView teamBValue = activity.findViewById(R.id.textTeamB);
        Assert.assertEquals("0", teamAValue.getText().toString());
        Assert.assertEquals("1", teamBValue.getText().toString());
    }

    @Test
    public void clickOnResetButton() {
        Button buttonA = activity.findViewById(R.id.buttonTeamA);
        buttonA.performClick();
        TextView teamAValue = activity.findViewById(R.id.textTeamA);
        TextView teamBValue = activity.findViewById(R.id.textTeamB);
        Assert.assertEquals("1", teamAValue.getText().toString());
        Assert.assertEquals("0", teamBValue.getText().toString());

        Button buttonB = activity.findViewById(R.id.buttonTeamB);
        buttonB.performClick();
        Assert.assertEquals("1", teamAValue.getText().toString());
        Assert.assertEquals("1", teamBValue.getText().toString());

        Button buttonReset = activity.findViewById(R.id.buttonReset);
        buttonReset.performClick();
        Assert.assertEquals("0", teamAValue.getText().toString());
        Assert.assertEquals("0", teamBValue.getText().toString());
    }

}
