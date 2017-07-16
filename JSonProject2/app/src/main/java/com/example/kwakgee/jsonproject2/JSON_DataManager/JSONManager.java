package com.example.kwakgee.jsonproject2.JSON_DataManager;

import com.example.kwakgee.jsonproject2.JSON_Object.ListObject;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kwakgee on 2017. 7. 16..
 */

public class JSONManager {

    private static JSONManager jsonM = new JSONManager();
    private JSONManager(){}
    public static JSONManager getInstance(){
        return jsonM;
    }


    public List<ListObject> objArr;

    public void jsonReader(){
        HttpConnecter htC = HttpConnecter.getInstance();
        String httpDataBuffer = htC.httpResult;

        objArr = new ArrayList<>();

        try {
            JSONObject jsonObject = new JSONObject(httpDataBuffer);
            JSONObject jsonListObj = (JSONObject) jsonObject.get("testCase");
            JSONArray jsonList = (JSONArray) jsonListObj.get("testList");

            String rank;
            String sequence;
            String imageSrc;
            JSONObject jsonObjBuffer;

            for(int i=0; i<jsonList.length(); i++){
                jsonObjBuffer = (JSONObject) jsonList.get(i);
                rank = jsonObjBuffer.getString("rank");
                sequence = jsonObjBuffer.getString("Nm");
                imageSrc = jsonObjBuffer.getString("url");

//                Log.v("buffer: ", sequence);
                objArr.add(new ListObject(rank, sequence, imageSrc));
            }

        }catch(Exception e){
            e.printStackTrace();
        }
    }

}
