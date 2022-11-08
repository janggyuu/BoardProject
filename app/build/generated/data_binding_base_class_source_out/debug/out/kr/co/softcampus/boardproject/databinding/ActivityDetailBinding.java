// Generated by view binder compiler. Do not edit!
package kr.co.softcampus.boardproject.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;
import kr.co.softcampus.boardproject.R;

public final class ActivityDetailBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final Button btnDelete;

  @NonNull
  public final Button btnDetailOk;

  @NonNull
  public final Button btnEdit;

  @NonNull
  public final LinearLayout linearLayout;

  @NonNull
  public final LinearLayout linearLayout2;

  @NonNull
  public final LinearLayout linearLayout3;

  @NonNull
  public final TextView textView10;

  @NonNull
  public final TextView textView2;

  @NonNull
  public final TextView textView4;

  @NonNull
  public final TextView textView6;

  @NonNull
  public final TextView tvDetailContent;

  @NonNull
  public final TextView tvDetailTitle;

  @NonNull
  public final TextView tvEditWriteDate;

  private ActivityDetailBinding(@NonNull ConstraintLayout rootView, @NonNull Button btnDelete,
      @NonNull Button btnDetailOk, @NonNull Button btnEdit, @NonNull LinearLayout linearLayout,
      @NonNull LinearLayout linearLayout2, @NonNull LinearLayout linearLayout3,
      @NonNull TextView textView10, @NonNull TextView textView2, @NonNull TextView textView4,
      @NonNull TextView textView6, @NonNull TextView tvDetailContent,
      @NonNull TextView tvDetailTitle, @NonNull TextView tvEditWriteDate) {
    this.rootView = rootView;
    this.btnDelete = btnDelete;
    this.btnDetailOk = btnDetailOk;
    this.btnEdit = btnEdit;
    this.linearLayout = linearLayout;
    this.linearLayout2 = linearLayout2;
    this.linearLayout3 = linearLayout3;
    this.textView10 = textView10;
    this.textView2 = textView2;
    this.textView4 = textView4;
    this.textView6 = textView6;
    this.tvDetailContent = tvDetailContent;
    this.tvDetailTitle = tvDetailTitle;
    this.tvEditWriteDate = tvEditWriteDate;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityDetailBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityDetailBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_detail, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityDetailBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btn_delete;
      Button btnDelete = ViewBindings.findChildViewById(rootView, id);
      if (btnDelete == null) {
        break missingId;
      }

      id = R.id.btn_detail_ok;
      Button btnDetailOk = ViewBindings.findChildViewById(rootView, id);
      if (btnDetailOk == null) {
        break missingId;
      }

      id = R.id.btn_edit;
      Button btnEdit = ViewBindings.findChildViewById(rootView, id);
      if (btnEdit == null) {
        break missingId;
      }

      id = R.id.linearLayout;
      LinearLayout linearLayout = ViewBindings.findChildViewById(rootView, id);
      if (linearLayout == null) {
        break missingId;
      }

      id = R.id.linearLayout2;
      LinearLayout linearLayout2 = ViewBindings.findChildViewById(rootView, id);
      if (linearLayout2 == null) {
        break missingId;
      }

      id = R.id.linearLayout3;
      LinearLayout linearLayout3 = ViewBindings.findChildViewById(rootView, id);
      if (linearLayout3 == null) {
        break missingId;
      }

      id = R.id.textView10;
      TextView textView10 = ViewBindings.findChildViewById(rootView, id);
      if (textView10 == null) {
        break missingId;
      }

      id = R.id.textView2;
      TextView textView2 = ViewBindings.findChildViewById(rootView, id);
      if (textView2 == null) {
        break missingId;
      }

      id = R.id.textView4;
      TextView textView4 = ViewBindings.findChildViewById(rootView, id);
      if (textView4 == null) {
        break missingId;
      }

      id = R.id.textView6;
      TextView textView6 = ViewBindings.findChildViewById(rootView, id);
      if (textView6 == null) {
        break missingId;
      }

      id = R.id.tv_detail_content;
      TextView tvDetailContent = ViewBindings.findChildViewById(rootView, id);
      if (tvDetailContent == null) {
        break missingId;
      }

      id = R.id.tv_detail_title;
      TextView tvDetailTitle = ViewBindings.findChildViewById(rootView, id);
      if (tvDetailTitle == null) {
        break missingId;
      }

      id = R.id.tv_edit_writeDate;
      TextView tvEditWriteDate = ViewBindings.findChildViewById(rootView, id);
      if (tvEditWriteDate == null) {
        break missingId;
      }

      return new ActivityDetailBinding((ConstraintLayout) rootView, btnDelete, btnDetailOk, btnEdit,
          linearLayout, linearLayout2, linearLayout3, textView10, textView2, textView4, textView6,
          tvDetailContent, tvDetailTitle, tvEditWriteDate);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
