package kr.co.softcampus.boardproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class EditActivity extends AppCompatActivity {

    private EditText et_edit_title;
    private EditText et_edit_content;
    private TextView tv_edit_writeDate;
    private TodoItem item;
    private int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        et_edit_title = findViewById(R.id.et_edit_title);
        et_edit_content = findViewById(R.id.et_edit_content);
        tv_edit_writeDate = findViewById(R.id.tv_edit_writeDate);

        //객체를 추출한다.
        Intent intent = getIntent();

        //객체를 복원한다.
        item = intent.getParcelableExtra("item");

        et_edit_title.setText(item.getTitle());
        et_edit_content.setText(item.getContent());
        tv_edit_writeDate.setText(item.getWriteDate());
        id = item.getId();

        //수정버튼 클릭시
        Button button = findViewById(R.id.btn_edit_);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent resultIntent = new Intent();

                //객체를 생성한다.
                TodoItem resultItem = new TodoItem();
                String edit_title = et_edit_title.getText().toString();
                String edit_content = et_edit_content.getText().toString();
                String writeDate = tv_edit_writeDate.getText().toString();
                resultItem.setTitle(edit_title);
                resultItem.setContent(edit_content);
                resultItem.setWriteDate(writeDate);
                resultItem.setId(id);

                resultIntent.putExtra("result", resultItem);

                setResult(RESULT_OK, resultIntent);

                finish();

            }
        });
    }
}