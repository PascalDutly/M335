package com.example.lb1;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.FileNotFoundException;

public class MemeDesigner extends Activity {

    TextView textTargetUri;
    ImageView targetImage;

    TextView upperText;
    TextView bottomText;

    TextView upperTextView;
    TextView bottomTextView;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meme_designer);
        Button buttonLoadImage = (Button)findViewById(R.id.loadimage);
        textTargetUri = (TextView)findViewById(R.id.targeturl);
        targetImage = (ImageView)findViewById(R.id.targetimage);

        buttonLoadImage.setOnClickListener(new Button.OnClickListener(){

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                Intent intent = new Intent(Intent.ACTION_PICK,
                        MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent, 0);
            }});
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // TODO Auto-generated method stub
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK){
            Uri targetUri = data.getData();
            textTargetUri.setText(targetUri.toString());
            Bitmap bitmap;
            try {
                bitmap = BitmapFactory.decodeStream(getContentResolver().openInputStream(targetUri));
                targetImage.setImageBitmap(bitmap);
            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    public void applyText(View view){
        upperText = (TextView)findViewById(R.id.uppertext);
        bottomText = (TextView)findViewById(R.id.bottomtext);

        String text1 = upperText.getText().toString();
        String text2 = bottomText.getText().toString();

        upperTextView = (TextView)findViewById(R.id.uppertextview);
        bottomTextView = (TextView)findViewById(R.id.bottomtextview);

        upperTextView.setText(text1);
        bottomTextView.setText(text2);
    }

    public void goToMain(View view){
        setContentView(R.layout.activity_main_menu);
        Intent intent = new Intent(this, MainMenuActivity.class);
        startActivity(intent);
    }
}