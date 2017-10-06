package com.haldny.estudo.gamegod;

import android.widget.Button;
import android.widget.TextView;

import com.haldny.estudo.BuildConfig;
import com.haldny.estudo.R;
import com.haldny.estudo.gamegod.GameActivity;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.Shadows;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowTextView;

/**
 * Created by haldny on 10/5/17.
 */

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class)
public class GameActivityTest {

    private GameActivity activity;
    private TextView teamAValue;
    private TextView teamBValue;

    @Before
    public void before() {
        activity = Robolectric.setupActivity(GameActivity.class);
        teamAValue = activity.findViewById(R.id.textTeamA);
        teamBValue = activity.findViewById(R.id.textTeamB);
    }

    @After
    public void after() {
        activity = null;
        teamAValue = null;
        teamBValue = null;
    }

    @Test
    public void shouldNotBeNull() {
        Assert.assertNotNull(activity);
    }

    @Test
    public void clickOnTeamAButton() throws InterruptedException {
        Button button = activity.findViewById(R.id.buttonTeamA);
        button.performClick();
        Assert.assertEquals("1", teamAValue.getText().toString());
        Assert.assertEquals("0", teamBValue.getText().toString());
    }

    @Test
    public void clickOnTeamBButton() {
        Button button = activity.findViewById(R.id.buttonTeamB);
        button.performClick();
        Assert.assertEquals("0", activity.getTextTeamA().getText().toString());
        Assert.assertEquals("1", activity.getTextTeamB().getText().toString());
    }

    @Test
    public void clickOnResetButton() {
        Button buttonA = activity.findViewById(R.id.buttonTeamA);
        buttonA.performClick();
        Assert.assertEquals("1", activity.getTextTeamA().getText().toString());
        Assert.assertEquals("0", activity.getTextTeamB().getText().toString());

        Button buttonB = activity.findViewById(R.id.buttonTeamB);
        buttonB.performClick();
        Assert.assertEquals("1", activity.getTextTeamA().getText().toString());
        Assert.assertEquals("1", activity.getTextTeamB().getText().toString());

        Button buttonReset = activity.findViewById(R.id.buttonReset);
        buttonReset.performClick();
        Assert.assertEquals("0", activity.getTextTeamA().getText().toString());
        Assert.assertEquals("0", activity.getTextTeamB().getText().toString());
    }

}
