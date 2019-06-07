package com.example.lb1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;

public class login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void goToRegistration(View view){
        setContentView(R.layout.activity_main);
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void goToMain(View view){
        setContentView(R.layout.activity_main_menu);
        Intent intent = new Intent(this, MainMenuActivity.class);
        startActivity(intent);
    }
}
