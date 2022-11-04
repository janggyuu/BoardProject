package kr.co.softcampus.boardproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ListActivity extends AppCompatActivity {

    private RecyclerView mRv_todo;
    private Button mBtn_write, mBtn_logout;
    private ArrayList<TodoItem> mTodoItems;
    private DBHelper mDBHelper;
    private CustomAdapter mAdapter;
    private FirebaseAuth mFirebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        setInit();

    }

    private void setInit() {
        mDBHelper = new DBHelper(this);
        mRv_todo = findViewById(R.id.rv_todo);
        mBtn_write = findViewById(R.id.btn_write);
        mBtn_logout = findViewById(R.id.btn_logout);
        mTodoItems = new ArrayList<>();

        mFirebaseAuth = FirebaseAuth.getInstance();


        //기존에 저장되어 있던 DB를 가져온다.
        loadRecentDB();

        mBtn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mFirebaseAuth.signOut();

                Intent intent = new Intent(ListActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });

        mBtn_write.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //팝업 창 띄우기
                Dialog dialog = new Dialog(ListActivity.this, android.R.style.Theme_Material_Light_Dialog);
                dialog.setContentView(R.layout.dialog_edit);
                EditText et_title = dialog.findViewById(R.id.et_title_);
                EditText et_content = dialog.findViewById(R.id.et_content_);
                Button btn_ok = dialog.findViewById(R.id.btn_ok);

                btn_ok.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        //Insert Database
                        String currentTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()); // 현재 시간 받아오기
                        mDBHelper.InsertTodo(et_title.getText().toString(), et_content.getText().toString(), currentTime);

                        //Insert UI
                         TodoItem item = new TodoItem();
                         item.setTitle(et_title.getText().toString());
                         item.setContent(et_content.getText().toString());
                         item.setWriteDate(currentTime);

                         mAdapter.addItem(item);
                         mRv_todo.smoothScrollToPosition(0);
                         dialog.dismiss();
                        Toast.makeText(ListActivity.this, "할일 목록에 추가 되었습니다.", Toast.LENGTH_SHORT).show();

                    }
                });

                dialog.show();
            }
        });

    }

    //저장 되어있던 DB를 가져온다
    private void loadRecentDB() {
        mTodoItems = mDBHelper.getTodoList();
        if(mAdapter == null){
            mAdapter = new CustomAdapter(mTodoItems, this);
            mRv_todo.setHasFixedSize(true);    //recycler뷰 성능 강화
            mRv_todo.setAdapter(mAdapter);
        }
    }

}