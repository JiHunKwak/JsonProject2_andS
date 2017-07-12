package com.example.kwakgee.accountinrollment.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.kwakgee.accountinrollment.Acc_BaseActivity;
import com.example.kwakgee.accountinrollment.ExceptionCatcher.ExceptionCatcher;
import com.example.kwakgee.accountinrollment.R;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import org.json.JSONObject;

import java.util.Arrays;

public class Acc_MainActivity extends AppCompatActivity {

    private EditText edt_ID;
    private EditText edt_PW;
    private Button btn_SI;
    private Button btn_SU;
    private ExceptionCatcher exc;

    private CallbackManager callbackManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acc__main);
        FacebookSdk.sdkInitialize(this.getApplicationContext());
        setContentView(R.layout.activity_acc__main);

        ActionBar acB = getSupportActionBar();
        acB.hide();

        edt_ID = (EditText) findViewById(R.id.main_edt_ID);
        edt_PW = (EditText) findViewById(R.id.main_edt_PW);
        btn_SI = (Button) findViewById(R.id.main_btn_SI);
        btn_SU = (Button) findViewById(R.id.main_btn_SU);

        exc = ExceptionCatcher.getInstance();

        callbackManager = CallbackManager.Factory.create();

        LoginButton loginButton = (LoginButton) findViewById(R.id.main_btn_login_fb);
        loginButton.setReadPermissions(Arrays.asList("public_profile", "email"));
        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                GraphRequest graphRequest = GraphRequest.newMeRequest(loginResult.getAccessToken(), new GraphRequest.GraphJSONObjectCallback(){
                    @Override
                    public void onCompleted(JSONObject object, GraphResponse response) {
                        Log.v("result", object.toString());
                    }
                });

                Bundle parameters = new Bundle();
                parameters.putString("fields", "id,name,email,gender,birthday");
                graphRequest.setParameters(parameters);
                graphRequest.executeAsync();


            }

            @Override
            public void onCancel() {

            }

            @Override
            public void onError(FacebookException error) {
                Log.e("LoginErr", error.toString());
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }

    public void signIn(View view){
        String id = edt_ID.getText().toString();
        String password = edt_PW.getText().toString();

        if(Acc_BaseActivity.dbM.isMatch(id, password)){
            Intent intent = new Intent(Acc_MainActivity.this, Acc_PrimaryActivity.class);
            intent.putExtra("currentName", Acc_BaseActivity.dbM.currentName);
            startActivity(intent);
        }
        else{
            Toast.makeText(getApplicationContext(), "ID 또는 Password를 확인해주세요.", Toast.LENGTH_LONG).show();
        }

    }

    public void fbSignIn(View view){
        Intent intent = new Intent(getApplicationContext(), Acc_PrimaryActivity.class);
//        intent.putExtra("currentName", );
        startActivity(intent);
    }

    public void signUp(View View){
        Intent intent = new Intent(getApplicationContext(), Acc_SignUpActivity.class);
        startActivity(intent);
    }
}
