// Generated by view binder compiler. Do not edit!
package kr.co.softcampus.boardproject.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
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

public final class ActivityRegisterBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final Button btnReg;

  @NonNull
  public final EditText etRegContent;

  @NonNull
  public final EditText etRegTitle;

  @NonNull
  public final LinearLayout linearLayout;

  @NonNull
  public final TextView textView2;

  @NonNull
  public final TextView textView5;

  private ActivityRegisterBinding(@NonNull ConstraintLayout rootView, @NonNull Button btnReg,
      @NonNull EditText etRegContent, @NonNull EditText etRegTitle,
      @NonNull LinearLayout linearLayout, @NonNull TextView textView2,
      @NonNull TextView textView5) {
    this.rootView = rootView;
    this.btnReg = btnReg;
    this.etRegContent = etRegContent;
    this.etRegTitle = etRegTitle;
    this.linearLayout = linearLayout;
    this.textView2 = textView2;
    this.textView5 = textView5;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityRegisterBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityRegisterBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_register, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityRegisterBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btn_reg;
      Button btnReg = ViewBindings.findChildViewById(rootView, id);
      if (btnReg == null) {
        break missingId;
      }

      id = R.id.et_reg_content;
      EditText etRegContent = ViewBindings.findChildViewById(rootView, id);
      if (etRegContent == null) {
        break missingId;
      }

      id = R.id.et_reg_title;
      EditText etRegTitle = ViewBindings.findChildViewById(rootView, id);
      if (etRegTitle == null) {
        break missingId;
      }

      id = R.id.linearLayout;
      LinearLayout linearLayout = ViewBindings.findChildViewById(rootView, id);
      if (linearLayout == null) {
        break missingId;
      }

      id = R.id.textView2;
      TextView textView2 = ViewBindings.findChildViewById(rootView, id);
      if (textView2 == null) {
        break missingId;
      }

      id = R.id.textView5;
      TextView textView5 = ViewBindings.findChildViewById(rootView, id);
      if (textView5 == null) {
        break missingId;
      }

      return new ActivityRegisterBinding((ConstraintLayout) rootView, btnReg, etRegContent,
          etRegTitle, linearLayout, textView2, textView5);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
