package com.example.kwakgee.jsonproject3.JSon_Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.kwakgee.jsonproject3.JSon_DataManager.DataManager;
import com.example.kwakgee.jsonproject3.JSon_View.JsonAdapter;
import com.example.kwakgee.jsonproject3.R;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private JsonAdapter jsonAdapter;
    private LinearLayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DataManager dM = new DataManager();
        dM.loadData();

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        layoutManager = new LinearLayoutManager(MainActivity.this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        jsonAdapter = new JsonAdapter(dM.listArr, getApplicationContext());
        recyclerView.setAdapter(jsonAdapter);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

    }
}
