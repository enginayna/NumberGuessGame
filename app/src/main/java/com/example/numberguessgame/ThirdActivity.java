package com.example.numberguessgame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ThirdActivity extends AppCompatActivity {
    private Button buttonTekrarOyna;
    private TextView textViewResult;
    private ImageView imageSmile;
    private boolean sonuc;
    private TextView textViewSayi;
    private int sayi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        buttonTekrarOyna = findViewById(R.id.buttonTekrarOyna);
        textViewResult = findViewById(R.id.textViewResult);
        imageSmile = findViewById(R.id.imageSmile);
        textViewSayi = findViewById(R.id.textViewSayi);
        sayi = getIntent().getIntExtra("sayi" , 45);
        sonuc = getIntent().getBooleanExtra("Sonuc" , true);
        if (sonuc){
            imageSmile.setImageResource(R.drawable.ic_insert_emoticon_black_24dp);
            textViewResult.setText("KAZANDINIZ");
            textViewSayi.setText("" + sayi);
        }
        else{
            imageSmile.setImageResource(R.drawable.ic_sentiment_dissatisfied_black_24dp);
            textViewResult.setText("KAYBETTINIZ");
            textViewSayi.setText("" + sayi);
        }

        buttonTekrarOyna.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ThirdActivity.this , MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
