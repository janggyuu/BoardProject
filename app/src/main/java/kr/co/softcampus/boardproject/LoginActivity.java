package kr.co.softcampus.boardproject;

import static java.sql.DriverManager.println;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

//    ActivityLoginBinding activityLoginBinding;
    private EditText et_id, et_pass;
    private Button btn_login, btn_join;
    private TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        activityLoginBinding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(R.layout.activity_login);

        et_id = findViewById(R.id.et_login_id);
        et_pass = findViewById(R.id.et_login_pass);
        btn_login = findViewById(R.id.btn_login);
        btn_join = findViewById(R.id.btn_join);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, ListActivity.class);
                startActivity(intent);
            }
        });



    }


}