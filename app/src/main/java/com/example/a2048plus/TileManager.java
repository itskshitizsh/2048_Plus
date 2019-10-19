package com.example.a2048plus;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;

import com.example.a2048plus.sprites.Sprite;
import com.example.a2048plus.sprites.Tile;

import java.util.ArrayList;
import java.util.HashMap;

public class TileManager implements TileManagerCallback, Sprite {
    private Resources resources;
    private int standardSize, screenWidth, screenHeight;
    private Tile t;
    private ArrayList<Integer> drawables = new ArrayList<>();
    private HashMap<Integer, Bitmap> tileBitmaps = new HashMap<>();
    private Tile[][] matrix = new Tile[4][4];

    public TileManager(Resources resources, int standardSize, int screenWidth, int screenHeight){
        this.resources = resources;
        this.standardSize = standardSize;
        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;
        initBitmaps();

        t = new Tile(standardSize, screenWidth, screenHeight, this, 1, 1);
        matrix[1][1] = t;
    }

    private void initBitmaps(){
        drawables.add(R.drawable.one);
        drawables.add(R.drawable.two);
        drawables.add(R.drawable.three);
        drawables.add(R.drawable.four);
        drawables.add(R.drawable.five);
        drawables.add(R.drawable.six);
        drawables.add(R.drawable.seven);
        drawables.add(R.drawable.eight);
        drawables.add(R.drawable.nine);
        drawables.add(R.drawable.ten);
        drawables.add(R.drawable.eleven);
        drawables.add(R.drawable.twelve);
        drawables.add(R.drawable.thirteen);
        drawables.add(R.drawable.fourteen);
        drawables.add(R.drawable.fifteen);
        drawables.add(R.drawable.sixteen);

        for(int i=1; i<=16; i++){
            Bitmap bmp = BitmapFactory.decodeResource(resources, drawables.get(i-1));
            Bitmap tileBmp = Bitmap.createScaledBitmap(bmp, standardSize, standardSize,false);
            tileBitmaps.put(i,tileBmp);
        }
    }

    @Override
    public Bitmap getBitmap(int count) {
        return tileBitmaps.get(count);
    }

    @Override
    public void draw(Canvas canvas) {
        t.draw(canvas);
    }

    @Override
    public void update() {
        t.update();
    }

    public void onSwipe(SwipeCallback.Direction direction) {
        switch (direction) {
            case UP:
                t.move(0, 1);
                break;
            case DOWN:
                t.move(3, 1);
                break;
            case LEFT:
                t.move(1, 0);
                break;
            case RIGHT:
                t.move(1, 3);
                break;
        }
    }
}
