package kr.co.softcampus.boardproject;

import static kr.co.softcampus.boardproject.CustomAdapter.mContext;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ListActivity extends AppCompatActivity {

    public static RecyclerView mRv_todo;
    private Button mBtn_write, mBtn_logout;
    public static ArrayList<TodoItem> mTodoItems;
    public static DBHelper mDBHelper;
    public static CustomAdapter mAdapter;
    private FirebaseAuth mFirebaseAuth;
    private TodoItem item;
    private TodoItem item2;
    private int curPos;

    ActivityResultLauncher<Intent> detailActivityLauncher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        DetailActivityCallback callback1 = new DetailActivityCallback();
        ActivityResultContracts.StartActivityForResult contracts1 = new ActivityResultContracts.StartActivityForResult();
        detailActivityLauncher = registerForActivityResult(contracts1, callback1);

        setInit();

        mAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(CustomAdapter.ViewHolder holder, View view, int position) {
                item = mAdapter.getItems(position);
                curPos = position;
                Intent intent = new Intent(ListActivity.this, DetailActivity.class);
                intent.putExtra("item", item);
                detailActivityLauncher.launch(intent);
//                Toast.makeText(ListActivity.this, "item ????????? : " + item.getTitle() , Toast.LENGTH_LONG).show();
            }
        });

        mBtn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mFirebaseAuth.signOut();

                Intent intent = new Intent(ListActivity.this, LoginActivity.class);
                startActivity(intent);
                //             finish();
            }
        });

        mBtn_write.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //RegisterActivity ??? ??????
                Intent intent = new Intent(ListActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
    }

    class DetailActivityCallback implements ActivityResultCallback<ActivityResult> {
        @Override
        public void onActivityResult(ActivityResult result) {
            //result code??? ????????????.
            int resultCode = result.getResultCode();

            if (resultCode == RESULT_OK) {
                //intent ????????????.
                Intent data = result.getData();

                //????????? ???????????? result ??? ?????????.
                item2 = data.getParcelableExtra("result");

                //Update from table
                String title = item2.getTitle();
                String content = item2.getContent();
                String currentTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()); // ?????? ?????? ????????????
                String beforeDate = item.getWriteDate();
                mDBHelper.UpdateTodo(title, content, currentTime, beforeDate);

                //Update UI
                item.setTitle(title);
                item.setContent(content);
                mAdapter.notifyItemChanged(curPos, item);
            }

            if(resultCode == 2){
                //delete from table
                String beforeTime = item.getWriteDate();
                mDBHelper.DeleteTodo(beforeTime);

                //delete UI
                mTodoItems.remove(curPos);
                mAdapter.notifyItemRemoved(curPos);
                Toast.makeText(mContext, "????????? ?????? ???????????????.", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void setInit() {
        mDBHelper = new DBHelper(this);
        mRv_todo = findViewById(R.id.rv_todo);
        mBtn_write = findViewById(R.id.btn_write);
        mBtn_logout = findViewById(R.id.btn_logout);
        mTodoItems = new ArrayList<>();

        mFirebaseAuth = FirebaseAuth.getInstance();


        //????????? ???????????? ?????? DB??? ????????????.
        loadRecentDB();
    }

    //?????? ???????????? DB??? ????????????
    private void loadRecentDB() {
        mTodoItems = mDBHelper.getTodoList();
        mAdapter = new CustomAdapter(mTodoItems, this);
        mRv_todo.setHasFixedSize(true);    //recycler ??? ?????? ??????
        mRv_todo.setAdapter(mAdapter);

    }

}