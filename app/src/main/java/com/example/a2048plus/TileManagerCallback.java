package com.example.a2048plus;

import android.graphics.Bitmap;

public interface TileManagerCallback {
    Bitmap getBitmap(int count);
}
