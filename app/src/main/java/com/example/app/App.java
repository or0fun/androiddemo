package com.example.app;

import android.app.Application;

import com.baiwanlu.android.image.FImageView;

/**
 * Created by lufei on 6/22/16.
 */
public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        FImageView.init(this);
    }
}
