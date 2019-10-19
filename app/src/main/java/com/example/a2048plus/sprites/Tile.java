package com.example.a2048plus.sprites;

import android.graphics.Canvas;

public class Tile implements Sprite {

    private int screenWidth, screenHeight, standardSize;
    private TileManagerCallback callback;
    private int count = 1;

    public Tile(int standardSize, int screenWidth, int screenHeight, TileManagerCallback callback) {
        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;
        this.standardSize = standardSize;
        this.callback = callback;
    }

    @Override
    public void draw(Canvas canvas) {
        canvas.drawBitmap(callback.getBitmap(count),screenWidth/2 - standardSize, screenHeight/2 - standardSize, null);
    }

    @Override
    public void update() {

    }
}
