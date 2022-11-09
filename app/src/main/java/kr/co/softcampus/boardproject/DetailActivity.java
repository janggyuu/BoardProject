package kr.co.softcampus.boardproject;

import static kr.co.softcampus.boardproject.CustomAdapter.mContext;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import kr.co.softcampus.boardproject.databinding.ActivityDetailBinding;

public class DetailActivity extends AppCompatActivity {

    private TextView tv_title;
    private TextView tv_content;
    private TextView tv_writeDate;
    private TodoItem item;
    private TodoItem item2;
    private int id;

    ActivityResultLauncher<Intent> editActivityLauncher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_detail);

        DetailActivity.EditActivityCallback callback1 = new DetailActivity.EditActivityCallback();
        ActivityResultContracts.StartActivityForResult contracts1 = new ActivityResultContracts.StartActivityForResult();
        editActivityLauncher = registerForActivityResult(contracts1, callback1);

        tv_title = findViewById(R.id.tv_detail_title);
        tv_content = findViewById(R.id.tv_detail_content);
        tv_writeDate = findViewById(R.id.tv_edit_writeDate);

        //객체를 추출한다.
        Intent intent = getIntent();

        //객체를 복원한다.
        item = intent.getParcelableExtra("item");

        tv_title.setText(item.getTitle());
        tv_content.setText(item.getContent());
        tv_writeDate.setText(item.getWriteDate());
        id = item.getId();

        Button btn_edit = findViewById(R.id.btn_edit);
        btn_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DetailActivity.this, EditActivity.class);
                intent.putExtra("item", item);
                editActivityLauncher.launch(intent);
            }
        });

        Button btn_delete = findViewById(R.id.btn_delete);
        btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent resultIntent = new Intent();

                setResult(2, resultIntent);

                finish();
            }
        });

        Button btn_ok = findViewById(R.id.btn_detail_ok);
        btn_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent resultIntent = new Intent();
                //객체를 생성한다.
                TodoItem resultItem = new TodoItem();
                String edit_title = tv_title.getText().toString();
                String edit_content = tv_content.getText().toString();
                String writeDate = tv_writeDate.getText().toString();
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

    class EditActivityCallback implements ActivityResultCallback<ActivityResult> {
        @Override
        public void onActivityResult(ActivityResult result) {
            //result code를 추출한다.
            int resultCode = result.getResultCode();

            if(resultCode == RESULT_OK){
                //intent 추출한다.
                Intent data = result.getData();

                //객체를 생성해서 result 를 받는다.
                item2 = data.getParcelableExtra("result");

                tv_title.setText(item2.getTitle());
                tv_content.setText(item2.getContent());
                tv_writeDate.setText(item2.getWriteDate());

                Toast.makeText(mContext, "목록 수정이 완료 되었습니다.", Toast.LENGTH_SHORT).show();
            }

        }
    }
}