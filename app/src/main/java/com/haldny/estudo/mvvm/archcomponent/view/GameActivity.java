package com.haldny.estudo.mvvm.archcomponent.view;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.haldny.estudo.R;
import com.haldny.estudo.mvvm.archcomponent.viewmodel.Score;
import com.haldny.estudo.mvvm.archcomponent.viewmodel.ScoreViewModel;

/**
 * Created by haldny on 10/5/17.
 */

public class GameActivity extends AppCompatActivity implements View.OnClickListener {

    private ScoreViewModel viewModel;
    private Button buttonTeamA;
    private Button buttonTeamB;
    private Button buttonReset;
    private TextView textTeamA;
    private TextView textTeamB;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        initViewModel();
        initViews();
        initObservers();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.buttonTeamA:
                viewModel.updateTeamA();
                break;
            case R.id.buttonTeamB:
                viewModel.updateTeamB();
                break;
            case R.id.buttonReset:
                viewModel.resetData();
                break;
        }

    }

    private void initViews() {
        buttonTeamA = findViewById(R.id.buttonTeamA);
        buttonTeamB = findViewById(R.id.buttonTeamB);
        buttonReset = findViewById(R.id.buttonReset);

        textTeamA = findViewById(R.id.textTeamA);
        textTeamB = findViewById(R.id.textTeamB);

        buttonTeamA.setOnClickListener(this);
        buttonTeamB.setOnClickListener(this);
        buttonReset.setOnClickListener(this);

    }

    private void initViewModel() {
        viewModel = ViewModelProviders.of(this).get(ScoreViewModel.class);
    }

    private void initObservers() {
        viewModel.getScoreLiveData().observe(this, new Observer<Score>() {
            @Override
            public void onChanged(@Nullable Score score) {
                textTeamA.setText(score.getTeamA());
                textTeamB.setText(score.getTeamB());
            }
        });
    }

}
