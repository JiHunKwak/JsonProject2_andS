package com.example.kwakgee.jsonproject2.JSON_DataManager;

import com.example.kwakgee.jsonproject2.JSON_Constants.Constants;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by kwakgee on 2017. 7. 15..
 */

public class HttpConnecter extends Thread{  // 안드로이드 스튜디오에서 여러 이유 때문에
                                            // 메인쓰레드에서의 http통신을 막아놓아, 임의의 쓰레드 사용

    private static HttpConnecter daM = new HttpConnecter();
    private HttpConnecter(){

    }
    public static HttpConnecter getInstance(){
        return daM;
    }

    public String httpResult;


    @Override
    public void run() {

        try {

            String reqURL = Constants.REQUEST_URL;
            URL url = new URL(reqURL);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            connection.setConnectTimeout(3000);
            connection.setReadTimeout(3000);

            InputStream in = null;
            ByteArrayOutputStream out = null;

            try{

                in = connection.getInputStream();
                out = new ByteArrayOutputStream();

                byte[] buf = new byte[1024 * 8];
                int length = 0;
                while((length = in.read(buf)) != -1){
                    out.write(buf, 0, length);
                }

                httpResult = new String(out.toByteArray(), "UTF-8");
//                Log.v("\nHttp Result: ", httpResult);


            }finally {
                if(in != null) in.close();
                if(out != null) out.close();
            }

        }catch(Exception e){
            e.printStackTrace();
        }

    }
}
