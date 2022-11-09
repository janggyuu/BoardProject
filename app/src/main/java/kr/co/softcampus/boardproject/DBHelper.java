package kr.co.softcampus.boardproject;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {

    private static final int DB_VERSION = 1;
    private static final String DB_NAME = "board.db";

    public DBHelper(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //데이터 베이스가 생성될 때 호출

        //데이터 베이스 -> 테이블 -> 컬럼 -> 값
        db.execSQL("CREATE TABLE IF NOT EXISTS TodoList(id INTEGER PRIMARY KEY AUTOINCREMENT, title TEXT NOT NULL, content TEXT NOT NULL, writeDate TEXT NOT NULL)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onCreate(db);
    }

    //SELECT 문 (할일 목록들을 조회)
    public ArrayList<TodoItem> getTodoList(){
        ArrayList<TodoItem> todoItems = new ArrayList<>();

        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM TodoList ORDER BY writeDate DESC", null); // * : 모든 데이터를 가져 오겠다란 뜻  ORDER BY DESC 내림차순으로 정렬해서 라는 뜻
        if(cursor.getCount() != 0){
            //조회해온 데이터가 있을때 내부 수행
            while(cursor.moveToNext()){
                int id = cursor.getInt(cursor.getColumnIndexOrThrow("id"));
                String title = cursor.getString(cursor.getColumnIndexOrThrow("title"));
                String content = cursor.getString(cursor.getColumnIndexOrThrow("content"));
                String writeDate = cursor.getString(cursor.getColumnIndexOrThrow("writeDate"));

                TodoItem todoItem = new TodoItem();
                todoItem.setId(id);
                todoItem.setTitle(title);
                todoItem.setContent(content);
                todoItem.setWriteDate(writeDate);

                todoItems.add(todoItem);
            }
        }
        cursor.close();

        return todoItems;
    }

    //Search 문 (할일 목록 검색)
    public ArrayList<TodoItem> searchTodoList(String search_title){
        ArrayList<TodoItem> todoItems = new ArrayList<>();

        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM TodoList ORDER BY writeDate DESC", null); // * : 모든 데이터를 가져 오겠다란 뜻  ORDER BY DESC 내림차순으로 정렬해서 라는 뜻
        if(cursor.getCount() != 0){
            //조회해온 데이터가 있을때 내부 수행
            while(cursor.moveToNext()){
                String title = cursor.getString(cursor.getColumnIndexOrThrow("title"));
                if(search_title == title) {
                    int id = cursor.getInt(cursor.getColumnIndexOrThrow("id"));
                    String content = cursor.getString(cursor.getColumnIndexOrThrow("content"));
                    String writeDate = cursor.getString(cursor.getColumnIndexOrThrow("writeDate"));

                    TodoItem todoItem = new TodoItem();
                    todoItem.setId(id);
                    todoItem.setTitle(title);
                    todoItem.setContent(content);
                    todoItem.setWriteDate(writeDate);

                    todoItems.add(todoItem);
                }
            }
        }
        cursor.close();

        return todoItems;
    }
    // INSERT 문 (할일 목록을 db에 넣는다)
    public void InsertTodo(String _title, String _content, String _writeDate){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("INSERT INTO TodoList(title, content, writeDate) VALUES('" + _title + "', '" + _content + "', '" + _writeDate + "');"); //TodoList에 title, content, writeDate 만 넣을꺼야라고 언급해준다고 생각하면 됨
    }

    // UPDATE 문(할일 목록을 수정한다)
    public void UpdateTodo(String _title, String _content, String _writeDate, String _beforeDate){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("UPDATE TodoList SET title='" + _title + "', content='" + _content + "', writeDate='" + _writeDate + "' WHERE writeDate = '" + _beforeDate + "'");
    }

    //DELETE 문(할일 목록을 제거한다)
    public void DeleteTodo(String _beforeDate){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DELETE FROM TodoList WHERE writeDate = '" + _beforeDate + "'");
    }


}
