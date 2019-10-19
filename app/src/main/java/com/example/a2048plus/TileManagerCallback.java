package com.example.a2048plus;

import android.graphics.Bitmap;

import com.example.a2048plus.sprites.Tile;

public interface TileManagerCallback {
    Bitmap getBitmap(int count);

    void finishedMoving(Tile t);
}
