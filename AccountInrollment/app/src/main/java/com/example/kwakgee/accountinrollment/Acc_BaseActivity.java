package com.example.kwakgee.accountinrollment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;

import com.example.kwakgee.accountinrollment.Activity.Acc_MainActivity;
import com.example.kwakgee.accountinrollment.DBManager.Acc_DBManager;

public class Acc_BaseActivity extends AppCompatActivity {

    public static Acc_DBManager dbM;
//    public static List<Acc_Account> accArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acc__base);

        dbM = new Acc_DBManager(getApplicationContext(), "Account.db", null, 1);
//        dbM.delete("DELETE FROM Account");
//        dbM.loadData();곽지

//        accArray = new ArrayList<>();

        ActionBar acB = getSupportActionBar();
        acB.hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(getApplicationContext(), Acc_MainActivity.class);
                startActivity(intent);

                finish();
            }
        }, 3000);


    }
}
