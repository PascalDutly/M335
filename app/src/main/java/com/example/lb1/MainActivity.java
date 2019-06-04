package com.example.lb1;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    private boolean areFieldsFilled = false;
    private boolean arePasswordsEqual = false;

    TextView text;
    TextView err1;
    TextView err2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.err1 = findViewById(R.id.textView);
        this.err2 = findViewById(R.id.textView2);
    }

    @SuppressLint("SetTextI18n")
    public void createUser(View view){

        this.text = findViewById(R.id.username);
        String username = text.getText().toString();

        this.text = findViewById(R.id.firstname);
        String firstName = text.getText().toString();

        this.text = findViewById(R.id.lastname);
        String lastName = text.getText().toString();

        this.text = findViewById(R.id.password);
        String password = text.getText().toString();

        this.text = findViewById(R.id.repPassword);
        String repPassw = text.getText().toString();

        this.text = findViewById(R.id.email);
        String email = text.getText().toString();

        if (username.equals("") || firstName.equals("") || lastName.equals("") || password.equals("") || email.equals("")){
            this.err1.setText(getString(R.string.textNotEntered));
            areFieldsFilled = false;
        }else{
            this.err1.setText("");
            areFieldsFilled = true;
        }

        if (!password.equals(repPassw)){
            this.err2.setText("Die Passwörter sind nicht gleich");
            arePasswordsEqual = false;
        } else{
            this.err2.setText("");
            arePasswordsEqual = true;
        }

        if (areFieldsFilled && arePasswordsEqual) {
            User user = new User(username, password, firstName, lastName, email);
            System.out.println(user.username);

            goToMain(view);
        } else{
            arePasswordsEqual = false;
            areFieldsFilled = false;
        }
    }

    public void goToMain(View view){
        setContentView(R.layout.activity_main_menu);
        Intent intent = new Intent(this, MainMenuActivity.class);
        startActivity(intent);
    }
}
