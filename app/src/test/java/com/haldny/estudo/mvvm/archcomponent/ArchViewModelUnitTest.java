package com.haldny.estudo.mvvm.archcomponent;

import android.arch.lifecycle.ViewModelProviders;

import com.haldny.estudo.BuildConfig;
import com.haldny.estudo.mvvm.archcomponent.view.GameActivity;
import com.haldny.estudo.mvvm.archcomponent.viewmodel.ScoreViewModel;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

/**
 * Created by haldny on 10/5/17.
 */

@RunWith(RobolectricTestRunner.class)
public class ArchViewModelUnitTest {

    ScoreViewModel vm;

    @Before
    public void before() {
        vm = getViewModel();
    }

    @After
    public void after() {
        vm = null;
    }

    @Test
    public void testChangeScoreTeamA() {
        vm.updateTeamA();
        Assert.assertEquals("1", vm.getScoreLiveData().getValue().getTeamA());
        Assert.assertEquals("0", vm.getScoreLiveData().getValue().getTeamB());
    }

    @Test
    public void testChangeScoreTeamB() {
        vm.updateTeamB();
        Assert.assertEquals("1", vm.getScoreLiveData().getValue().getTeamB());
        Assert.assertEquals("0", vm.getScoreLiveData().getValue().getTeamA());
    }

    @Test
    public void testResetScore() {
        vm.updateTeamA();
        Assert.assertEquals("1", vm.getScoreLiveData().getValue().getTeamA());
        Assert.assertEquals("0", vm.getScoreLiveData().getValue().getTeamB());
        vm.updateTeamB();
        Assert.assertEquals("1", vm.getScoreLiveData().getValue().getTeamB());
        Assert.assertEquals("1", vm.getScoreLiveData().getValue().getTeamA());

        vm.resetData();
        Assert.assertEquals("0", vm.getScoreLiveData().getValue().getTeamB());
        Assert.assertEquals("0", vm.getScoreLiveData().getValue().getTeamA());
    }

    private ScoreViewModel getViewModel() {
        GameActivity activity = Robolectric.setupActivity(GameActivity.class);
        return ViewModelProviders.of(activity).get(ScoreViewModel.class);
    }

}
