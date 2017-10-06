package com.haldny.estudo;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.haldny.estudo.gamegod.GameGodTest;
import com.haldny.estudo.mvp.game.GameMVPGameTest;
import com.haldny.estudo.mvp.gamepersisted.GameMVPGamePersistedTest;
import com.haldny.estudo.mvvm.archcomponent.GameMVVMArchTest;
import com.haldny.estudo.mvvm.databinding.GameMVVMBindingTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import static org.junit.Assert.*;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(Suite.class)
@Suite.SuiteClasses ({
        GameGodTest.class,
        GameMVPGameTest.class,
        GameMVPGamePersistedTest.class,
        GameMVVMArchTest.class,
        GameMVVMBindingTest.class
})

public class AllTests {
}