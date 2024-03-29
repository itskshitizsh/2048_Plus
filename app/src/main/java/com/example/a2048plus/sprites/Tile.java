package com.example.a2048plus.sprites;

import android.graphics.Canvas;

import com.example.a2048plus.TileManagerCallback;

import java.util.Random;

public class Tile implements Sprite {

    private int screenWidth, screenHeight, standardSize;
    private TileManagerCallback callback;
    private int count = 1;
    private int currentX, currentY;
    private int destX, destY;
    private boolean moving = false;
    private int speed = 100;
    private boolean increment = false;

    public Tile(int standardSize, int screenWidth, int screenHeight, TileManagerCallback callback, int matrixX, int matrixY, int count) {
        this(standardSize, screenWidth, screenHeight, callback, matrixX, matrixY);
        this.count = count;
    }

    public Tile(int standardSize, int screenWidth, int screenHeight, TileManagerCallback callback, int matrixX, int matrixY) {
        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;
        this.standardSize = standardSize;
        this.callback = callback;
        currentX = destX = screenWidth / 2 - 2 * standardSize + matrixY * standardSize;
        currentY = destY = screenHeight / 2 - 2 * standardSize + matrixX * standardSize;
        int chance = new Random().nextInt(100);
        if (chance >= 80) {
            if (chance >= 98) {
                count = 5;
            } else if (chance >= 95) {
                count = 4;
            } else if (chance >= 90) {
                count = 3;
            } else {
                count = 2;
            }
        }
    }

    public void move(int matrixX, int matrixY) {
        moving = true;
        destX = screenWidth / 2 - 2 * standardSize + matrixY * standardSize;
        destY = screenHeight / 2 - 2 * standardSize + matrixX * standardSize;
    }

    public int getValue() {
        return count;
    }

    public Tile increment() {
        increment = true;
        return this;
    }

    public boolean toIncrement() {
        return increment;
    }

    @Override
    public void draw(Canvas canvas) {
        canvas.drawBitmap(callback.getBitmap(count), currentX, currentY, null);
        if (moving && currentX == destX && currentY == destY) {
            moving = false;
            if (increment) {
                count++;
                increment = false;
                int amount = (int) Math.pow(2, count);
                callback.updateScore(amount);
                if (count == 11) {
                    callback.reached2048();
                }
            }
            callback.finishedMoving(this);
        }
    }

    @Override
    public void update() {
        if (currentX < destX) {
            if (currentX + speed > destX) {
                currentX = destX;
            } else {
                currentX += speed;
            }
        } else if (currentX > destX) {
            if (currentX - speed < destX) {
                currentX = destX;
            } else {
                currentX -= speed;
            }
        }

        if (currentY < destY) {
            if (currentY + speed > destY) {
                currentY = destY;
            } else {
                currentY += speed;
            }
        } else if (currentY > destY) {
            if (currentY - speed < destY) {
                currentY = destY;
            } else {
                currentY -= speed;
            }
        }
    }
}
