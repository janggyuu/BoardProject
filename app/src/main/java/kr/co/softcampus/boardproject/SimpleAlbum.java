package kr.co.softcampus.boardproject;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class SimpleAlbum extends AppCompatActivity {

    ImageView imageView;
    String imgName = "osz.png";    //이미지 이름

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_album);

        imageView = findViewById(R.id.imageView4);

        try{
            String imgPath = getCacheDir() + "/" + imgName; //내부 저장소에 저장되어 있는 이미지 경로
            Bitmap bm = BitmapFactory.decodeFile(imgPath);
            imageView.setImageBitmap(bm);
//            Toast.makeText(this, "파일 로드 성공", Toast.LENGTH_SHORT).show();
        }catch(Exception e){
            Toast.makeText(this, "파일 로드 실패", Toast.LENGTH_SHORT).show();
        }

        Button button = findViewById(R.id.btn_select_image);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openGallay();
            }
        });

        Button button2 = findViewById(R.id.btn_delete_image);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    File file = getCacheDir();  // 내부저장소 캐시 경로를 받아오기
                    File[] flist = file.listFiles();
                    for (int i = 0; i < flist.length; i++) {    // 배열의 크기만큼 반복
                        if (flist[i].getName().equals(imgName)) {   // 삭제하고자 하는 이름과 같은 파일명이 있으면 실행
                            flist[i].delete();  // 파일 삭제
//                            Toast.makeText(getApplicationContext(), "파일 삭제 성공", Toast.LENGTH_SHORT).show();
                        }
                    }
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "파일 삭제 실패", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void openGallay(){
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);

        startActivityForResult(intent, 101);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 101){
            if(resultCode == RESULT_OK){
                Uri fileUri = data.getData();

                ContentResolver resolver = getContentResolver();

                try{
                    InputStream instream = resolver.openInputStream(fileUri);
                    Bitmap imgBitmap = BitmapFactory.decodeStream(instream);
                    imageView.setImageBitmap(imgBitmap);
                    instream.close();

                    saveBitmapTOJpeg(imgBitmap);   //내부 저장소에 저장
                    Toast.makeText(this, "파일 불러오기 성공", Toast.LENGTH_SHORT).show();
                } catch (Exception e){
                    Toast.makeText(this, "파일 불러오기 실패패", Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }
            }
        }
    }

    public void saveBitmapTOJpeg(Bitmap bitmap){  //선택한 이미지 내부 저장소에 저장
        File tempFile = new File(getCacheDir(), imgName);   //파일 경로와 이름 넣기
        try{
            tempFile.createNewFile(); //자동으로 빈 파일 생성
            FileOutputStream out = new FileOutputStream(tempFile); // 파일을 쓸 수 있는 스트림 준비
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, out);   //compress 함수를 사용해 스트림에 비트맵을 저장
            out.close();
            Toast.makeText(this, "파일 저장 성공", Toast.LENGTH_SHORT).show();

        } catch (IOException e) {
            Toast.makeText(this, "파일 저장 실패", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }
}