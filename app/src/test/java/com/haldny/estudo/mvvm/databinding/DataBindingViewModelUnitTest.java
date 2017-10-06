package com.haldny.estudo.mvvm.databinding;

import android.arch.lifecycle.ViewModelProviders;

import com.haldny.estudo.mvvm.databinding.view.GameActivity;
import com.haldny.estudo.mvvm.databinding.viewmodel.ScoreViewModel;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;

/**
 * Created by haldny on 10/5/17.
 */

@RunWith(RobolectricTestRunner.class)
public class DataBindingViewModelUnitTest {

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
        Assert.assertEquals(1, vm.getScore().getTeamA());
        Assert.assertEquals(0, vm.getScore().getTeamB());
    }

    @Test
    public void testChangeScoreTeamB() {
        vm.updateTeamB();
        Assert.assertEquals(1, vm.getScore().getTeamB());
        Assert.assertEquals(0, vm.getScore().getTeamA());
    }

    @Test
    public void testResetScore() {
        vm.updateTeamA();
        Assert.assertEquals(1, vm.getScore().getTeamA());
        Assert.assertEquals(0, vm.getScore().getTeamB());
        vm.updateTeamB();
        Assert.assertEquals(1, vm.getScore().getTeamB());
        Assert.assertEquals(1, vm.getScore().getTeamA());

        vm.resetData();
        Assert.assertEquals(0, vm.getScore().getTeamB());
        Assert.assertEquals(0, vm.getScore().getTeamA());
    }

    private ScoreViewModel getViewModel() {
        GameActivity activity = Robolectric.setupActivity(GameActivity.class);
        return ViewModelProviders.of(activity).get(ScoreViewModel.class);
    }

}
