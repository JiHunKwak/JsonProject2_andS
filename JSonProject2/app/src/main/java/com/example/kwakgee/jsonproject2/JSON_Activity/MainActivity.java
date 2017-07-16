package com.example.kwakgee.jsonproject2.JSON_Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;

import com.example.kwakgee.jsonproject2.JSON_DataManager.HttpConnecter;
import com.example.kwakgee.jsonproject2.JSON_DataManager.ImageManager;
import com.example.kwakgee.jsonproject2.JSON_DataManager.JSONManager;
import com.example.kwakgee.jsonproject2.JSON_View.JsonItemView;
import com.example.kwakgee.jsonproject2.R;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private JSONManager jsonM = JSONManager.getInstance();
    ImageManager imgM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        HttpConnecter htC = HttpConnecter.getInstance();
        htC.start();
        try{ htC.join(); }catch (Exception e){} // 스레드 상태 제어.

        jsonM.jsonReader();

        imgM = ImageManager.getInstance();
        imgM.start();
        try{ imgM.join(); }catch (Exception e){} // 스레드 상태 제어.

        listView = (ListView) findViewById(R.id.listView);

        JsonAdapter adapter = new JsonAdapter();
        listView.setAdapter(adapter);

    }

    class JsonAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return jsonM.objArr.size();
        }

        @Override
        public Object getItem(int i) {
            return jsonM.objArr.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {

            JsonItemView jsonItemView = new JsonItemView(getApplicationContext());

            jsonItemView.setRank(jsonM.objArr.get(i).getRank());
            jsonItemView.setSequence(jsonM.objArr.get(i).getSequence());
            jsonItemView.setImage(imgM.bmpArr.get(i));

            return jsonItemView;

        }
    } // ListView에 데이터를 담기위한 내부 클래스. (Adapter 공부하기)

}
