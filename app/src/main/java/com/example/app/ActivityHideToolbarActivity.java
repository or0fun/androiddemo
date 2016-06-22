package com.example.app;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v7.widget.Toolbar;

import com.baiwanlu.android.webview.FWebView;

public class ActivityHideToolbarActivity extends Activity  {

    private AppBarLayout appbar;
    private Toolbar toolbar;
    private FWebView webview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hide_toolbar);

        appbar = (AppBarLayout) findViewById(R.id.appbar);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        webview = (FWebView) findViewById(R.id.webview);

        webview.loadUrl("http://ie8384.com/blog");
    }

}
