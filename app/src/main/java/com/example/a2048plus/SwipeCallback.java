package com.example.a2048plus;

public interface SwipeCallback {
    void onSwipe(Direction direction);

    enum Direction {
        LEFT,
        RIGHT,
        UP,
        DOWN
    }
}
