// Generated by view binder compiler. Do not edit!
package kr.co.softcampus.boardproject.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;
import kr.co.softcampus.boardproject.R;

public final class ActivitySimpleAlbumBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final Button btnDeleteImage;

  @NonNull
  public final Button btnSelectImage;

  @NonNull
  public final RecyclerView rvImage;

  private ActivitySimpleAlbumBinding(@NonNull LinearLayout rootView, @NonNull Button btnDeleteImage,
      @NonNull Button btnSelectImage, @NonNull RecyclerView rvImage) {
    this.rootView = rootView;
    this.btnDeleteImage = btnDeleteImage;
    this.btnSelectImage = btnSelectImage;
    this.rvImage = rvImage;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivitySimpleAlbumBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivitySimpleAlbumBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_simple_album, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivitySimpleAlbumBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btn_delete_image;
      Button btnDeleteImage = ViewBindings.findChildViewById(rootView, id);
      if (btnDeleteImage == null) {
        break missingId;
      }

      id = R.id.btn_select_image;
      Button btnSelectImage = ViewBindings.findChildViewById(rootView, id);
      if (btnSelectImage == null) {
        break missingId;
      }

      id = R.id.rv_image;
      RecyclerView rvImage = ViewBindings.findChildViewById(rootView, id);
      if (rvImage == null) {
        break missingId;
      }

      return new ActivitySimpleAlbumBinding((LinearLayout) rootView, btnDeleteImage, btnSelectImage,
          rvImage);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
