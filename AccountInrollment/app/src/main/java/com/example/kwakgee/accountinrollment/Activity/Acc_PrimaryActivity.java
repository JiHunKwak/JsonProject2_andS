package com.example.kwakgee.accountinrollment.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.kwakgee.accountinrollment.R;

public class Acc_PrimaryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acc__primary);

        String message = getIntent().getStringExtra("currentName");
        Toast.makeText(getApplicationContext(), message + "님 환영합니다.", Toast.LENGTH_LONG).show();
    }
}
