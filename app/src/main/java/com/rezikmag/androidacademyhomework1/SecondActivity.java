package com.rezikmag.androidacademyhomework1;

import android.app.Activity;
import android.app.Notification;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    TextView mTextView;
    Button mEmailButton;

    public static final String MESSAGE_KEY = "message";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        mTextView = findViewById(R.id.text_preview);
        mEmailButton = findViewById(R.id.email_button);

        Intent intent = getIntent();
        final String text = intent.getStringExtra(MESSAGE_KEY);

        mTextView.setText(text);


        mEmailButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("plain/text");
                intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"androidacademy@msk.com"});
                intent.putExtra(Intent.EXTRA_SUBJECT, "HomeWork");
                intent.putExtra(Intent.EXTRA_TEXT, text);
                try {
                    startActivity(intent);
                }catch (Exception e){
                   showToast();
                }

            }
        });

    }


    public static void startSecondActivity(Activity activity, String message) {
        Intent intent = new Intent(activity, SecondActivity.class);
        intent.putExtra(MESSAGE_KEY, message);
        activity.startActivity(intent);
    }

    public void showToast(){
        Toast.makeText(this, "No Email app found", Toast.LENGTH_LONG).show();
    }
}
