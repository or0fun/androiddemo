package com.example.behavior;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import org.loader.mybehavior.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_2);

//        final TextView depentent = (TextView) findViewById(R.id.depentent);
//        depentent.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                ViewCompat.offsetTopAndBottom(v, 5);
//            }
//        });
    }
}
