package com.rezikmag.androidacademyhomework1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText mEditText;
    Button mPreviewButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEditText = findViewById(R.id.edit_query);
        mPreviewButton = findViewById(R.id.preview_button);

        mPreviewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSecondActivity();
            }
        });

    }

    private void openSecondActivity() {
        String text = mEditText.getText().toString();
        SecondActivity.startSecondActivity(this, text);
    }


}