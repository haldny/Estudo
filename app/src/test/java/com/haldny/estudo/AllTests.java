package com.haldny.estudo;

import com.haldny.estudo.gamegod.GameActivityTest;
import com.haldny.estudo.mvp.game.ModelTest;
import com.haldny.estudo.mvp.game.PresenterTest;
import com.haldny.estudo.mvp.game.view.GameActivity;
import com.haldny.estudo.mvvm.archcomponent.ArchViewModelUnitTest;
import com.haldny.estudo.mvvm.databinding.DataBindingViewModelUnitTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import static org.junit.Assert.*;


@RunWith(Suite.class)
@Suite.SuiteClasses ({
        GameActivityTest.class,
        com.haldny.estudo.mvp.game.GameActivityTest.class,
        com.haldny.estudo.mvp.gamepersisted.GameActivityTest.class,
        ModelTest.class,
        com.haldny.estudo.mvp.gamepersisted.ModelTest.class,
        PresenterTest.class,
        com.haldny.estudo.mvp.gamepersisted.PresenterTest.class,
        ArchViewModelUnitTest.class,
        DataBindingViewModelUnitTest.class
})

public class AllTests {
}