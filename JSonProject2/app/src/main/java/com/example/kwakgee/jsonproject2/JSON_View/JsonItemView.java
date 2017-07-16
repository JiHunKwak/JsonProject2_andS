package com.example.kwakgee.jsonproject2.JSON_View;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.kwakgee.jsonproject2.R;

/**
 * Created by kwakgee on 2017. 7. 16..
 */

public class JsonItemView extends LinearLayout {
    // 리니어 레이아웃을 상속받는 클래스. ListView를 사용하기위해 만든 자바 클래스이다.
    // 일단 부분적으로 강의를 본 상태라 앞뒤 내용이 이어지지 않아 정확히 이해는 하지 못하였다.

    ImageView iv_image;
    TextView tv_rank;
    TextView tv_sequence;

    public JsonItemView(Context context) {
        super(context);

        init(context);
    }

    public JsonItemView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        init(context);
    }

    private void init(Context context) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.json_item, this, true); // Inflater 공부하기

        iv_image = (ImageView) findViewById(R.id.iv_image);
        tv_rank = (TextView) findViewById(R.id.tv_rank);
        tv_sequence = (TextView) findViewById(R.id.tv_sequence);


    }

    public void setRank(String rank){
        tv_rank.setText(rank);
    }

    public void setSequence(String sequence){
        tv_sequence.setText(sequence);
    }

    public void setImage(Bitmap image){
        iv_image.setImageBitmap(image);
    }

}
