package com.example.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.flexbox.FlexboxLayout;

/**
 * Created by lufei on 6/22/16.
 */
public class MainActivity extends Activity {

    private FlexboxLayout flexboxLayout;
    private Button swipeRefreshBtn;
    private Button coordinatorlayoutBtn;
    private Button SwiperefrshCollapstoolbar;
    private Button textinputlayout;
    private Button hideToolBar;

    private Toolbar toolbar;

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

        textinputlayout = (Button) findViewById(R.id.textinputlayout);
        textinputlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, ActivityTextinputlayoutActivity.class));
            }
        });


        hideToolBar = (Button) findViewById(R.id.hide_tool_bar);
        hideToolBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, ActivityHideToolbarActivity.class));
            }
        });

        findViewById(R.id.behavior).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, ActivityCoordinatorlayoutActivity.class));
            }
        });


        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.inflateMenu(R.menu.menu_main);
        toolbar.setLogo(R.mipmap.ic_launcher);
        toolbar.setTitle("My Title");
        toolbar.setSubtitle("Sub title");
        toolbar.setNavigationIcon(R.mipmap.ab_android);
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {

                String msg = "";
                switch (item.getItemId()) {
                    case R.id.action_edit:
                        msg += "Click edit";
                        break;
                    case R.id.action_share:
                        msg += "Click share";
                        break;
                    case R.id.action_settings:
                        msg += "Click setting";
                        break;
                }

                if(!msg.equals("")) {
                    Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
                }
                return true;
            }
        });
    }
}
