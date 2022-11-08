package kr.co.softcampus.boardproject;

import android.os.Parcel;
import android.os.Parcelable;

public class TodoItem implements Parcelable {
    private int id;
    private String title;
    private String content;
    private String writeDate;

    public TodoItem() {
    }

    protected TodoItem(Parcel in) {
        id = in.readInt();
        title = in.readString();
        content = in.readString();
        writeDate = in.readString();
    }

    //getParcelableExtra 매서드를 호출해 객체를 추출하는 작업을 할 때
    //CREATOR.createFromParcel 매서드를 호출해 매서드가 반환하는 객체를 전달해 준다.
    //이에, 이 매서드에서 객체를 새롭게 생성하고 Parcel에 저장되어 있는 값을 추출해
    // 객체의 변수에 담아넣어서 객체를 복원하고 반환하는 작업을 수행한다.
    public static final Creator<TodoItem> CREATOR = new Creator<TodoItem>() {
        @Override
        public TodoItem createFromParcel(Parcel in) {
            return new TodoItem(in);
        }

        @Override
        public TodoItem[] newArray(int size) {
            return new TodoItem[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getWriteDate() {
        return writeDate;
    }

    public void setWriteDate(String writeDate) {
        this.writeDate = writeDate;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    // 객체를 Intent에 저장하려고 할 때 자동으로 호출되는 매서드
    // 이 메서드의 첫번째 매개변수로 전달되는 Parcel 객체가 Intent에 담기게 되고
    // 이 Parcel 객체가 다른 Activity로 전달된다.
    // 여기에서는 다른 Activity에서 객체를 생성하고 그 객체에 담을 값을 저장하는
    // 작업을 수행한다.
    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(title);
        parcel.writeString(content);
        parcel.writeString(writeDate);
    }
}
