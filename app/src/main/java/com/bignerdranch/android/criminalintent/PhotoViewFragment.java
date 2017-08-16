package com.bignerdranch.android.criminalintent;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * Created by romananchugov on 16.08.17.
 */

public class PhotoViewFragment extends DialogFragment {

    public static final String EXTRA_PHOTO = "com.bignerdranch.android.criminalintent.photo_view";


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_photo_view, container, false);
        String path = getArguments().getString(EXTRA_PHOTO);
        Bitmap bitmap = PictureUtils.getScaledBitmap(path, getActivity());
        ImageView imageView = (ImageView) view.findViewById(R.id.photo_view);
        imageView.setImageBitmap(bitmap);

        return view;
    }
}
