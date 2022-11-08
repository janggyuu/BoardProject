package kr.co.softcampus.boardproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

import kr.co.softcampus.boardproject.databinding.ActivityRegisterBinding;

public class RegisterActivity extends AppCompatActivity {

    private EditText et_reg_title;
    private EditText et_reg_content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_register);

        et_reg_title = findViewById(R.id.et_reg_title);
        et_reg_content = findViewById(R.id.et_reg_content);

        Button btn_reg = findViewById(R.id.btn_reg);
        btn_reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Insert Database
                String currentTime = new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date()); // 현재 시간 받아오기
                ListActivity.mDBHelper.InsertTodo(et_reg_title.getText().toString(), et_reg_content.getText().toString(), currentTime);

                //Insert UI
                TodoItem item = new TodoItem();
                item.setTitle(et_reg_title.getText().toString());
                item.setContent(et_reg_content.getText().toString());
                item.setWriteDate(currentTime);

                ListActivity.mAdapter.addItem(item);
                ListActivity.mRv_todo.smoothScrollToPosition(0);
                Toast.makeText(RegisterActivity.this, "할일 목록에 추가 되었습니다.", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(RegisterActivity.this, ListActivity.class);
                startActivity(intent);
            }
        });
    }
}
