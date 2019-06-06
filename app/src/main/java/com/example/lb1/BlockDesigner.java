package com.example.lb1;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.GridView;


public class BlockDesigner extends AppCompatActivity {

    GridView gv;

    String[] value1 = new String[]{ "0", "1", "0", "1", "0", "1", "0", "1", "0", "1", "0", "1", "0", "1", "0", "1",
            "0", "1", "0", "1", "0", "1", "0", "1","0", "1", "0", "1", "0", "1", "0", "1",
            "0", "1", "0", "1", "0", "1", "0", "1","0", "1", "0", "1", "0", "1", "0", "1",
            "0", "1", "0", "1", "0", "1", "0", "1","0", "1", "0", "1", "0", "1", "0", "1",
            "0", "1", "0", "1", "0", "1", "0", "1","0", "1", "0", "1", "0", "1", "0", "1",
            "0", "1", "0", "1", "0", "1", "0", "1","0", "1", "0", "1", "0", "1", "0", "1",
            "0", "1", "0", "1", "0", "1", "0", "1","0", "1", "0", "1", "0", "1", "0", "1",
            "0", "1", "0", "1", "0", "1", "0", "1","0", "1", "0", "1", "0", "1", "0", "1",
            "0", "1", "0", "1", "0", "1", "0", "1","0", "1", "0", "1", "0", "1", "0", "1",
            "0", "1", "0", "1", "0", "1", "0", "1","0", "1", "0", "1", "0", "1", "0", "1",
            "0", "1", "0", "1", "0", "1", "0", "1","0", "1", "0", "1", "0", "1", "0", "1",
            "0", "1", "0", "1", "0", "1", "0", "1","0", "1", "0", "1", "0", "1", "0", "1",
            "0", "1", "0", "1", "0", "1", "0", "1","0", "1", "0", "1", "0", "1", "0", "1",
            "0", "1", "0", "1", "0", "1", "0", "1","0", "1", "0", "1", "0", "1", "0", "1",
            "0", "1", "0", "1", "0", "1", "0", "1","0", "1", "0", "1", "0", "1", "0", "1",
            "0", "1", "0", "1", "0", "1", "0", "1", "0", "1", "0", "1", "0", "1", "0", "1", };
    String imc_met;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_block_designer);

        gv=(GridView)findViewById(R.id.grid_view1);
        ArrayAdapter<String> ad =
                new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,value1);

        gv.setBackgroundColor(Color.RED);

        gv.setAdapter(ad);
    }

    /*ArrayAdapter<String> ad = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, value1) {
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = super.getView(position, convertView, parent);
            String value = getItem(position);
            if (value.equals("0")) {
                view.setBackgroundColor(Color.GRAY);
            } else {
                view.setBackgroundColor(Color.RED);
            }
            // Updating the text color.
            TextView textView= (TextView) view;
            textView.setTextColor(Color.BLACK);
            return view;
        }
    };*/

    public void goToMainMenu(View view){
        setContentView(R.layout.activity_main_menu);
        Intent intent = new Intent(this, MainMenuActivity.class);
        startActivity(intent);
    }
}
