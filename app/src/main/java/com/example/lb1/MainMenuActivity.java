package com.example.lb1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;

public class MainMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
    }

    public void goToDesigner(View view){
        setContentView(R.layout.activity_block_designer);
        Intent intent = new Intent(this, BlockDesigner.class);
        startActivity(intent);
    }

    public void goToLogin(View view) {
        setContentView(R.layout.activity_login);
        Intent intent = new Intent(this, login.class);
        startActivity(intent);
    }

    public void goToRegister(View view){
        setContentView(R.layout.activity_main);
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void goToGPS(View view){
        
    }
}
