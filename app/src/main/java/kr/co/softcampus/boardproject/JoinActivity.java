package kr.co.softcampus.boardproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.tasks.OnCanceledListener;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserInfo;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.json.JSONException;
import org.json.JSONObject;

public class JoinActivity extends AppCompatActivity {

//    ActivityJoinBinding activityJoinBinding;
    private FirebaseAuth mFirebaseAuth;    //파이어베이스 인증 처리
    private DatabaseReference mDatabaseRef; //실시간 데이터베이스

    private EditText et_id, et_pass; //et_name, et_age;  //회원가입 정보 입력
    private Button button_join;                       //회원가입 버튼

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//       activityJoinBinding = ActivityJoinBinding.inflate(getLayoutInflater());
        setContentView(R.layout.activity_join);

        mFirebaseAuth = FirebaseAuth.getInstance();
        mDatabaseRef = FirebaseDatabase.getInstance().getReference("BoardProject");

        et_id = findViewById(R.id.et_id);
        et_pass = findViewById(R.id.et_pass);
/*        et_name = findViewById(R.id.et_name);
        et_age = findViewById(R.id.et_age);*/

        button_join = findViewById(R.id.button_join);

        button_join.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //회원가입 처리
                String strEmail = et_id.getText().toString();
                String strPass = et_pass.getText().toString();

                //회원가입 정보가 비어 있을때
                if(et_id.length() == 0 || et_pass.length() == 0){
                    Toast.makeText(JoinActivity.this, "회원가입 정보를 입력하세요", Toast.LENGTH_SHORT).show();
                    return;
                }

                //FirebaseAuth 진행
                mFirebaseAuth.createUserWithEmailAndPassword(strEmail, strPass).addOnCompleteListener(JoinActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            FirebaseUser firebaseUser = mFirebaseAuth.getCurrentUser();
                            UserAccount account = new UserAccount();
                            account.setIdToken(firebaseUser.getUid());
                            account.setEmailId(firebaseUser.getEmail());
                            account.setPassword(strPass);

                            //setValue : database에 insert 하는것
                            mDatabaseRef.child("UserAccount").child(firebaseUser.getUid()).setValue(account);

                            Toast.makeText(JoinActivity.this, "회원가입에 성공하였습니다.", Toast.LENGTH_SHORT).show();
                            finish();
                        }
                        else{
                            Toast.makeText(JoinActivity.this, "회원가입에 실패하였습니다.", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });

    }
}

