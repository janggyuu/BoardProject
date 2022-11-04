package kr.co.softcampus.boardproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

import kr.co.softcampus.boardproject.databinding.ActivityRegisterBinding;

public class RegisterActivity extends AppCompatActivity {

//    ActivityRegisterBinding activityRegisterBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        activityRegisterBinding = ActivityRegisterBinding.inflate(getLayoutInflater());
        setContentView(R.layout.activity_register);
    }
}