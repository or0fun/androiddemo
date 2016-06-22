package com.example.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.flexbox.FlexboxLayout;

/**
 * Created by lufei on 6/22/16.
 */
public class MainActivity extends Activity {

    private FlexboxLayout flexboxLayout;
    private Button swipeRefreshBtn;
    private Button coordinatorlayoutBtn;
    private Button SwiperefrshCollapstoolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        SwiperefrshCollapstoolbar = (Button) findViewById(R.id.SwiperefrshCollapstoolbar);

        flexboxLayout = (FlexboxLayout) findViewById(R.id.flexbox_layout);
        swipeRefreshBtn = (Button) findViewById(R.id.swipe_refresh_btn);
        coordinatorlayoutBtn = (Button) findViewById(R.id.coordinatorlayout_btn);

        swipeRefreshBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, SwipeRefreshActivity.class));
            }
        });
        coordinatorlayoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, ActivityCollapsingtoolbarlayoutActivity.class));
            }
        });
        SwiperefrshCollapstoolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, ActivitySwiperefrshCollapstoolbarActivity.class));
            }
        });
    }
}
