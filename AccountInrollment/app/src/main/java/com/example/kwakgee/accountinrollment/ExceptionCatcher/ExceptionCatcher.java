package com.example.kwakgee.accountinrollment.ExceptionCatcher;

import java.util.regex.Pattern;

/**
 * Created by kwakgee on 2017. 7. 11..
 */

public class ExceptionCatcher {

    public static ExceptionCatcher exc = new ExceptionCatcher();
    private ExceptionCatcher(){
    }
    public static ExceptionCatcher getInstance(){
        return exc;
    }

    public boolean isMatchID(String id){
        Pattern idP = Pattern.compile("^[a-zA-Z0-9]{5,15}$");
        if(idP.matcher(id).find()) return true;
        else return false;

    }

    public boolean isMatchPW(String pw){
        Pattern passwordP = Pattern.compile("^[a-z0-9]{5,15}$");
        if(passwordP.matcher(pw).find()) return true;
        else return false;

    }

    public boolean isMatchOther(String name, String phone, String email){
        Pattern nameP = Pattern.compile("^[a-zA-z가-힣]{2,5}$");
        Pattern phoneP = Pattern.compile("^01(?:0|1|[6-9])-(?:\\d{3}|\\d{4})-\\d{4}$");
        Pattern emailP = Pattern.compile("^[a-zA-Z0-9]+@[a-z]+.(com|net)$");

        if(nameP.matcher(name).find() && phoneP.matcher(phone).find() && emailP.matcher(email).find())
            return true;
        return false;

    }

//    public String currentName;
//
//    public boolean isMatch(String id, String pw){
//        for(int i = 0; i< Acc_BaseActivity.accArray.size(); i++){
//            if(id.equals(Acc_BaseActivity.accArray.get(i).getId())){
//                if(pw.equals(Acc_BaseActivity.accArray.get(i).getPassword())){
//                    currentName = Acc_BaseActivity.accArray.get(i).getName();
//                    return true;
//                }
//            }
//        }
//        return false;
//    }
//
//    public boolean isOverlap(String userData){
//        for(int i=0; i<Acc_BaseActivity.accArray.size(); i++){
//            if(Acc_BaseActivity.accArray.get(i).getId().equals(userData)){
//                return true;
//            }
//        }
//        return false;
//    }

}
