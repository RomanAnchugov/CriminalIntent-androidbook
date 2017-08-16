package com.bignerdranch.android.criminalintent;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.view.View;

/**
 * Created by romananchugov on 15.08.17.
 */

public class PictureUtils {
    public static Bitmap getScaledBitmap(String path, View container){
        return getScaledBitmap(path, container.getWidth(), container.getHeight());
    }

    public static Bitmap getScaledBitmap(String path, int distWidth, int distHeight){
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(path, options);

        float scrWidth = options.outWidth;
        float scrHeight = options.outHeight;


        int inSampleSize = 1;
        if(scrHeight > distHeight || scrWidth > distWidth){
            if(scrWidth > scrHeight){
                inSampleSize = Math.round(scrHeight / distHeight);
            }else{
                inSampleSize = Math.round(scrWidth / distWidth);
            }
        }

        options = new BitmapFactory.Options();
        options.inSampleSize = inSampleSize;

        return BitmapFactory.decodeFile(path, options);
    }
    public static Bitmap getScaledBitmap(String path, Activity activity){
        Point size = new Point();

        activity.getWindowManager().getDefaultDisplay().getSize(size);

        return getScaledBitmap(path, size.x, size.y);
    }
}
