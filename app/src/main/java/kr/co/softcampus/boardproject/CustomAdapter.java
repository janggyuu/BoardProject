package kr.co.softcampus.boardproject;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {

    private ArrayList<TodoItem> mTodoItems;
    public static Context mContext;
    private DBHelper mDBHelper;

    OnItemClickListener listener;

    public CustomAdapter(ArrayList<TodoItem> todoItems, Context mContext) {
        this.mTodoItems = todoItems;
        this.mContext = mContext;

        mDBHelper = new DBHelper(mContext);
    }


    public void setOnItemClickListener(OnItemClickListener listener){
        this.listener = listener;

    }

    @NonNull
    @Override
    public CustomAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {     //뷰 홀더가 생성할 시점에 자동으로 호출된다. 리사이클러뷰 각각의 뷰를 설정한다고 생각하면 된다.
        View holder = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
        return new ViewHolder(holder, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapter.ViewHolder holder, int position) {    //여러개 뷰 홀더가 필요할때 전부 만들지 않고 기존 뷰 홀더 재활용 하는 함수
        holder.tv_title.setText(mTodoItems.get(position).getTitle());
        holder.tv_writeDate.setText(mTodoItems.get(position).getWriteDate());
    }

    @Override
    public int getItemCount() {
        return mTodoItems.size();
    }

    public final void notifyItemChanged() {
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView tv_title;
        private TextView tv_content;
        private TextView tv_writeDate;

        public ViewHolder(@NonNull View itemView, final OnItemClickListener listener) {
            super(itemView);

            tv_title = itemView.findViewById(R.id.tv_title);
            tv_writeDate = itemView.findViewById(R.id.tv_writeDate);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int curPos = getAdapterPosition(); // 현재 리스트 클릭한 아이템 위치
                    TodoItem todoItem = mTodoItems.get(curPos);

                    if(listener != null){
                        listener.onItemClick(ViewHolder.this, itemView, curPos);
                    }

                    /*String[] strChoiceItems = {"수정하기", "삭제하기"};
                    AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
                    builder.setTitle("원하는 작업을 선택 해주세요");
                    builder.setItems(strChoiceItems, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int position) {
                            if(position == 0){
                                //수정하기
                                Dialog dialog = new Dialog(mContext, android.R.style.Theme_Material_Light_Dialog);
                                dialog.setContentView(R.layout.dialog_edit);
                                EditText et_title = dialog.findViewById(R.id.et_title_);
                                EditText et_content = dialog.findViewById(R.id.et_content_);
                                Button btn_ok = dialog.findViewById(R.id.btn_ok);

                                et_title.setText(todoItem.getTitle());
                                et_content.setText(todoItem.getContent());

                                et_title.setSelection(et_title.getText().length());  //커서를 마지막에 배치 하기

                                btn_ok.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {

                                        //Update from table
                                        String title = et_title.getText().toString();
                                        String content = et_content.getText().toString();
                                        String currentTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()); // 현재 시간 받아오기
                                        String beforeDate = todoItem.getWriteDate();
                                        mDBHelper.UpdateTodo(title, content, currentTime, beforeDate);

                                        //Update UI
                                        todoItem.setTitle(title);
                                        todoItem.setContent(content);
                                        todoItem.setWriteDate(currentTime);
                                        notifyItemChanged(curPos);
                                        dialog.dismiss();
                                        Toast.makeText(mContext, "목록 수정이 완료 되었습니다.", Toast.LENGTH_SHORT).show();

                                    }
                                });

                                dialog.show();

                            }
                            else if(position == 1){
                                //delete from table
                                String beforeTime = todoItem.getWriteDate();
                                mDBHelper.DeleteTodo(beforeTime);

                                //delete UI
                                mTodoItems.remove(curPos);
                                notifyItemRemoved(curPos);
                                Toast.makeText(mContext, "목록이 제거 되었습니다.", Toast.LENGTH_SHORT).show();

                            }
                        }
                    });
                    builder.show();*/

                }
            });
        }
    }

    //액티비티에서 호출되는 함수이며, 현재 어댑터에 새로운 게시글 아이템을 전달받아 추가하는 목적이다.
    public void addItem(TodoItem _item){
        mTodoItems.add(0,_item);   //항상 0번째에 게시글 추가
        notifyItemInserted(0);
    }

    public void setItems(ArrayList<TodoItem> items){
        mTodoItems = items;
    }

    public TodoItem  getItems(int position){
        return mTodoItems.get(position);
    }


}
