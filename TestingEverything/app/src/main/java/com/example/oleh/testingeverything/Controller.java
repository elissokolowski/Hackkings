package com.example.oleh.testingeverything;

import android.content.res.XmlResourceParser;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Controller {

    static ArrayList<String> alltags = new ArrayList<>();

    public Controller(){

        setListeners();

    }

    public void setListeners(){


    }

    public static boolean checkLogin(String testUsername, String testPassword){

        String username = "root";
        String password = "1234";

        if(testPassword.equals(password) && testUsername.equals(username)){

            return true;

        }
        else {

            return false;

        }

    }

    public static void addSelectedTags(ArrayList<String> tags){
        alltags = tags;


    }

    public static ArrayList<String> getTags(){

        return alltags;

    }


}
