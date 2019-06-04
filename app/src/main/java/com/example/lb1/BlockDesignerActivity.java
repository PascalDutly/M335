package com.example.lb1;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.GridView;

@SuppressLint("Registered")
public class BlockDesignerActivity extends AppCompatActivity {

    GridView gv;

    String[] value1 = new String[]{"0", "1", "0", "1", "0"};
    String imc_met;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.block_designer);

        gv = (GridView) findViewById(R.id.grid_view1);
        ArrayAdapter<String> ad =
                new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, value1);

        gv.setAdapter(ad);
    }

    public void goToMainMenu(View view){
        setContentView(R.layout.activity_main_menu);
        Intent intent = new Intent(this, MainMenuActivity.class);
        startActivity(intent);
    }
}

//OLD