package com.example.oleh.testingeverything;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.XmlResourceParser;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText usernameText = (EditText) findViewById(R.id.username);
        final EditText passwordText = (EditText) findViewById(R.id.password);
        Button showButton = (Button) findViewById(R.id.button);

        passwordText.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);


        showButton.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){

                String username = usernameText.getText().toString();
                String password = passwordText.getText().toString();

                if(Controller.checkLogin(username,password)){

                    Intent i = new Intent(MainActivity.this, Search_Activity.class);

                    startActivity(i);

                }
                else{

                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setTitle("Cannot login");
                    builder.setMessage("Invalid password or username");
                    builder.setPositiveButton("Try again", null);

                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();

                }

            }

        });

    }




}
