package com.example.app;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v4.widget.NestedScrollView;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.TypedValue;
import android.webkit.WebView;

import com.baiwanlu.android.image.FImageView;
import com.baiwanlu.android.webview.FWebView;
import com.baiwanlu.android.webview.FWebViewCallBack;

public class ActivitySwiperefrshCollapstoolbarActivity extends Activity  {

    private SwipeRefreshLayout swipeRefreshLayout;
    private AppBarLayout appbar;
    private FImageView imageView;
    private NestedScrollView nestedScrollView;
    private FWebView webview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swiperefrsh_collapstoolbar);

        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipe_refresh_layout);
        appbar = (AppBarLayout) findViewById(R.id.appbar);
        imageView = (FImageView) findViewById(R.id.image_view);
        nestedScrollView = (NestedScrollView) findViewById(R.id.nested_scroll_view);
        webview = (FWebView) findViewById(R.id.webview);


        webview.loadUrl("http://ie8384.com/blog");
        imageView.setImageUrl("http://t.cn/R5puMvn");


        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipe_refresh_layout);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                webview.reload();
            }
        });

        //第一次进来就显示刷新效果
        swipeRefreshLayout.setProgressViewOffset(false, 0, (int) TypedValue
                .applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources()
                        .getDisplayMetrics()));
        swipeRefreshLayout.setRefreshing(true);

        webview.setWebViewCallBack(new FWebViewCallBack(ActivitySwiperefrshCollapstoolbarActivity.this) {
            @Override
            public void onPageFinished(WebView webview, String url) {
                super.onPageFinished(webview, url);
                //页面加载完，取消刷新效果
                if (swipeRefreshLayout.isRefreshing()) {
                    swipeRefreshLayout.setRefreshing(false);
                }
            }
        });

        appbar.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {

                if (verticalOffset >= 0) {
                    swipeRefreshLayout.setEnabled(true);
                } else {
                    swipeRefreshLayout.setEnabled(false);
                }
            }
        });

    }

}
