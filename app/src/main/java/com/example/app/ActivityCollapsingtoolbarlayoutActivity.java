package com.example.app;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.Toolbar;

import com.baiwanlu.android.image.FImageView;
import com.baiwanlu.android.webview.FWebView;

public class ActivityCollapsingtoolbarlayoutActivity extends Activity  {

    private AppBarLayout appbar;
    private CollapsingToolbarLayout collapsingToolbar;
    private FImageView backdrop;
    private Toolbar toolbar;
    private FWebView webview;
    private FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collapsingtoolbarlayout);

        appbar = (AppBarLayout) findViewById(R.id.appbar);
        collapsingToolbar = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        backdrop = (FImageView) findViewById(R.id.backdrop);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        webview = (FWebView) findViewById(R.id.webview);
        fab = (FloatingActionButton) findViewById(R.id.fab);

        webview.loadUrl("http://ie8384.com/blog");
        backdrop.setImageUrl("http://t.cn/R5puMvn");
    }

}
