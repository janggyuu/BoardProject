package kr.co.softcampus.boardproject;

import android.view.View;

public interface OnItemClickListener {

    public void onItemClick(CustomAdapter.ViewHolder holder, View view, int position);
}
