package com.example.kwakgee.jsonproject2.JSON_DataManager;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kwakgee on 2017. 7. 16..
 */

public class ImageManager extends Thread {

    private static ImageManager imgM = new ImageManager();
    private ImageManager(){}
    public static ImageManager getInstance(){
        return imgM;
    }

    public List<Bitmap> bmpArr;

    @Override
    public void run() {

        JSONManager jsonM = JSONManager.getInstance();

        bmpArr = new ArrayList<>();

        try{
            for(int i=0; i<jsonM.objArr.size(); i++) {
                URL url = new URL(jsonM.objArr.get(i).getImageSrc());
                Bitmap bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream());
                bmpArr.add(bmp);
            }
        }catch(Exception e){
            e.printStackTrace();
        }

    }

}
