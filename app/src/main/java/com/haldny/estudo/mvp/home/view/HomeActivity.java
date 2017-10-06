package com.haldny.estudo.mvp.home.view;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.haldny.estudo.R;
import com.haldny.estudo.mvp.home.presenter.HomePresenter;
import com.haldny.estudo.mvp.home.presenter.IHomePresenter;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity
        implements IHomeActivity, AdapterView.OnItemClickListener {

    private ListView listView;
    private IHomePresenter homePresenter;
    private List<String> datas = new ArrayList<String>();
    private BaseAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        listView = (ListView) findViewById(R.id.list_home);
        listView.setOnItemClickListener(this);

        initEmptyView();
        initPresenter();
    }

    @Override
    protected void onResume() {
        super.onResume();
        homePresenter.loadDatas();
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
        homePresenter.onItemClick(position);
    }

    @Override
    public void onReceiveData(List<String> datas) {
        if (datas != null && datas.size() > 0){
            this.datas.clear();
            this.datas.addAll(datas);
            adapter.notifyDataSetChanged();
        }
    }

    @Override
    public void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    private void initEmptyView() {
        View loadingView = LayoutInflater.from(this).inflate(R.layout.item_empty_view, null);
        ViewGroup viewGroup = (ViewGroup) this.findViewById(R.id.layout_home);
        RelativeLayout.LayoutParams layoutParams =
                new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,
                        RelativeLayout.LayoutParams.MATCH_PARENT);
        layoutParams.addRule(RelativeLayout.CENTER_IN_PARENT);
        viewGroup.addView(loadingView, layoutParams);
        listView.setEmptyView(loadingView);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, datas);
        listView.setAdapter(adapter);
    }

    private void initPresenter() {
        homePresenter = new HomePresenter(this, this);
    }

}
