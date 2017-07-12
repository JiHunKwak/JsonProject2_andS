package com.example.kwakgee.accountinrollment.Activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kwakgee.accountinrollment.Acc_BaseActivity;
import com.example.kwakgee.accountinrollment.ExceptionCatcher.ExceptionCatcher;
import com.example.kwakgee.accountinrollment.R;

import java.io.File;
import java.io.IOException;

import static com.example.kwakgee.accountinrollment.Contants.Acc_Constants.REQUEST_TAKE_PHOTO;

public class Acc_SignUpActivity extends AppCompatActivity {

    private LinearLayout step1;
    private EditText edt_ID;

    private LinearLayout step2;
    private EditText edt_PW;
    private EditText edt_PWC;

    private LinearLayout step3;
    private EditText edt_NM;
    private EditText edt_PN;
    private EditText edt_EM;

    private ConstraintLayout step4;
    private ImageView img_PF;

    private LinearLayout step5;
    private ImageView img_PF_RES;
    private TextView tv_ID, tv_PW, tv_NM, tv_PN, tv_EM;

    private Animation anim;
    private ExceptionCatcher exc;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acc__sign_up);

        ActionBar acB = getSupportActionBar();
        acB.hide();

        step1 = (LinearLayout) findViewById(R.id.up_layout1);
        edt_ID = (EditText) findViewById(R.id.up_edt_ID);

        step2 = (LinearLayout) findViewById(R.id.up_layout2);
        edt_PW = (EditText) findViewById(R.id.up_edt_PW);
        edt_PWC = (EditText) findViewById(R.id.up_edt_PWC);

        step3 = (LinearLayout) findViewById(R.id.up_layout3);
        edt_NM = (EditText) findViewById(R.id.up_edt_NM);
        edt_PN = (EditText) findViewById(R.id.up_edt_PN);
        edt_EM = (EditText) findViewById(R.id.up_edt_EM);

        step4 = (ConstraintLayout) findViewById(R.id.up_layout4);
        img_PF = (ImageView) findViewById(R.id.up_img_PF);

        step5 = (LinearLayout) findViewById(R.id.up_layout5);
        img_PF_RES = (ImageView) findViewById(R.id.up_img_PF_RES);
        tv_ID = (TextView) findViewById(R.id.up_tv_ID);
        tv_PW = (TextView) findViewById(R.id.up_tv_PW);
        tv_NM = (TextView) findViewById(R.id.up_tv_NM);
        tv_PN = (TextView) findViewById(R.id.up_tv_PN);
        tv_EM = (TextView) findViewById(R.id.up_tv_EM);


        anim = AnimationUtils.loadAnimation(this, R.anim.anim);
        PageAnimationListener animL = new PageAnimationListener();
        anim.setAnimationListener(animL);

        exc = ExceptionCatcher.getInstance();
    }

    private String id;
    private String password;
    private String name;
    private String phone;
    private String email;
    private Bitmap image_bitmap;

    public int currentPage = 0;

    public void existCheck(View view){
        id = edt_ID.getText().toString();
        currentPage = 1;

        if(!Acc_BaseActivity.dbM.isEmpty()) {
            if (exc.isMatchID(id)) {
                if (!Acc_BaseActivity.dbM.isOverlap(id)) {
                    step1.setVisibility(View.INVISIBLE);
                    step1.startAnimation(anim);
                } else {
                    Toast.makeText(getApplicationContext(), "이미 사용중인 ID입니다.", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(getApplicationContext(), "ID 형식을 확인하세요.", Toast.LENGTH_SHORT).show();
            }
        }else{
            if (exc.isMatchID(id)){
                step1.setVisibility(View.INVISIBLE);
                step1.startAnimation(anim);
            } else {
                Toast.makeText(getApplicationContext(), "ID 형식을 확인하세요.", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void passwordCheck(View view){
        password = edt_PW.getText().toString();
        String passwordChecker = edt_PWC.getText().toString();
        currentPage = 2;

        if(exc.isMatchPW(password)){
            if(password.equals(passwordChecker)){
                step2.setVisibility(View.INVISIBLE);
                step2.startAnimation(anim);
            } else {
                Toast.makeText(getApplicationContext(), "비밀번호가 서로 일치하지 않습니다.", Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(getApplicationContext(), "비밀번호 형식을 확인하세요.", Toast.LENGTH_SHORT).show();
        }
    }

    public void otherCheck(View view){
        name = edt_NM.getText().toString();
        phone = edt_PN.getText().toString();
        email = edt_EM.getText().toString();
        currentPage = 3;

        if(exc.isMatchOther(name, phone, email)){
            step3.setVisibility(View.INVISIBLE);
            step3.startAnimation(anim);
            Toast.makeText(getApplicationContext(), "프로필 이미지 변경을 하지 않아도 다음에 수정 할 수 있습니다.", Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(getApplicationContext(), "이름 또는 휴대폰번호, 이메일 형식을 확인하세요.", Toast.LENGTH_SHORT).show();
        }

    }

    public void imageCheck(View view){
        doTakeAlbumAction();
    }

    public void imageConfirm(View view){
        currentPage = 4;

        tv_ID.setText("ID: " + id);
        tv_PW.setText("비밀번호: " + password);
        tv_NM.setText("이름: " + name);
        tv_PN.setText("전화번호: " + phone);
        tv_EM.setText("E-mail: " + email);

        step4.setVisibility(View.INVISIBLE);
        step4.startAnimation(anim);
    }

    String mCurrentPhotoPath;
    Uri photoURI, albumURI = null;
    Boolean album = false;

    private File createImageFile() throws IOException{
        String imageFileName = "tmp_" + String.valueOf(System.currentTimeMillis()) + ".jpg";
        File storageDir = new File(Environment.getExternalStorageDirectory(), imageFileName);
        mCurrentPhotoPath = storageDir.getAbsolutePath();

        return storageDir;
    }

    private void doTakeAlbumAction(){

        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType(MediaStore.Images.Media.CONTENT_TYPE);
        startActivityForResult(intent, REQUEST_TAKE_PHOTO);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(resultCode != RESULT_OK){
            Toast.makeText(getApplicationContext(), "onActivityResult : RESULT_NOT_OK", Toast.LENGTH_SHORT).show();
        } else {
            switch (requestCode){
                case REQUEST_TAKE_PHOTO:
                    album = true;
                    File albumFile = null;

                    try{
                        albumFile = createImageFile();
                    }catch(IOException e){
                        e.printStackTrace();
                    }

                    if(albumFile != null){
                        albumURI = Uri.fromFile(albumFile);
                    }

                    photoURI = data.getData();

                    image_bitmap = null;
                    try{
                        image_bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), photoURI);
                    }catch(IOException e){
                        e.printStackTrace();
                    }
                    img_PF.setImageBitmap(image_bitmap);
                    img_PF_RES.setImageBitmap(image_bitmap);
                    break;

            }
        }
    }

    public void reset(View view){
        Intent intent = new Intent(getApplicationContext(), Acc_MainActivity.class);
        startActivity(intent);
    }

    public void createNewAccount(View view){
//        Acc_BaseActivity.accArray.add(new Acc_Account(id, password, name, phone, email, image_bitmap));
        Acc_BaseActivity.dbM.insert("INSERT INTO Account VALUES('"+id+"', '"+password+"', '"+name+"', '"+phone+"', '"+email+"');");
//        Acc_BaseActivity.dbM.saveData();
        Toast.makeText(getApplicationContext(), "정상적으로 가입되셨습니다.", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(getApplicationContext(), Acc_MainActivity.class);
        startActivity(intent);
    }


    public class PageAnimationListener implements Animation.AnimationListener{
        @Override
        public void onAnimationStart(Animation animation) {

        }

        @Override
        public void onAnimationEnd(Animation animation) {
            switch(currentPage){
                case 1:
                    step2.setVisibility(View.VISIBLE);
                    break;
                case 2:
                    step3.setVisibility(View.VISIBLE);
                    break;
                case 3:
                    step4.setVisibility(View.VISIBLE);
                    break;
                case 4:
                    step5.setVisibility(View.VISIBLE);
                    break;
            }
        }

        @Override
        public void onAnimationRepeat(Animation animation) {

        }
    }
}
