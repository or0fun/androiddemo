package com.example.app;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;

import com.baiwanlu.android.image.FImageView;
import com.baiwanlu.android.webview.FWebView;
import com.baiwanlu.android.webview.FWebViewCallBack;

public class SwipeRefreshActivity extends AppCompatActivity {

    private SwipeRefreshLayout swipeRefreshLayout;
    private FWebView webview;
    private Context context;
    private FImageView headerImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swiperefrsh);
        context = this;

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Snackbar的使用
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("知道了", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {

                            }
                        })
                        //可以设置精确的显示时间
                        .setDuration(50000)
                        .show();
            }
        });

        webview = (FWebView) findViewById(R.id.webview);
        webview.loadUrl("http://ie8384.com/blog");

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

        webview.setWebViewCallBack(new FWebViewCallBack(SwipeRefreshActivity.this) {
            @Override
            public void onPageFinished(WebView webview, String url) {
                super.onPageFinished(webview, url);
                //页面加载完，取消刷新效果
                if (swipeRefreshLayout.isRefreshing()) {
                    swipeRefreshLayout.setRefreshing(false);
                }
            }
        });

        headerImageView = (FImageView) findViewById(R.id.backdrop);
        headerImageView.setImageUrl("http://t.cn/R5puMvn");

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
