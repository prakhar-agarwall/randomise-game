package com.example.randomizegame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int randomNumber,count,flag;
    Button try_it;

    public void makeToast(String string){
        Toast.makeText(this, string, Toast.LENGTH_SHORT).show();
    }

    public void guessOnClick(View view){

        EditText guess_text = (EditText) findViewById(R.id.edittext);
        String guess_string = guess_text.getText().toString();

        if(TextUtils.isEmpty(guess_string)){
            return;
        }
        else {
            int guess_no = Integer.parseInt(guess_string);

            if (flag == 1) {
                try_it.setText("TRY IT!!");
                flag = 0;
                initialize();
            } else {

                if (count < 10) {

                    if (guess_no > randomNumber) {
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
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try_it = findViewById(R.id.tryit);
        initialize();
    }

    private void initialize(){
        Random rand = new Random();
        randomNumber = rand.nextInt(21);
        count=0;
        flag=0;
    }

    private void change(){
        try_it.setText("NEW GAME");
        flag = 1;
    }
}
