package kr.co.softcampus.boardproject;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.List;

public class Index extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);

        Button btn_Toboard = findViewById(R.id.button3);
        btn_Toboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Index.this, ListActivity.class);
                startActivity(intent);
            }
        });
        Button btn_ToAlbum = findViewById(R.id.button4);
        btn_ToAlbum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Index.this, SimpleAlbum.class);
                startActivity(intent);
            }
        });
    }
}