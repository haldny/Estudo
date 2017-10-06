package com.haldny.estudo.mvp.gamepersisted;

import android.support.test.filters.SmallTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.haldny.estudo.R;
import com.haldny.estudo.mvp.gamedatapersisted.view.GameActivity;

import org.junit.After;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by haldny on 10/6/17.
 */

@RunWith(AndroidJUnit4.class)
@SmallTest
public class GameMVPGamePersistedTest {

    @Rule
    public ActivityTestRule<GameActivity> mainActivityRule
            = new ActivityTestRule<>(GameActivity.class);

    @After
    public void after() {
        onView(withId(R.id.buttonReset)).perform(click());
    }

    @Test
    public void testClickButtonTeamA() {
        onView(withId(R.id.buttonTeamA)).perform(click());
        onView(withId(R.id.textTeamA)).check(matches(withText("1")));
        onView(withId(R.id.textTeamB)).check(matches(withText("0")));
    }

    @Test
    public void testClickButtonTeamB() {
        onView(withId(R.id.buttonTeamB)).perform(click());
        onView(withId(R.id.textTeamA)).check(matches(withText("0")));
        onView(withId(R.id.textTeamB)).check(matches(withText("1")));
    }

    @Test
    public void testClickButtonReset() {
        onView(withId(R.id.buttonTeamA)).perform(click());
        onView(withId(R.id.buttonTeamB)).perform(click());
        onView(withId(R.id.textTeamA)).check(matches(withText("1")));
        onView(withId(R.id.textTeamB)).check(matches(withText("1")));
        onView(withId(R.id.buttonReset)).perform(click());
        onView(withId(R.id.textTeamA)).check(matches(withText("0")));
        onView(withId(R.id.textTeamB)).check(matches(withText("0")));
    }

}
