package com.example.kwakgee.jsonproject3.JSon_Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.kwakgee.jsonproject3.JSon_DataManager.DataManager;
import com.example.kwakgee.jsonproject3.JSon_View.JsonAdapter;
import com.example.kwakgee.jsonproject3.R;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private JsonAdapter jsonAdapter;
    private LinearLayoutManager layoutManager;
    private DataManager dM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dM = new DataManager();
        dM.loadData();

        Button btn = (Button) findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.v("Res!!!1", "123123123");

                recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

                layoutManager = new LinearLayoutManager(MainActivity.this);
                layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

                jsonAdapter = new JsonAdapter(dM.listArr, getApplicationContext());
                recyclerView.setAdapter(jsonAdapter);
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setItemAnimator(new DefaultItemAnimator());

            }
        });

    }
}
