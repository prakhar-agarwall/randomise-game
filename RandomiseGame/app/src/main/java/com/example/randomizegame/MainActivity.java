package com.example.randomizegame;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int randomNumber,count,flag;
    Button try_it,start_btn;
    EditText guess_text;
    String guess_string;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try_it = findViewById(R.id.tryit);
        start_btn = findViewById(R.id.start);
        guess_text = findViewById(R.id.edittext);



        guess_text.setVisibility(View.INVISIBLE);
        try_it.setVisibility(View.INVISIBLE);

        initialize();
    }

    public void startOnClick(View view) {

        start_btn.setVisibility(View.INVISIBLE);
        guess_text.setVisibility(View.VISIBLE);
        try_it.setVisibility(View.VISIBLE);

    }

    @SuppressLint("SetTextI18n")
    public void guessOnClick(View view){

        guess_string = guess_text.getText().toString();
        if(TextUtils.isEmpty(guess_string)){
            return;
        }
        else {
            int guess_no = Integer.parseInt(guess_string);
                if (count < 10) {
                    if(guess_no < 0 || guess_no > 20) {
                        makeToast("Not Valid");
                    }
                    else if (guess_no > randomNumber) {
                        makeToast("Lower");
                        count++;
                    } else if (guess_no < randomNumber) {
                        makeToast("Higher");
                        count++;
                    } else {
                        makeToast("You guessed it right!!");
                        Toast.makeText(this, "Score: " + (10 - count), Toast.LENGTH_LONG).show();
                        change();
                    }
                } else {
                    Toast.makeText(this, "Out of lives", Toast.LENGTH_LONG).show();
                    change();
                }
            }
        }


    public void makeToast(String string){
        Toast.makeText(this, string, Toast.LENGTH_SHORT).show();
    }

    private void initialize(){
        Random rand = new Random();
        randomNumber = rand.nextInt(21);
        count=0;
        flag=0;
    }

    @SuppressLint("SetTextI18n")
    private void change(){
        guess_text.setText("");
        start_btn.setText("START NEW GAME");
        start_btn.setVisibility(View.VISIBLE);
        guess_text.setVisibility(View.INVISIBLE);
        try_it.setVisibility(View.INVISIBLE);
        flag = 1;
        initialize();
    }
}
