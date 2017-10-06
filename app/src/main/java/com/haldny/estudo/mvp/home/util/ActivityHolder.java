package com.haldny.estudo.mvp.home.util;

import android.app.Activity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by haldny on 10/4/17.
 */

public class ActivityHolder {

    Map<String, Class<?extends Activity>> activityMap;
    List<String> nameList;

    public ActivityHolder() {
        activityMap = new HashMap<>();
        nameList = new ArrayList<>();
    }

    public void addActivity(String name,Class<?extends Activity> activity) {
        if (!activityMap.containsKey(name)) {
            nameList.add(name);
            activityMap.put(name,activity);
        }
    }

    public List<String> getNameList() {
        return nameList;
    }

    public Class<?extends Activity> getActivity(String name){
        return activityMap.get(name);
    }

}
