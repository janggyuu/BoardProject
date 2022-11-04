package kr.co.softcampus.boardproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import kr.co.softcampus.boardproject.databinding.ActivityDetailBinding;

public class DetailActivity extends AppCompatActivity {

    ActivityDetailBinding activityDetailBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        activityDetailBinding = ActivityDetailBinding.inflate(getLayoutInflater());
        setContentView(activityDetailBinding.getRoot());
    }
}