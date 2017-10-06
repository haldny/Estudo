package com.haldny.estudo.gamegod;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.haldny.estudo.R;

/**
 * Created by haldny on 10/4/17.
 */

public class GameActivity extends AppCompatActivity implements View.OnClickListener {

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
        updateScore(teamA, teamB);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.buttonReset:
                updateScoreTeamA();
                break;
            case R.id.buttonTeamA:
                updateScoreTeamB();
                break;
            case R.id.buttonTeamB:
                resetScore();
                break;
        }
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

    private void updateScore(String teamA, String teamB) {
        textTeamA.setText(teamA);
        textTeamB.setText(teamB);
    }

    private void updateScoreTeamA() {
        int teamA = Integer.parseInt(textTeamA.getText().toString());
        teamA++;
        textTeamA.setText(String.valueOf(teamA));
    }

    private void updateScoreTeamB() {
        int teamB = Integer.parseInt(textTeamB.getText().toString());
        teamB++;
        textTeamB.setText(String.valueOf(teamB));
    }

    private void resetScore() {
        textTeamA.setText("0");
        textTeamB.setText("0");
    }

    // For Tests
    public TextView getTextTeamA() {
        return textTeamA;
    }

    public TextView getTextTeamB() {
        return textTeamB;
    }
}
