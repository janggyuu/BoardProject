package kr.co.softcampus.boardproject;

import android.graphics.Bitmap;
import android.widget.ImageView;


public class MyImage {
    Bitmap bitmap;

    public MyImage(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }
}
