package com.haldny.estudo.mvp.home.presenter;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;

import com.haldny.estudo.mvp.home.util.ActivityHolder;
import com.haldny.estudo.mvp.home.view.IHomeActivity;

/**
 * Created by haldny on 10/4/17.
 */

public class HomePresenter implements IHomePresenter {

    private Context mContext;
    private IHomeActivity mHomeActivity;

    public HomePresenter(Context context, IHomeActivity homeActivity) {
        mContext = context;
        mHomeActivity = homeActivity;
    }

    private static ActivityHolder holder;
    static {
        holder = new ActivityHolder();
        holder.addActivity("Game God", com.haldny.estudo.mvp.gamedatapersisted.view.GameActivity.class);
        holder.addActivity("Game MVP", com.haldny.estudo.mvp.game.view.GameActivity.class);
        holder.addActivity("Game MVP Persisted", com.haldny.estudo.mvp.gamedatapersisted.view.GameActivity.class);
        holder.addActivity("Game MVVM LiveData", com.haldny.estudo.mvvm.archcomponent.view.GameActivity.class);
        holder.addActivity("Game MVVM Binding", com.haldny.estudo.mvvm.databinding.view.GameActivity.class);
    }


    @Override
    public void loadDatas() {
        Handler handler = new Handler(Looper.getMainLooper());
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                mHomeActivity.onReceiveData(holder.getNameList());
            }
        }, 2000);
    }

    @Override
    public void onItemClick(int position) {
        Class activity = holder.getActivity(holder.getNameList().get(position));
        if (activity != null){
            mContext.startActivity(new Intent(mContext, activity));
        }
    }
}

