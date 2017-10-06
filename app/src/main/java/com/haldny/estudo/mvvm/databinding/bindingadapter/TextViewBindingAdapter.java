package com.haldny.estudo.mvvm.databinding.bindingadapter;

import android.databinding.BindingAdapter;
import android.support.annotation.NonNull;
import android.widget.TextView;

/**
 * Created by haldny on 10/5/17.
 */

public class TextViewBindingAdapter {

    @BindingAdapter("android:text")
    public static void setIntToText(@NonNull TextView textView, @NonNull int value) {
        textView.setText(String.valueOf(value));
    }

}
