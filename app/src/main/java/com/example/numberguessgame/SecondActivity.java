package com.example.numberguessgame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class SecondActivity extends AppCompatActivity {
    private TextView textViewKalanHak;
    private TextView textViewGosterge;
    private Button buttonSansiniDene;
    private EditText editTextTahminEt;
    private int count;
    private int number;
    private int temp;
    private int counter = 5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        textViewKalanHak = findViewById(R.id.textViewKalanHak);
        textViewGosterge = findViewById(R.id.textViewGosterge);
        buttonSansiniDene = findViewById(R.id.buttonSansiniDene);
        editTextTahminEt = findViewById(R.id.editTextTahminEt);

        Random random = new Random();
        number = random.nextInt(101);
        count = 5;
        Log.e("Result", String.valueOf(number));
        buttonSansiniDene.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                temp = Integer.valueOf(editTextTahminEt.getText().toString());

                if(count > 0){
                    if (temp == number){
                        Intent intent = new Intent(SecondActivity.this , ThirdActivity.class);
                        intent.putExtra("Sonuc" , true);
                        intent.putExtra("sayi" , number);
                        startActivity(intent);
                        finish();
                    }

                    if (temp > number){
                        textViewGosterge.setText("Azalt");

                    }
                    if (temp < number){
                        textViewGosterge.setText("Arttir");

                    }
                    textViewKalanHak.setText("Kalan Hak : " + (count-1));
                    editTextTahminEt.setText("");
                }
                count--;
                if(count==0){
                    Intent intent = new Intent(SecondActivity.this , ThirdActivity.class);
                    intent.putExtra("Sonuc" , false);
                    intent.putExtra("sayi" , number);
                    startActivity(intent);
                    finish();
                }

            }
        });
    }
}


