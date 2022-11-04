package kr.co.softcampus.boardproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class JoinActivity extends AppCompatActivity {

//    ActivityJoinBinding activityJoinBinding;
    private EditText et_id, et_pass, et_name, et_age;
    private Button button_join;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//       activityJoinBinding = ActivityJoinBinding.inflate(getLayoutInflater());
        setContentView(R.layout.activity_join);

        et_id = findViewById(R.id.et_id);
        et_pass = findViewById(R.id.et_login_pass);
        et_name = findViewById(R.id.et_name);
        et_age = findViewById(R.id.et_age);

        button_join = findViewById(R.id.button_join);

    }
}