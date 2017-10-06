package com.haldny.estudo.mvp.gamedatapersisted.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.haldny.estudo.R;
import com.haldny.estudo.mvp.gamedatapersisted.presenter.GamePresenter;
import com.haldny.estudo.mvp.gamedatapersisted.presenter.IGamePresenter;

public class GameActivity extends AppCompatActivity implements IGameActivity, View.OnClickListener {

    private IGamePresenter gamePresenter;
    private TextView textTeamA;
    private TextView textTeamB;
    private Button buttonTeamA;
    private Button buttonTeamB;
    private Button buttonReset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        initViews();
        initGamePresenter();
    }

    @Override
    public void updateScore(String teamA, String teamB) {
        textTeamA.setText(teamA);
        textTeamB.setText(teamB);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putString("teamA", textTeamA.getText().toString());
        outState.putString("teamB", textTeamB.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        String teamA = savedInstanceState.getString("teamA");
        String teamB = savedInstanceState.getString("teamB");
        if (gamePresenter == null) {
            initGamePresenter();
        }

        gamePresenter.updateModel(teamA, teamB);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.buttonReset:
                gamePresenter.resetClick();
                break;
            case R.id.buttonTeamA:
                gamePresenter.teamAClick();
                break;
            case R.id.buttonTeamB:
                gamePresenter.teamBClick();
                break;
        }
    }

    private void initGamePresenter() {
        gamePresenter = new GamePresenter(this);
    }

    private void initViews() {
        textTeamA = findViewById(R.id.textTeamA);
        textTeamB = findViewById(R.id.textTeamB);
        buttonTeamA = findViewById(R.id.buttonTeamA);
        buttonTeamB = findViewById(R.id.buttonTeamB);
        buttonReset = findViewById(R.id.buttonReset);
        buttonTeamA.setOnClickListener(this);
        buttonTeamB.setOnClickListener(this);
        buttonReset.setOnClickListener(this);
    }

}
