package com.haldny.estudo.mvvm.databinding.view;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.haldny.estudo.R;
import com.haldny.estudo.databinding.ActivityGame2Binding;
import com.haldny.estudo.mvvm.databinding.viewmodel.ScoreViewModel;

/**
 * Created by haldny on 10/5/17.
 */

public class GameActivity extends AppCompatActivity implements View.OnClickListener {

    private ScoreViewModel viewModel;
    private Button buttonTeamA;
    private Button buttonTeamB;
    private Button buttonReset;
    private ActivityGame2Binding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_game2);

        initViewModel();
        initViews();
        initDataBinding();
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

        buttonTeamA.setOnClickListener(this);
        buttonTeamB.setOnClickListener(this);
        buttonReset.setOnClickListener(this);

    }

    private void initViewModel() {
        viewModel = ViewModelProviders.of(this).get(ScoreViewModel.class);
    }

    private void initDataBinding() {
        binding.setScore(viewModel.getScore());
    }

}


