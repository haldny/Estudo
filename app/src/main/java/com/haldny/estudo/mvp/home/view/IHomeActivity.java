package com.haldny.estudo.mvp.home.view;

import java.util.List;

/**
 * Created by haldny on 9/26/17.
 */

public interface IHomeActivity {

    void onReceiveData(List<String> datas);
    void showToast(String message);

}