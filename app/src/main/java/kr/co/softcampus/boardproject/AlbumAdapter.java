package kr.co.softcampus.boardproject;

import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AlbumAdapter extends  RecyclerView.Adapter<AlbumAdapter.ViewHolder> {

    public static ArrayList<MyImage> items = new ArrayList<MyImage>();

    public void addItem(MyImage item){
        items.add(item);
    }

    public void setItems(ArrayList<MyImage> items){
        this.items = items;
    }

    public MyImage getItem(int position){
        return items.get(position);
    }

    public void setItem(int position, MyImage item){
        items.set(position, item);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.image_list, parent, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        MyImage item = items.get(position);
        holder.setImageView(item);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void deleteItem(ArrayList<MyImage> items){
        items.remove(0);     //0 번째 사진 지움
    }

    static class ViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageView2);
        }

        public void setImageView(MyImage myImage){
            imageView.setImageBitmap(myImage.getBitmap());
        }
    }
}
