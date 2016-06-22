package com.example.app;

import android.os.Bundle;
import android.app.Activity;
import android.support.design.widget.TextInputLayout;
import android.support.design.widget.TextInputEditText;
import android.view.View;
import android.widget.Button;

public class ActivityTextinputlayoutActivity extends Activity  {

    private TextInputLayout textInputLayout;
    private TextInputEditText editText;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_textinputlayout);

        textInputLayout = (TextInputLayout) findViewById(R.id.text_input_layout);
        editText = (TextInputEditText) findViewById(R.id.edit_text);
        button = (Button) findViewById(R.id.confirm);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textInputLayout.setError("输入错误");
            }
        });
    }

}
